package com.example.demo.mapper;

import com.example.demo.entity.CollRecord;
import com.example.demo.entity.CommDisaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollRecordMapper {
    CollRecord query(String disasterID);//按照id查询查询

    List<CollRecord> queryAll();//全部查询

    int insert(CollRecord collRecord);//插入一条新数据

    int delete(int id);//按照id删除

    int update(CollRecord collRecord);//修改数据

    List<CollRecord> query19(String disasterID);//按照19位编码查询

    int delete19(String disasterID);//按照19位编码删除

    int update19(CollRecord collRecord);//按照19位编码修改

    List<CollRecord> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<CollRecord> findAll();
}
