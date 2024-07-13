package com.javweb.spring_boot_non_jwt.service.impl;

import com.javweb.spring_boot_non_jwt.builder.BuildingSearchBuilder;
import com.javweb.spring_boot_non_jwt.converter.BuildingDTOConverter;
import com.javweb.spring_boot_non_jwt.converter.BuildingSearchBuilderConverter;
import com.javweb.spring_boot_non_jwt.models.BuildingDTO;
import com.javweb.spring_boot_non_jwt.repository.BuildingRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import com.javweb.spring_boot_non_jwt.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingDTOConverter buildingDTOConverter;

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    @Override
    public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
//        // Chuyen du lieu tu db sang DTO
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeCode);
//        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
        // su dung Spring Data JPA custom
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity buildingEntity : buildingEntities) {
            // Chuyen du lieu tu entity sang DTO
            BuildingDTO buildingDTO = buildingDTOConverter.toBuildingDTO(buildingEntity);
            result.add(buildingDTO);
        }
        return result;
    }

}
