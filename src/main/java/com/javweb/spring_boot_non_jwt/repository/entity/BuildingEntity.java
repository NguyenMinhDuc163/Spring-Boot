package com.javweb.spring_boot_non_jwt.repository.entity;

public class BuildingEntity {
   private Long id;
   private String name;
   private String ward;
    private String street;
    private Long districtid;
    private String managerName;
    private String managerPhoneNumber;
    private Long floorArea;
    private Long numberOfBasement;
    private String emptyArea;
    private Long rentPrice;
    private String serviceFee;
    private String brokerageFree;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
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

    public void setNumberOfBasement(Long numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public void setEmptyArea(String emptyArea) {
        this.emptyArea = emptyArea;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }



    public void setBrokerageFree(String brokerageFree) {
        this.brokerageFree = brokerageFree;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Long getDistrictid() {
        return districtid;
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

    public Long getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getEmptyArea() {
        return emptyArea;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getBrokerageFree() {
        return brokerageFree;
    }
}
