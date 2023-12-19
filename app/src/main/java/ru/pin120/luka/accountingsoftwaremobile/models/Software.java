package ru.pin120.luka.accountingsoftwaremobile.models;

import java.util.Comparator;
import java.util.List;

public class Software {

    private Long id;


    private SoftwareTechnicalDetails softwareTechnicalDetails;


    private Licence licence;


    private List<Computer> computers;

    public Software(Long id, SoftwareTechnicalDetails softwareTechnicalDetails, Licence licence, List<Computer> computers) {
        this.id = id;
        this.softwareTechnicalDetails = softwareTechnicalDetails;
        this.licence = licence;
        this.computers = computers;
    }

    public Software() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SoftwareTechnicalDetails getSoftwareTechnicalDetails() {
        return softwareTechnicalDetails;
    }

    public void setSoftwareTechnicalDetails(SoftwareTechnicalDetails softwareTechnicalDetails) {
        this.softwareTechnicalDetails = softwareTechnicalDetails;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
    public static class SoftwareNameComparator implements Comparator<Software> {

        public int compare(Software a, Software b){
            return a.getSoftwareTechnicalDetails().getName().toUpperCase().compareTo(b.getSoftwareTechnicalDetails().getName().toUpperCase());
        }
    }
}
