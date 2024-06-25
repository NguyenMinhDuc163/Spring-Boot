package com.javweb.spring_boot_non_jwt.repository;

import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;

import java.util.ArrayList;
import java.util.List;

public interface BuildingRepository {
    List<BuildingEntity> findAll (String name);
}
