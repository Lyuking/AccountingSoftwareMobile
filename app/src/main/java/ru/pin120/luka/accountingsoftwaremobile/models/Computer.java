package ru.pin120.luka.accountingsoftwaremobile.models;

import java.util.List;

public class Computer {
    public Computer(){ };

    private Long id;


    private String number;


    private Audience audience;


    private String ipAddress;


    private String processor;


    private String videocard;


    private String ram;


    private String totalSpace;


    private List<Software> softwares;

    public Computer(Long id, String number, Audience audience, String ipAddress, String processor, String videocard, String ram, String totalSpace, List<Software> softwares) {
        this.id = id;
        this.number = number;
        this.audience = audience;
        this.ipAddress = ipAddress;
        this.processor = processor;
        this.videocard = videocard;
        this.ram = ram;
        this.totalSpace = totalSpace;
        this.softwares = softwares;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getVideocard() {
        return videocard;
    }

    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(String totalSpace) {
        this.totalSpace = totalSpace;
    }

    public List<Software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<Software> softwares) {
        this.softwares = softwares;
    }
}
