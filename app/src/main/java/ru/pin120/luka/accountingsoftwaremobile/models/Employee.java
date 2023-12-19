package ru.pin120.luka.accountingsoftwaremobile.models;

import java.util.List;

public class Employee {
    public Employee(){ }

    private Long id;


    private String name;


    private String surname;


    private String patronymic;


    private List<Licence> licences;

    public Employee(Long id, String name, String surname, String patronymic, List<Licence> licences) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.licences = licences;
    }


    public String getFullName() {
        return surname + " " + name + " " + (patronymic != null ? patronymic : "");
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public void setLicences(List<Licence> licences) {
        this.licences = licences;
    }
}
