package com.javweb.spring_boot_non_jwt.repository.impl;

import com.javweb.spring_boot_non_jwt.repository.BuildingRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String DB_URL = "jdbc:mysql://spring-app-network:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "NguyenDuc@163";
    @Override
    public List<BuildingEntity> findAll(String name, Long districtId) {
        // neu nguoid dung khong nhap gi thi tra ve tat ca
        StringBuilder  sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1 ");

        if(name != null && !name.isEmpty()) {
            sql.append(" AND name LIKE '%" + name + "%' ");
        }

        if(districtId != null) {
            sql.append(" AND districtid = " + districtId +" ");
        }

        List<BuildingEntity> buildingEntities = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString());) {
            while (rs.next()) {
                BuildingEntity buildingEntity = new BuildingEntity();
                buildingEntity.setName(rs.getString("name"));
                buildingEntity.setNumberOfBasement(rs.getInt("numberofbasement"));
                buildingEntity.setWard(rs.getString("ward"));
                buildingEntity.setStreet(rs.getString("street"));
                buildingEntities.add(buildingEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buildingEntities;
    }
}
