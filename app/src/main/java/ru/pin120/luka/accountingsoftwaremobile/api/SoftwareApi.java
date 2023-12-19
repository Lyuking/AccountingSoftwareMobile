package ru.pin120.luka.accountingsoftwaremobile.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.pin120.luka.accountingsoftwaremobile.models.Software;
import ru.pin120.luka.accountingsoftwaremobile.models.SoftwareTechnicalDetails;

public interface SoftwareApi {
    @GET("licences")
    Call<List<Software>> getLicences();
}