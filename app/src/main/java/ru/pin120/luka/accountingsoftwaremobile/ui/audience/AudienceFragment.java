package ru.pin120.luka.accountingsoftwaremobile.ui.audience;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;


import java.util.ArrayList;
import java.util.List;

import ru.pin120.luka.accountingsoftwaremobile.NotificationHelper;
import ru.pin120.luka.accountingsoftwaremobile.R;
import ru.pin120.luka.accountingsoftwaremobile.api.AudienceApi;
import ru.pin120.luka.accountingsoftwaremobile.api.ServiceApi;
import ru.pin120.luka.accountingsoftwaremobile.databinding.FragmentAudienceBinding;
import ru.pin120.luka.accountingsoftwaremobile.models.Audience;
import ru.pin120.luka.accountingsoftwaremobile.rvadapters.AudienceAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.pin120.luka.accountingsoftwaremobile.ui.BaseFragment;

public class AudienceFragment extends BaseFragment<FragmentAudienceBinding> {

    @Override
    protected Class<? extends ViewModel> getViewModelClass() {
        return AudienceViewModel.class;
    }

    @Override
    protected @NonNull ViewBinding createBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentAudienceBinding.inflate(inflater, container, false);
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.rv_audience;
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new AudienceAdapter();
    }

    @Override
    protected void fetchData(ViewModel viewModel) {
        AudienceApi audienceApi = ServiceApi.getAudienceApi();
        Call<List<Audience>> call = audienceApi.getAudiences();

        call.enqueue(new Callback<List<Audience>>() {
            @Override
            public void onResponse(Call<List<Audience>> call, Response<List<Audience>> response) {
                if (response.isSuccessful()) {
                    List<Audience> audiences = response.body();
                    AudienceViewModel audienceViewModel = (AudienceViewModel) viewModel;
                    audienceViewModel.getText().observe(getViewLifecycleOwner(), data -> {
                        ((AudienceAdapter) getAdapter()).setData(audiences);
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
}