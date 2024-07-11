package com.javweb.spring_boot_non_jwt.repository.impl;

import com.javweb.spring_boot_non_jwt.builder.BuildingSearchBuilder;
import com.javweb.spring_boot_non_jwt.repository.BuildingRepository;
import com.javweb.spring_boot_non_jwt.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;
import utils.ConnectionUtil;
import utils.StringUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JDBCBuildingRepositoryImpl implements BuildingRepository {

    public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null) {
            sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
        }

        List<String> typeCode = buildingSearchBuilder.getTypeCode();
        if (typeCode != null && !typeCode.isEmpty()) {
            sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
            sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
        }

        // TODO o day co the thay the bang cach su dung exist trong sql
//        String rentAreaTo = (String) params.get("areaTo");
//        String rentAreaFrom = (String) params.get("areaFrom");
//        if (StringUtil.checkString(rentAreaTo) || StringUtil.checkString(rentAreaFrom)) {
//            sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
//        }
    }

    public static void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {


        // Su dung java refactor
        try{
            Field [] fields = buildingSearchBuilder.getClass().getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true); // cho phep truy cap vao private
                Object value = field.get(buildingSearchBuilder); // lay gia tri cua field
                if(value != null){
                    if(value instanceof String){
                        if(StringUtil.checkString((String) value)){
                            where.append(" AND b." + field.getName().toLowerCase() + " LIKE '%" + value + "%'");
                        }
                    }else if(value instanceof Long){
                        where.append(" AND b." + field.getName().toLowerCase() + " = " + value);
                    }else if(value instanceof List){
                        List<String> listValue = (List<String>) value;
                        if(!listValue.isEmpty()){
                            String code = listValue.stream().map(item -> "'" + item + "'").collect(Collectors.joining(","));
                            where.append(" AND renttype.code IN (" + code + ")");
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null) {
            where.append(" AND assignmentbuilding.staffid = " + staffId);
        }
        Long rentAreaTo = buildingSearchBuilder.getAreaTo();
        Long rentAreaFrom = buildingSearchBuilder.getAreaFrom();

        // TODO o day co the thay the bang cach su dung exist trong sql
        if (rentAreaTo != null || rentAreaFrom != null) {
            where.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid ");
            if( rentAreaFrom != null){
                where.append(" AND r.value >= " + rentAreaFrom);
            }
            if( rentAreaTo != null){
                where.append(" AND r.value <= " + rentAreaTo);
            }
            where.append(")");
        }

        String name = buildingSearchBuilder.getName();
        if (StringUtil.checkString(name)) {
            where.append(" AND b.name LIKE '%" + name + "%'");
        }

        Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();
        Long rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
        if (rentPriceTo != null || rentPriceFrom != null) {
            if (rentPriceTo != null) {
                where.append(" AND b.rentprice >= " + rentPriceFrom);
            }
            if (rentPriceFrom != null) {
                where.append(" AND b.rentprice <= " + rentPriceTo);
            }
        }


        // TODO java 8
        List<String> typeCode = buildingSearchBuilder.getTypeCode();
        if (typeCode != null && !typeCode.isEmpty()) {
            String code = typeCode.stream().map(item -> "'" + item + "'").collect(Collectors.joining(","));
            where.append(" AND renttype.code IN (" + code + ")");
        }
    }

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.ward, b.street, b.districtid, b.structure, b.numberofbasement, b.floorarea, b.rentprice, " +
                "b.managerphonenumber, b.managername, b.brokeragefee, b.servicefee FROM building b ");
        joinTable(buildingSearchBuilder, sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNormal(buildingSearchBuilder, where);
        querySpecial(buildingSearchBuilder, where);
        where.append(" GROUP BY b.id");
        sql.append(where);


        List<BuildingEntity> result = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {
            while (rs.next()) {
                BuildingEntity buildingEntity = new BuildingEntity();
                buildingEntity.setId(rs.getLong("b.id"));
                buildingEntity.setName(rs.getString("b.name"));
                buildingEntity.setWard(rs.getString("b.ward"));
//                buildingEntity.setDistrictId(rs.getLong("b.districtid"));
                buildingEntity.setStreet(rs.getString("b.street"));
                buildingEntity.setFloorArea(rs.getLong("b.floorarea"));
                buildingEntity.setRentPrice(rs.getLong("b.rentprice"));
                buildingEntity.setManagerName(rs.getString("b.managername"));
                buildingEntity.setServiceFee(rs.getString("b.servicefee"));
                buildingEntity.setManagerName(rs.getString("b.managername"));
                buildingEntity.setManagerPhoneNumber(rs.getString("b.managerphonenumber"));
                buildingEntity.setBrokeragefee(rs.getString("b.brokeragefee"));
                result.add(buildingEntity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

