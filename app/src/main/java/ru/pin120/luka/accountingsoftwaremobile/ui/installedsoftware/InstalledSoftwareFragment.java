package ru.pin120.luka.accountingsoftwaremobile.ui.installedsoftware;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.pin120.luka.accountingsoftwaremobile.NotificationHelper;
import ru.pin120.luka.accountingsoftwaremobile.R;
import ru.pin120.luka.accountingsoftwaremobile.api.AudienceApi;
import ru.pin120.luka.accountingsoftwaremobile.api.ComputerApi;
import ru.pin120.luka.accountingsoftwaremobile.api.InstalledSoftwareApi;
import ru.pin120.luka.accountingsoftwaremobile.api.ServiceApi;
import ru.pin120.luka.accountingsoftwaremobile.databinding.FragmentComputerBinding;
import ru.pin120.luka.accountingsoftwaremobile.databinding.FragmentInstalledsoftwareBinding;
import ru.pin120.luka.accountingsoftwaremobile.models.Audience;
import ru.pin120.luka.accountingsoftwaremobile.models.Computer;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.ComputerAdapter;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.InstalledSoftwareAdapter;
import ru.pin120.luka.accountingsoftwaremobile.ui.BaseFragment;
import ru.pin120.luka.accountingsoftwaremobile.ui.computer.ComputerViewModel;

public class InstalledSoftwareFragment extends BaseFragment<FragmentInstalledsoftwareBinding> {
    private final String notChosen = "Не выбрано";
    @Override
    protected Class<? extends ViewModel> getViewModelClass() { return InstalledSoftwareViewModel.class; }

    @Override
    protected @NonNull ViewBinding createBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentInstalledsoftwareBinding.inflate(inflater, container, false);
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.rv_installed_software;
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new InstalledSoftwareAdapter();
    }

    @Override
    protected void fetchData(ViewModel viewModel) {
        InstalledSoftwareApi installedSoftwareApi = ServiceApi.getInstalledSoftwareApi();
        Call<List<Computer>> call = installedSoftwareApi.getComputers();

        call.enqueue(new Callback<List<Computer>>() {
            @Override
            public void onResponse(Call<List<Computer>> call, Response<List<Computer>> response) {
                if (response.isSuccessful()) {
                    List<Computer> computers = response.body();
                    InstalledSoftwareViewModel installedSoftwareViewModel = (InstalledSoftwareViewModel) viewModel;
                    installedSoftwareViewModel.getText().observe(getViewLifecycleOwner(), data -> {
                        ((InstalledSoftwareAdapter) getAdapter()).setData(computers);
                    });
                } else {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                }
            }

            @Override
            public void onFailure(Call<List<Computer>> call, Throwable t) {
                try {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinnerCategories = binding.spinnerInstalledSoftware;

        // Создайте экземпляр CategoriesApi
        AudienceApi audienceApi = ServiceApi.getAudienceApi();

        // Сделайте асинхронный запрос на получение списка категорий
        audienceApi.getAudiences().enqueue(new Callback<List<Audience>>() {
            @Override
            public void onResponse(Call<List<Audience>> call, Response<List<Audience>> response) {
                if (response.isSuccessful()) {
                    List<Audience> audienceList = response.body();

                    List<String> audienceNames = getAudienceNames(audienceList);
                    ArrayAdapter<String> audienceAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, audienceNames);
                    audienceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCategories.setAdapter(audienceAdapter);

                    spinnerCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                            String selectedAudience = position != 0? audienceNames.get(position) : null;
                            ((InstalledSoftwareAdapter) getAdapter()).setSelectedAudience(selectedAudience);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parentView) {
                            ((InstalledSoftwareAdapter) getAdapter()).setSelectedAudience(null);
                        }
                    });
                } else {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");

                }
            }

            @Override
            public void onFailure(Call<List<Audience>> call, Throwable t) {
                try {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private List<String> getAudienceNames(List<Audience> audienceList) {
        List<String> audienceNames = new ArrayList<>();
        audienceNames.add(notChosen);
        for (Audience audience : audienceList) {
            audienceNames.add(audience.getName());
        }
        return audienceNames;
    }
}
