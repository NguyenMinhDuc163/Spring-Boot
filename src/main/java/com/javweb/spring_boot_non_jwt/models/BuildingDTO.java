package com.javweb.spring_boot_non_jwt.models;

public class BuildingDTO {
   private String name;
   private String address;
   private String managerName;
   private String managerPhoneNumber;
   private Long floorArea;
   private String rentArea;
   private String emptyArea;
   private String rentPrice;
   private String serviceFee;
   private String brokerageFree;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public void setEmptyArea(String emptyArea) {
        this.emptyArea = emptyArea;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public void setBrokerageFree(String brokerageFree) {
        this.brokerageFree = brokerageFree;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public String getRentArea() {
        return rentArea;
    }

    public String getEmptyArea() {
        return emptyArea;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public String getBrokerageFree() {
        return brokerageFree;
    }
}
