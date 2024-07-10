package com.javweb.spring_boot_non_jwt.converter;

import com.javweb.spring_boot_non_jwt.models.BuildingDTO;
import com.javweb.spring_boot_non_jwt.repository.DistrictRepository;
import com.javweb.spring_boot_non_jwt.repository.RentAreaRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import com.javweb.spring_boot_non_jwt.repository.entity.DistrictEntity;
import com.javweb.spring_boot_non_jwt.repository.entity.RentAreaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingDTOConverter {

    // TODO dung JPQL khong can cai nay nua
//    @Autowired
//    private DistrictRepository districtRepository;

//    @Autowired
//    private RentAreaRepository rentAreaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public BuildingDTO toBuildingDTO(BuildingEntity buildingEntity){
        // Chuyen du lieu tu entity sang DTO bang cach su dung modelMapper
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);

        //TODO cach thuong
//        DistrictEntity districtEntity = districtRepository.findNameById(buildingEntity.getDistrictId());
//        buildingDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + districtEntity.getName());
//        List<RentAreaEntity> rentAreaEntities = rentAreaRepository.getValueByBuildingId(buildingEntity.getId());
//        String areaResult = rentAreaEntities.stream().map(RentAreaEntity::getValue).collect(Collectors.joining(","));

        // TODO dung JPQL
        DistrictEntity districtEntity = buildingEntity.getDistrict();
        buildingDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + districtEntity.getName());
        List<RentAreaEntity> rentAreaEntities = buildingEntity.getRentAreaEntities();
        String areaResult = rentAreaEntities.stream().map(RentAreaEntity::getValue).collect(Collectors.joining(","));


        buildingDTO.setRentArea(areaResult);
        return buildingDTO;
    }

}
