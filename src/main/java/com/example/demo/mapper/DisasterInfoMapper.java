package com.example.demo.mapper;

import com.example.demo.entity.DisasterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DisasterInfoMapper {
    DisasterInfo query(String disasterID);
    List<DisasterInfo> queryAll();
    int insert(DisasterInfo disasterInfo);
    int delete(int ID);
    int update(DisasterInfo disasterInfo);


    List<DisasterInfo> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<DisasterInfo> findAll();
}
