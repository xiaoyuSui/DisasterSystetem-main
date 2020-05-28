package com.example.demo.mapper;

import com.example.demo.entity.DisasterRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DisasterRequestMapper {
    DisasterRequest query(String disasterID);
    int insert(DisasterRequest request);
    int delete(int ID);

    List<DisasterRequest> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<DisasterRequest> findAll();
    int update(DisasterRequest request);
}
