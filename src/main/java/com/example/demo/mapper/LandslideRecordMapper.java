package com.example.demo.mapper;

import com.example.demo.entity.LandslideRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LandslideRecordMapper {
    LandslideRecord query(String disasterID);//按照id查询查询

    List<LandslideRecord> queryAll();//全部查询

    int insert(LandslideRecord landslideRecord);//插入一条新数据

    int delete(int id);//按照id删除

    int update(LandslideRecord landslideRecord);//修改数据

    List<LandslideRecord> query19(String disasterID);//按照19位编码查询

    int delete19(String disasterID);//按照19位编码删除

    int update19(LandslideRecord landslideRecord);//按照19位编码修改

    List<LandslideRecord> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<LandslideRecord> findAll();
}
