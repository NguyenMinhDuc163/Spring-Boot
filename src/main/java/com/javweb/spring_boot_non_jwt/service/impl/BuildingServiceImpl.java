package com.javweb.spring_boot_non_jwt.service.impl;

import com.javweb.spring_boot_non_jwt.models.BuildingDTO;
import com.javweb.spring_boot_non_jwt.repository.BuildingRepository;
import com.javweb.spring_boot_non_jwt.repository.DistrictRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import com.javweb.spring_boot_non_jwt.repository.entity.DistrictEntity;
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
    private DistrictRepository districtRepository;

    @Override
    public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
        // Chuyen du lieu tu db sang DTO
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, typeCode);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity buildingEntity : buildingEntities) {
            BuildingDTO buildingDTO = new BuildingDTO();
            buildingDTO.setName(buildingEntity.getName());
            DistrictEntity districtEntity = districtRepository.findNameById(buildingEntity.getDistrictid());
            buildingDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + districtEntity.getName());
            result.add(buildingDTO);
        }
        return result;
    }

}
