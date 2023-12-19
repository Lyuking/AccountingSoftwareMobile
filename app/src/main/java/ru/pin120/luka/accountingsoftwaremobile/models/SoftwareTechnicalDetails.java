package ru.pin120.luka.accountingsoftwaremobile.models;

import java.util.List;

public class SoftwareTechnicalDetails {

    public SoftwareTechnicalDetails(){ }
    private Long id;


    private String name;


    private SubjectArea subjectArea;


    private String description;


    private String requiredSpace;


    private String photo;


    private List<Software> softwares;

    public SoftwareTechnicalDetails(Long id, String name, SubjectArea subjectArea, String description, String requiredSpace, String photo, List<Software> softwares) {
        this.id = id;
        this.name = name;
        this.subjectArea = subjectArea;
        this.description = description;
        this.requiredSpace = requiredSpace;
        this.photo = photo;
        this.softwares = softwares;
    }

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

    public SubjectArea getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(SubjectArea subjectArea) {
        this.subjectArea = subjectArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSpace() {
        return requiredSpace;
    }

    public void setRequiredSpace(String requiredSpace) {
        this.requiredSpace = requiredSpace;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<Software> softwares) {
        this.softwares = softwares;
    }
}
