package ru.pin120.luka.accountingsoftwaremobile.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.pin120.luka.accountingsoftwaremobile.models.Software;

public class ServiceApi {
    private static final String BASE_URL = "http://192.168.0.31:8080/api/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static AudienceApi getAudienceApi() {
        return retrofit.create(AudienceApi.class);
    }
    public static ComputerApi getComputerApi() { return retrofit.create(ComputerApi.class); }
    public static EmployeeApi getEmployeeApi() { return retrofit.create(EmployeeApi.class); }
    public static SoftwareTechnicalDetailsApi getSoftwareTechnicalDetailsApi() { return retrofit.create(SoftwareTechnicalDetailsApi.class); }
    public static SoftwareApi getSoftwareApi() { return retrofit.create(SoftwareApi.class); }
    public static InstalledSoftwareApi getInstalledSoftwareApi() {return retrofit.create(InstalledSoftwareApi.class); }
}
