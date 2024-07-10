package com.javweb.spring_boot_non_jwt.repository.impl;

import com.javweb.spring_boot_non_jwt.builder.BuildingSearchBuilder;
import com.javweb.spring_boot_non_jwt.repository.BuildingRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Primary // khi spring boot can inject BuildingRepository no se inject BuildingRepositoryImpl
public class BuildingRepositoryImpl implements BuildingRepository {

    @PersistenceContext// dung de chen, sua, xoa du lieu
    private EntityManager entityManager; // EntityManager dung de thuc hien cac thao tac voi database

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {

        //TODO JPQL
//        String sql = "FROM BuildingEntity b";
//        Query query = entityManager.createQuery(sql, BuildingEntity.class);

        // TODO SQL native
        StringBuilder sql = new StringBuilder("SELECT * FROM building b WHERE 1 = 1");
        //.class vi neu khong no chi co moi value khong co key
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}
