package com.example.demo.service;

import com.example.demo.entity.DeathStatistics;
import com.example.demo.mapper.DeathStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeathStatisticsService {
    @Autowired(required = false)
    private DeathStatisticsMapper mapper;

    public DeathStatistics query(String disasterID){return mapper.query(disasterID);}

    public int insert(DeathStatistics structure){return mapper.insert(structure);}

    public int delete(int ID){return mapper.delete(ID);}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<DeathStatistics> userList = null;
        Integer total = 0;
        try {
            userList = mapper.getpage(offset,limit);
            total = mapper.findAllCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("data",userList);
        resultMap.put("total",total);
        return resultMap;
    }
    public List<DeathStatistics> findAll(){return mapper.findAll();}
}
