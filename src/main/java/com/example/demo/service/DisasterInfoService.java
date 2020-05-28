package com.example.demo.service;

import com.example.demo.entity.DisasterInfo;
import com.example.demo.mapper.DisasterInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Data 2020/5/27 11:18
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Service
public class DisasterInfoService {

    @Autowired(required = false)
    private DisasterInfoMapper mapper;

    public DisasterInfo query(String disasterID) {
        return mapper.query(disasterID);
    }

    public List<DisasterInfo> queryAll() {
        return mapper.queryAll();
    }

    public int insert(DisasterInfo dp) {
        return mapper.insert(dp);
    }

    public int delete(int ID) {
        return mapper.delete(ID);
    }

    public int update(DisasterInfo dp) {
        return mapper.update(dp);
    }

    public Map<String, Object> getPage(Integer limit, Integer offset) {
        Map<String, Object> resultMap = new HashMap();
        List<DisasterInfo> userList = null;
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

    public List<DisasterInfo> findAll() {
        return mapper.findAll();
    }
}
