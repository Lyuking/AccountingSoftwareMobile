package ru.pin120.luka.accountingsoftwaremobile.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.pin120.luka.accountingsoftwaremobile.models.Computer;

public interface InstalledSoftwareApi {
    @GET("installedSoftwares")
    Call<List<Computer>> getComputers();
}
