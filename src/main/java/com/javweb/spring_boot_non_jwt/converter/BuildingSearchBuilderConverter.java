package com.javweb.spring_boot_non_jwt.converter;

import com.javweb.spring_boot_non_jwt.builder.BuildingSearchBuilder;
import org.springframework.stereotype.Component;
import utils.MapUtil;

import java.util.List;
import java.util.Map;

@Component // Đánh dấu đây là một Spring Bean
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode){
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder().setName(MapUtil.getObject(params, "name", String.class))
                .setManagerName(MapUtil.getObject(params, "managerName", String.class))
                .setManagerPhoneNumber(MapUtil.getObject(params, "managerPhoneNumber", String.class))
                .setFloorArea(MapUtil.getObject(params, "floorArea", Long.class))
                .setWard(MapUtil.getObject(params, "ward", String.class))
                .setStreet(MapUtil.getObject(params, "street", String.class))
                .setDistrictId(MapUtil.getObject(params, "districtId", Long.class))
                .setNumberOfBasement(MapUtil.getObject(params, "numberOfBasement", Long.class))
                .setTypeCode(typeCode)
                .setRentPriceFrom(MapUtil.getObject(params, "rentPriceFrom", Long.class))
                .setRentPriceTo(MapUtil.getObject(params, "rentPriceTo", Long.class))
                .setAreaFrom(MapUtil.getObject(params, "areaFrom", Long.class))
                .setAreaTo(MapUtil.getObject(params, "areaTo", Long.class))
                .setStaffId(MapUtil.getObject(params, "staffId", Long.class))
                .build();
        return buildingSearchBuilder;
    }
}
