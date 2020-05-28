package com.example.demo.mapper;

import com.example.demo.entity.CivilStructure;
import com.example.demo.entity.CollRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CivilSMapper {
    CivilStructure query(String disasterID);
    int insert(CivilStructure civilStructure);
    int delete(int ID);

    List<CivilStructure> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<CivilStructure> findAll();
    int update(CivilStructure civilStructure);
}
