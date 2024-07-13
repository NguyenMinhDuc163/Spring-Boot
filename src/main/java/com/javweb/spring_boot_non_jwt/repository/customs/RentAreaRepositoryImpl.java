//package com.javweb.spring_boot_non_jwt.repository.impl;
//
//import com.javweb.spring_boot_non_jwt.repository.RentAreaRepository;
//import com.javweb.spring_boot_non_jwt.repository.entity.RentAreaEntity;
//import org.springframework.stereotype.Repository;
//import utils.ConnectionUtil;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//TODO dung JPQL khong can cai nay nua
//@Repository
//public class RentAreaRepositoryImpl implements RentAreaRepository {
//    @Override
//    public List<RentAreaEntity> getValueByBuildingId(Long id) {
//        String sql = "SELECT * FROM rentarea WHERE rentarea.buildingid = " + id;
//        List<RentAreaEntity> rentAreas = new ArrayList<>();
//        try (Connection conn = ConnectionUtil.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                RentAreaEntity rentAreaEntity = new RentAreaEntity();
//                rentAreaEntity.setValue(rs.getString("value"));
//                rentAreas.add(rentAreaEntity);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return rentAreas;
//    }
//}
//
