package com.javweb.spring_boot_non_jwt.models;

public class BuildingDTO {
    private String name;
    private Integer numberOfBasement;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getAddress() {
        return address;
    }
}
