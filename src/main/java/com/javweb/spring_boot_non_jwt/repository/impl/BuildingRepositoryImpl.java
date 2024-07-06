package com.javweb.spring_boot_non_jwt.repository.impl;

import com.javweb.spring_boot_non_jwt.repository.BuildingRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;
import utils.StringUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "NguyenDuc@163";

    public static void joinTable(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
        String staffId = (String) params.get("staffId");
        if (StringUtil.checkString(staffId)) {
            sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
        }

        if (typeCode != null && !typeCode.isEmpty()) {
            sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
            sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
        }

        String rentAreaTo = (String) params.get("areaTo");
        String rentAreaFrom = (String) params.get("areaFrom");
        if (StringUtil.checkString(rentAreaTo) || StringUtil.checkString(rentAreaFrom)) {
            sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
        }
    }

    public static void queryNormal(Map<String, Object> params, StringBuilder where) {
        for (Map.Entry<String, Object> it : params.entrySet()) {
            if (!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") && !it.getKey().startsWith("area")
                    && !it.getKey().startsWith("rentPrice")) {
                String value = it.getValue().toString();
                if (StringUtil.checkString(value)) {
                    where.append(" AND b." + it.getKey() + " = '" + value + "'");
                } else {
                    where.append(" AND b." + it.getKey() + " LIKE '%" + value + "%'");
                }
            }
        }
    }

    public static void querySpecial(Map<String, Object> params, List<String> typeCode, StringBuilder where) {
        String staffId = (String) params.get("staffId");
        if (StringUtil.checkString(staffId)) {
            where.append(" AND assignmentbuilding.staffid = " + staffId);
        }
        String rentAreaTo = (String) params.get("areaTo");
        String rentAreaFrom = (String) params.get("areaFrom");
        if (StringUtil.checkString(rentAreaTo) || StringUtil.checkString(rentAreaFrom)) {
            if (StringUtil.checkString(rentAreaFrom)) {
                where.append(" AND rentarea.value >= " + rentAreaFrom);
            }
            if (StringUtil.checkString(rentAreaTo)) {
                where.append(" AND rentarea.value <= " + rentAreaTo);
            }
        }
        String name = (String) params.get("name");
        if (StringUtil.checkString(name)) {
            where.append(" AND b.name LIKE '%" + name + "%'");
        }

        String rentPriceTo = (String) params.get("rentPriceTo");
        String rentPriceFrom = (String) params.get("rentPriceFrom");
        if (StringUtil.checkString(rentPriceTo) || StringUtil.checkString(rentPriceFrom)) {
            if (StringUtil.checkString(rentPriceFrom)) {
                where.append(" AND b.rentprice >= " + rentPriceFrom);
            }
            if (StringUtil.checkString(rentPriceTo)) {
                where.append(" AND b.rentprice <= " + rentPriceTo);
            }
        }
        if (typeCode != null && !typeCode.isEmpty()) {
            List<String> code = new ArrayList<>();
            for (String item : typeCode) {
                code.add("'" + item + "'");
            }
            where.append(" AND renttype.code IN (" + String.join(",", code) + ")");
        }
    }

    @Override
    public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode) {
        StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.ward, b.street, b.districtid, b.structure, b.numberofbasement, b.floorarea, b.rentprice, " +
                "b.managername, b.managername, b.brokeragefee, b.servicefee FROM building b ");
        joinTable(params, typeCode, sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNormal(params, where);
        querySpecial(params, typeCode, where);
        where.append(" GROUP BY b.id");
        sql.append(where);
        System.out.println(sql);

        List<BuildingEntity> result = new ArrayList<>();
        try (Connection conn = java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {
            while (rs.next()) {
                BuildingEntity buildingEntity = new BuildingEntity();
                buildingEntity.setId(rs.getLong("b.id"));
                buildingEntity.setName(rs.getString("b.name"));
                buildingEntity.setWard(rs.getString("b.ward"));
                buildingEntity.setDistrictid(rs.getLong("b.districtid"));
                buildingEntity.setStreet(rs.getString("b.street"));
                buildingEntity.setFloorArea(rs.getLong("b.floorarea"));
                buildingEntity.setRentPrice(rs.getLong("b.rentprice"));
                buildingEntity.setManagerName(rs.getString("b.managername"));
                buildingEntity.setServiceFee(rs.getString("b.servicefee"));
                buildingEntity.setManagerName(rs.getString("b.managername"));
//                buildingEntity.setManagerPhoneNumber(rs.getString("b.managerphonenumber"));
                result.add(buildingEntity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

