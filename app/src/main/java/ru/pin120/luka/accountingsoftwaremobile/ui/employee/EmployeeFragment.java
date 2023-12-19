package ru.pin120.luka.accountingsoftwaremobile.ui.employee;

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
import ru.pin120.luka.accountingsoftwaremobile.api.AudienceApi;
import ru.pin120.luka.accountingsoftwaremobile.api.EmployeeApi;
import ru.pin120.luka.accountingsoftwaremobile.api.ServiceApi;
import ru.pin120.luka.accountingsoftwaremobile.databinding.FragmentEmployeeBinding;
import ru.pin120.luka.accountingsoftwaremobile.models.Audience;
import ru.pin120.luka.accountingsoftwaremobile.models.Employee;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.AudienceAdapter;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.EmployeeAdapter;
import ru.pin120.luka.accountingsoftwaremobile.ui.BaseFragment;
import ru.pin120.luka.accountingsoftwaremobile.ui.audience.AudienceViewModel;

public class EmployeeFragment extends BaseFragment<FragmentEmployeeBinding> {


    @Override
    protected Class<? extends ViewModel> getViewModelClass() {
        return EmployeeViewModel.class;
    }

    @NonNull
    @Override
    protected ViewBinding createBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentEmployeeBinding.inflate(inflater, container, false);
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.rv_employee;
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new EmployeeAdapter();
    }

    @Override
    protected void fetchData(ViewModel viewModel) {
        EmployeeApi employeeApi = ServiceApi.getEmployeeApi();
        Call<List<Employee>> call = employeeApi.getEmployees();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (response.isSuccessful()) {
                    List<Employee> employees = response.body();
                    EmployeeViewModel employeeViewModel = (EmployeeViewModel) viewModel;
                    employeeViewModel.getText().observe(getViewLifecycleOwner(), data -> {
                        ((EmployeeAdapter) getAdapter()).setData(employees);
                    });
                } else {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                try {
                    NotificationHelper.showNotification(requireContext(), "Нет доступа к серверу", "На данный момент доступ к серверу отсутствует, повторите попытку позднее.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}