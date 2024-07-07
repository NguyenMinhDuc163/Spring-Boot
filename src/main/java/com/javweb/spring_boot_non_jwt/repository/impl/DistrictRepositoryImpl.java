package com.javweb.spring_boot_non_jwt.repository.impl;

import com.javweb.spring_boot_non_jwt.repository.DistrictRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.DistrictEntity;
import org.springframework.stereotype.Repository;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Repository
public class DistrictRepositoryImpl implements DistrictRepository {


    @Override
    public DistrictEntity findNameById(Long id) {
        String sql = "SELECT d.name FROM district d  WHERE d.id = " + id + ";";
        DistrictEntity districtEntity = new DistrictEntity();
        try (Connection conn = ConnectionUtil.getConnection();
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
