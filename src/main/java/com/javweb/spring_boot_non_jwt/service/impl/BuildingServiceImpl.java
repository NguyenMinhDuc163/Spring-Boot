package com.javweb.spring_boot_non_jwt.service.impl;

import com.javweb.spring_boot_non_jwt.models.BuildingDTO;
import com.javweb.spring_boot_non_jwt.repository.BuildingRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import com.javweb.spring_boot_non_jwt.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<BuildingDTO> findAll(String name) {
        // Chuyen du lieu tu db sang DTO
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(name);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity buildingEntity : buildingEntities) {
            BuildingDTO buildingDTO = new BuildingDTO();
            buildingDTO.setName(buildingEntity.getName());
            buildingDTO.setNumberOfBasement(buildingEntity.getNumberOfBasement());
            // su ly va tra theo yc client
            buildingDTO.setAddress(buildingEntity.getWard() + " " + buildingEntity.getStreet());
            result.add(buildingDTO);
        }
        return result;
    }
}
