package com.example.demo.service;

import com.example.demo.entity.CollRecord;
import com.example.demo.entity.DisaPrediction;
import com.example.demo.mapper.DisaPredictionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DisaPredictionService {
    @Autowired(required = false)
    private DisaPredictionMapper mapper;

    public DisaPrediction query(String disasterID) {
        return mapper.query(disasterID);
    }

    public List<DisaPrediction> queryAll() {
        return mapper.queryAll();
    }

    public int insert(DisaPrediction dp) {
        return mapper.insert(dp);
    }

    public int delete(int ID) {
        return mapper.delete(ID);
    }

    public int update(DisaPrediction dp) {
        return mapper.update(dp);
    }

    public Map<String, Object> getPage(Integer limit, Integer offset) {
        Map<String, Object> resultMap = new HashMap();
        List<DisaPrediction> userList = null;
        Integer total = 0;
        try {
            userList = mapper.getpage(offset, limit);
            total = mapper.findAllCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultMap.put("data", userList);
        resultMap.put("total", total);
        return resultMap;
    }

    public List<DisaPrediction> findAll() {
        return mapper.findAll();
    }
}
