package com.javweb.spring_boot_non_jwt.repository;

import com.javweb.spring_boot_non_jwt.repository.entity.RentAreaEntity;

import java.util.List;

public interface RentAreaRepository {
    List<RentAreaEntity> getValueByBuildingId(Long id);
}
