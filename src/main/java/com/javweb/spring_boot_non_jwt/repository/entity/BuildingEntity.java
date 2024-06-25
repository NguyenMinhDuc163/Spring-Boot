package com.javweb.spring_boot_non_jwt.repository.entity;

public class BuildingEntity {
    private String name;
    private Integer numberOfBasement;
    private String ward;
    private String street;

    public String getName() {
        return name;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
