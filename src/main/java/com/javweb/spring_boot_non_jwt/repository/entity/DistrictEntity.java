package com.javweb.spring_boot_non_jwt.repository.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "district")
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "district",fetch = FetchType.LAZY)
    private List<BuildingEntity> buildings = new ArrayList<>();

    public List<BuildingEntity> getItems() {
        return buildings;
    }

    public void setItems(List<BuildingEntity> items) {
        this.buildings = items;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
