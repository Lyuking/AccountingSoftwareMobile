package ru.pin120.luka.accountingsoftwaremobile.models;

import java.util.List;

public class SubjectArea {

    private Long id;


    private String name;


    private List<SoftwareTechnicalDetails> softwareTechnicalDetailses;

    public SubjectArea(Long id, String name, List<SoftwareTechnicalDetails> softwareTechnicalDetailses) {
        this.id = id;
        this.name = name;
        this.softwareTechnicalDetailses = softwareTechnicalDetailses;
    }

    public SubjectArea() { }

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

    public List<SoftwareTechnicalDetails> getSoftwareTechnicalDetailses() {
        return softwareTechnicalDetailses;
    }

    public void setSoftwareTechnicalDetailses(List<SoftwareTechnicalDetails> softwareTechnicalDetailses) {
        this.softwareTechnicalDetailses = softwareTechnicalDetailses;
    }
}
