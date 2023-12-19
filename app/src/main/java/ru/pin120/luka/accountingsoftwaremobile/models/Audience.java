package ru.pin120.luka.accountingsoftwaremobile.models;


import java.util.ArrayList;
import java.util.List;

public class Audience {
    public Audience(){}
    public Audience(String number, Long id) {
        this.name = number;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String number) {
        this.name = number;
    }

    private String name;

    public Long getId() {
        return id;
    }

    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    List<Computer> computerList = new ArrayList<>();
    private Long id;
}
