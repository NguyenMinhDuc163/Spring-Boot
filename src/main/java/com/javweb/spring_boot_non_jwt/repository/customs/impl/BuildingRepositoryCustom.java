package com.javweb.spring_boot_non_jwt.repository.customs.impl;

import com.javweb.spring_boot_non_jwt.builder.BuildingSearchBuilder;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}