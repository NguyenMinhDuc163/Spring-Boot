package com.javweb.spring_boot_non_jwt.api;

import com.javweb.spring_boot_non_jwt.models.BuildingDTO;
import com.javweb.spring_boot_non_jwt.models.BuildingRequestDTO;
import com.javweb.spring_boot_non_jwt.repository.BuildingRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import com.javweb.spring_boot_non_jwt.repository.entity.DistrictEntity;
import com.javweb.spring_boot_non_jwt.service.BuildingService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@PropertySource("classpath:application.properties") // load file properties
public class BuildingAPI {
    /*
    * // tu dong new doi tuong
    * them Autowired de no tim duoc cac interface
    * vi interface khong the new doi tuong => null
    *
    *  */
    @Autowired
    private BuildingService buildingService;
    // TODO test ne de o day => dangg le xuong repository
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BuildingRepository buildingRepository; // khi dung spring data jpa

	@GetMapping(value = "api/building")
    //http://localhost:8080/api/building?name=abc
    public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
                                         @RequestParam(name="typeCode", required = false) List<String> typeCode) {
        List<BuildingDTO> result = buildingService.findAll(params, typeCode);
        return result;
    }

//    @GetMapping(value = "api/building/{id}")
//    //http://localhost:8080/api/building?name=abc
//    public BuildingDTO getBuildingById(@PathVariable Long id){
//        BuildingDTO result = new BuildingDTO();
//        BuildingEntity buildingEntity = buildingRepository.findById(id).get(); // tim theo  primary key
//        result.setName(buildingEntity.getName());
//        result.setAddress(buildingEntity.getWard() + " " + buildingEntity.getStreet());
//        return result;
//    }
// su dung spring data jpa
    @GetMapping(value = "api/building/{name}")
    //http://localhost:8080/api/building?name=abc
    public BuildingDTO getBuildingById(@PathVariable String name){
        BuildingDTO result = new BuildingDTO();
        BuildingEntity buildingEntity = buildingRepository.findByNameContaining(name); // tim theo  primary key
        result.setName(buildingEntity.getName());
        result.setAddress(buildingEntity.getWard() + " " + buildingEntity.getStreet());
        return result;
    }


    // test
    @PostMapping(value = "api/building")
    @Transactional
    public void createBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setName(buildingRequestDTO.getName());
        buildingEntity.setWard(buildingRequestDTO.getWard());
        buildingEntity.setStreet(buildingRequestDTO.getStreet());
        buildingEntity.setRentPrice(buildingRequestDTO.getRentPrice());

        Long districtId = buildingRequestDTO.getDistrictId();
        if (districtId != null) {
            DistrictEntity districtEntity = new DistrictEntity();
            districtEntity.setId(districtId);
            buildingEntity.setDistrict(districtEntity);
        } else {
            throw new IllegalArgumentException("District ID cannot be null");
        }

        entityManager.persist(buildingEntity); // save to database
    }

//    @PutMapping(value = "api/building")
//    @Transactional
//    public void updateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
//        BuildingEntity buildingEntity = new BuildingEntity();
//        buildingEntity.setId(buildingEntity.getId()); // gan cung
//        buildingEntity.setName(buildingRequestDTO.getName());
//        buildingEntity.setWard(buildingRequestDTO.getWard());
//        buildingEntity.setStreet(buildingRequestDTO.getStreet());
//        buildingEntity.setRentPrice(buildingRequestDTO.getRentPrice());
//
//        Long districtId = buildingRequestDTO.getDistrictId();
//        if (districtId != null) {
//            DistrictEntity districtEntity = new DistrictEntity();
//            districtEntity.setId(districtId);
//            buildingEntity.setDistrict(districtEntity);
//        } else {
//            throw new IllegalArgumentException("District ID cannot be null");
//        }
//
//        entityManager.merge(buildingEntity); // update to database
//    }

    // su dung spring data jpa
    @PutMapping(value = "api/building")
    @Transactional
    public void updateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
        // neu khong co id => tao moi
//        BuildingEntity buildingEntity = new BuildingEntity();
        // tim theo id => co the su dung de update
        BuildingEntity buildingEntity = buildingRepository.findById(buildingRequestDTO.getId()).get();


        buildingEntity.setId(buildingEntity.getId()); // gan cung
        buildingEntity.setName(buildingRequestDTO.getName());
        buildingEntity.setWard(buildingRequestDTO.getWard());
        buildingEntity.setStreet(buildingRequestDTO.getStreet());
        buildingEntity.setRentPrice(buildingRequestDTO.getRentPrice());

        Long districtId = buildingRequestDTO.getDistrictId();
        if (districtId != null) {
            DistrictEntity districtEntity = new DistrictEntity();
            districtEntity.setId(districtId);
            buildingEntity.setDistrict(districtEntity);
            buildingRepository.save(buildingEntity);
        } else {
            throw new IllegalArgumentException("District ID cannot be null");
        }
    }

//    @DeleteMapping(value = "api/building")
//    @Transactional
//    public void deleteBuilding(@RequestParam Long id) {
//        BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, id); // tim theo  primary key
//        entityManager.remove(buildingEntity); // delete to database
//    }
    // su dung spring data jpa
    @DeleteMapping(value = "api/building/{id}")
    public void deleteBuildingById(@PathVariable Long id) {
       buildingRepository.deleteById(id);
    }

    /*
    * request
    * {
    *  "name": "abc",
    * "ward": "abc",
    * "street": "abc",
    * "rentPrice": 100,
    * "districtId": 1
    *
    *
    * */
}
