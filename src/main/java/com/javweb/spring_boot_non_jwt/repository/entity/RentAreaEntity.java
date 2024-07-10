package com.javweb.spring_boot_non_jwt.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    String value;

    @ManyToOne
    @JoinColumn(name = "buildingid")

    private BuildingEntity building;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
