package com.example.demo.mapper;

import com.example.demo.entity.DeathStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeathStatisticsMapper {
    //update19
    DeathStatistics query(String disasterID);
    int insert(DeathStatistics d);
    int delete(int id);
    List<DeathStatistics> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<DeathStatistics> findAll();
}
