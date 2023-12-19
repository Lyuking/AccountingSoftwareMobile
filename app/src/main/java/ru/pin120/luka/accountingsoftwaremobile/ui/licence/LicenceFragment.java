package ru.pin120.luka.accountingsoftwaremobile.ui.licence;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.pin120.luka.accountingsoftwaremobile.NotificationHelper;
import ru.pin120.luka.accountingsoftwaremobile.R;
import ru.pin120.luka.accountingsoftwaremobile.api.ServiceApi;
import ru.pin120.luka.accountingsoftwaremobile.api.SoftwareApi;
import ru.pin120.luka.accountingsoftwaremobile.databinding.FragmentLicenceBinding;
import ru.pin120.luka.accountingsoftwaremobile.models.Software;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.SoftwareAdapter;
import ru.pin120.luka.accountingsoftwaremobile.ui.BaseFragment;

public class LicenceFragment extends BaseFragment<FragmentLicenceBinding> {
    @Override
    protected Class<? extends ViewModel> getViewModelClass() {
        return LicenceViewModel.class;
    }

    @NonNull
    @Override
    protected ViewBinding createBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentLicenceBinding.inflate(inflater, container, false);
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.rv_licence;
    }

    @Override
    protected RecyclerView.Adapter createAdapter() { return new SoftwareAdapter(); }
    @Override
    protected void fetchData(ViewModel viewModel) {
        SoftwareApi softwareApi = ServiceApi.getSoftwareApi();
        Call<List<Software>> call = softwareApi.getLicences();

        call.enqueue(new Callback<List<Software>>() {
            @Override
            public void onResponse(Call<List<Software>> call, Response<List<Software>> response) {
                if (response.isSuccessful()) {
                    List<Software> licences = response.body().stream().sorted(new Software.SoftwareNameComparator()).collect(Collectors.toList());
                    LicenceViewModel licenceViewModel = (LicenceViewModel) viewModel;
                    licenceViewModel.getText().observe(getViewLifecycleOwner(), data -> {
                        ((SoftwareAdapter) getAdapter()).setData(licences);
                    });
                } else {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                }
            }

            @Override
            public void onFailure(Call<List<Software>> call, Throwable t) {
                try {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}