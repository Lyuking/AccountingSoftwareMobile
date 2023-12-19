package ru.pin120.luka.accountingsoftwaremobile.ui.software;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.pin120.luka.accountingsoftwaremobile.NotificationHelper;
import ru.pin120.luka.accountingsoftwaremobile.R;
import ru.pin120.luka.accountingsoftwaremobile.api.EmployeeApi;
import ru.pin120.luka.accountingsoftwaremobile.api.ServiceApi;
import ru.pin120.luka.accountingsoftwaremobile.api.SoftwareTechnicalDetailsApi;
import ru.pin120.luka.accountingsoftwaremobile.databinding.FragmentSoftwareBinding;
import ru.pin120.luka.accountingsoftwaremobile.models.Employee;
import ru.pin120.luka.accountingsoftwaremobile.models.SoftwareTechnicalDetails;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.EmployeeAdapter;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.SoftwareTechnicalDetailsAdapter;
import ru.pin120.luka.accountingsoftwaremobile.ui.BaseFragment;
import ru.pin120.luka.accountingsoftwaremobile.ui.employee.EmployeeViewModel;

public class SoftwareFragment extends BaseFragment<FragmentSoftwareBinding> {


    @Override
    protected Class<? extends ViewModel> getViewModelClass() {
        return SoftwareViewModel.class;
    }

    @NonNull
    @Override
    protected ViewBinding createBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentSoftwareBinding.inflate(inflater, container, false);
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.rv_software;
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new SoftwareTechnicalDetailsAdapter();
    }

    @Override
    protected void fetchData(ViewModel viewModel) {
        SoftwareTechnicalDetailsApi softwareTechnicalDetailsApi = ServiceApi.getSoftwareTechnicalDetailsApi();
        Call<List<SoftwareTechnicalDetails>> call = softwareTechnicalDetailsApi.getSoftwares();

        call.enqueue(new Callback<List<SoftwareTechnicalDetails>>() {
            @Override
            public void onResponse(Call<List<SoftwareTechnicalDetails>> call, Response<List<SoftwareTechnicalDetails>> response) {
                if (response.isSuccessful()) {
                    List<SoftwareTechnicalDetails> softwares = response.body();
                    SoftwareViewModel softwareViewModel = (SoftwareViewModel) viewModel;
                    softwareViewModel.getText().observe(getViewLifecycleOwner(), data -> {
                        ((SoftwareTechnicalDetailsAdapter) getAdapter()).setData(softwares);
                    });
                } else {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                }
            }

            @Override
            public void onFailure(Call<List<SoftwareTechnicalDetails>> call, Throwable t) {
                try {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}