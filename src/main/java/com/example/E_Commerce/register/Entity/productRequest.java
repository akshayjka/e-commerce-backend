package com.example.E_Commerce.register.Entity;

import java.time.LocalDate;

public class productRequest {
private String name;
    private String description;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public String getManufactureFrom() {
        return manufactureFrom;
    }
    public void setManufactureFrom(String manufactureFrom) {
        this.manufactureFrom = manufactureFrom;
    }
    public String getPlaceOfSale() {
        return placeOfSale;
    }
    public void setPlaceOfSale(String placeOfSale) {
        this.placeOfSale = placeOfSale;
    }
    public LocalDate getDateOfManufactured() {
        return dateOfManufactured;
    }
    public void setDateOfManufactured(LocalDate dateOfManufactured) {
        this.dateOfManufactured = dateOfManufactured;
    }
    private double price;
    private String images;
    private String manufactureFrom;
    private String placeOfSale;
    private LocalDate dateOfManufactured;
}
