package com.javweb.spring_boot_non_jwt.repository;

import com.javweb.spring_boot_non_jwt.repository.entity.DistrictEntity;

public interface DistrictRepository {
    DistrictEntity findNameById(Long id);
}
