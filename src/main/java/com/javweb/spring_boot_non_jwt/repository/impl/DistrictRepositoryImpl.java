package com.javweb.spring_boot_non_jwt.repository.impl;

import com.javweb.spring_boot_non_jwt.repository.DistrictRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.DistrictEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "NguyenDuc@163";

    @Override
    public DistrictEntity findNameById(Long id) {
        String sql = "SELECT d.name FROM district d  WHERE d.id = " + id + ";";
        DistrictEntity districtEntity = new DistrictEntity();
        try (Connection conn = java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                districtEntity.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return districtEntity;
}
}
