package com.javweb.spring_boot_non_jwt.repository;

import com.javweb.spring_boot_non_jwt.repository.customs.impl.BuildingRepositoryCustom;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
    // Cac ham tu viet co san

    // xoa 1 list theo ID
    void deleteByIdIn(List<Long> ids);

    // tim theo ten
    // Chú ý tên hàm phải đúng cú phap findBy{du lieu muon tim kiem}Containing
    BuildingEntity findByNameContaining(String name);
}
