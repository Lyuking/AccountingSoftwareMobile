package ru.pin120.luka.accountingsoftwaremobile.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LicenceDetails {

    public LicenceDetails() { }

    private Long id;


    private String licenceKey;


    private String dateStart;


    private String dateEnd;



    private float price;


    private int count;


    private Licence licence;

    public LicenceDetails(Long id, String licenceKey, String dateStart, String dateEnd, float price, int count, Licence licence) {
        this.id = id;
        this.licenceKey = licenceKey;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.price = price;
        this.count = count;
        this.licence = licence;
    }

   /* public String getDateStart(){
        if(this.dateStart != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            return sdf.format(this.dateStart);
        }
        return null;
    }
    public void setDateStart(String val){
        if(val != null && !val.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                this.dateStart = sdf.parse(val);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public String getDateEnd(){
        if(this.dateEnd != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            return sdf.format(this.dateEnd); // Форматируем дату в строку
        }
        return null;
    }
    public void setDateEnd(String val) {
        if (val != null && !val.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                this.dateEnd = sdf.parse(val);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicenceKey() {
        return licenceKey;
    }

    public void setLicenceKey(String licenceKey) {
        this.licenceKey = licenceKey;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
    public String getDateEnd(){ return this.dateEnd;}
    public String getDateStart(){ return this.dateStart;}
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }
}
