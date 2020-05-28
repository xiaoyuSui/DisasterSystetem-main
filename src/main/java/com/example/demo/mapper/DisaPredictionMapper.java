package com.example.demo.mapper;
import com.example.demo.entity.DisaPrediction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DisaPredictionMapper {
    DisaPrediction query(String disasterID);
    List<DisaPrediction> queryAll();
    int insert(DisaPrediction dp);
    int delete(int ID);
    int update(DisaPrediction dp);


    List<DisaPrediction> getpage(@Param("stratRow") Integer stratRow, @Param("endRow") Integer endRow);

    Integer findAllCount();

    List<DisaPrediction> findAll();
}
