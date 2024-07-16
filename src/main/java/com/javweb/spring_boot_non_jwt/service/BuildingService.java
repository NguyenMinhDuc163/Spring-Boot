package com.javweb.spring_boot_non_jwt.service;

import com.javweb.spring_boot_non_jwt.models.BuildingDTO;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode);
}
