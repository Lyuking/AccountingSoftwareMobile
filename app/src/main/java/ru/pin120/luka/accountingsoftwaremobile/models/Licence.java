package ru.pin120.luka.accountingsoftwaremobile.models;

public class Licence {

    public Licence(){ }

    private Long id;


    private Employee employee;


    private LicenceType licenceType;


    private LicenceDetails licenceDetails;


    private Software software;

    public Licence(Long id, Employee employee, LicenceType licenceType, LicenceDetails licenceDetails, Software software) {
        this.id = id;
        this.employee = employee;
        this.licenceType = licenceType;
        this.licenceDetails = licenceDetails;
        this.software = software;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LicenceType getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(LicenceType licenceType) {
        this.licenceType = licenceType;
    }

    public LicenceDetails getLicenceDetails() {
        return licenceDetails;
    }

    public void setLicenceDetails(LicenceDetails licenceDetails) {
        this.licenceDetails = licenceDetails;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }
}
