package ru.pin120.luka.accountingsoftwaremobile.models;

import java.util.List;

public class LicenceType {

    private Long id;


    private String name;


    private List<Licence> licences;

    public LicenceType(Long id, String name, List<Licence> licences) {
        this.id = id;
        this.name = name;
        this.licences = licences;
    }

    public LicenceType() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public void setLicences(List<Licence> licences) {
        this.licences = licences;
    }
}
