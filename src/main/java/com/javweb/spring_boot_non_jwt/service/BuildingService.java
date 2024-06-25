package com.javweb.spring_boot_non_jwt.service;

import com.javweb.spring_boot_non_jwt.models.BuildingDTO;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll(String name);
}
