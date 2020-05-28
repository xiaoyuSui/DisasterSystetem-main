package com.example.demo.mapper;



import com.example.demo.entity.CommDisaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommDisasterMapper {



    List<CommDisaster> queryAll();//全部查询

    int insert(CommDisaster commDisaster);//插入一条新数据

    int delete(int id);//按照id删除

    int update(CommDisaster commDisaster);//修改数据

    CommDisaster query(String disasterID);//按照19位编码查询

    int delete19(String disasterID);

    int update19(CommDisaster commDisaster);

    List<CommDisaster> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<CommDisaster> findAll();



}
