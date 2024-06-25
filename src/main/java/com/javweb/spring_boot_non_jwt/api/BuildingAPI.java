package com.javweb.spring_boot_non_jwt.api;

import com.javweb.spring_boot_non_jwt.models.BuildingDTO;
import com.javweb.spring_boot_non_jwt.customException.FiledRequiredException;
import com.javweb.spring_boot_non_jwt.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingAPI {
    /*
    * // tu dong new doi tuong
    * them Autowired de no tim duoc cac interface
    * vi interface khong the new doi tuong => null
    *
    *  */
    @Autowired

    private BuildingService buildingService;

	@GetMapping(value = "api/building")
    //http://localhost:8080/api/building?name=abc
   public List<BuildingDTO> getBuilding(@RequestParam(value = "name", required = false) String name) {
       List<BuildingDTO> result = buildingService.findAll(name);
         return result;
   }

}
