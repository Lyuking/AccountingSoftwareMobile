package ru.pin120.luka.accountingsoftwaremobile.ui.computer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import ru.pin120.luka.accountingsoftwaremobile.api.ServiceApi;
import ru.pin120.luka.accountingsoftwaremobile.databinding.FragmentAudienceBinding;
import ru.pin120.luka.accountingsoftwaremobile.databinding.FragmentComputerBinding;
import ru.pin120.luka.accountingsoftwaremobile.models.Audience;
import ru.pin120.luka.accountingsoftwaremobile.models.Computer;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.AudienceAdapter;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.ComputerAdapter;
import ru.pin120.luka.accountingsoftwaremobile.ui.BaseFragment;
import ru.pin120.luka.accountingsoftwaremobile.ui.audience.AudienceViewModel;

public class ComputerFragment extends BaseFragment<FragmentComputerBinding> {
    @Override
    protected Class<? extends ViewModel> getViewModelClass() {
        return ComputerViewModel.class;
    }

    @Override
    protected @NonNull ViewBinding createBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentComputerBinding.inflate(inflater, container, false);
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.rv_computer;
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new ComputerAdapter();
    }

    @Override
    protected void fetchData(ViewModel viewModel) {
        ComputerApi computerApi = ServiceApi.getComputerApi();
        Call<List<Computer>> call = computerApi.getComputers();

        call.enqueue(new Callback<List<Computer>>() {
            @Override
            public void onResponse(Call<List<Computer>> call, Response<List<Computer>> response) {
                if (response.isSuccessful()) {
                    List<Computer> computers = response.body();
                    ComputerViewModel computerViewModel = (ComputerViewModel) viewModel;
                    computerViewModel.getText().observe(getViewLifecycleOwner(), data -> {
                        ((ComputerAdapter) getAdapter()).setData(computers);
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
}