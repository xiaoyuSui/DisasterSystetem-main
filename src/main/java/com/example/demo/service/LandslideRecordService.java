package com.example.demo.service;


import com.example.demo.entity.LandslideRecord;
import com.example.demo.mapper.LandslideRecordMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Data 2020/5/27 21:40
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Service
public class LandslideRecordService {
    @Autowired(required = false)
    private LandslideRecordMapper mapper;

    public LandslideRecord query(String disasterID){return mapper.query(disasterID);}//按照19位编码查询查询

    public List<LandslideRecord> queryAll(){return mapper.queryAll();}//全部查询

    public int insert(LandslideRecord lr){return mapper.insert(lr);}//插入一条新数据

    public int delete(int id){return mapper.delete(id);}//按照id删除

    public int update(LandslideRecord lr){return mapper.update(lr);}//修改数据

    public int delete19(String disasterID){return mapper.delete19(disasterID);}

    public int update19(LandslideRecord lr){return mapper.update19(lr) ;}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<LandslideRecord> userList = null;
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
    public List<LandslideRecord> findAll(){return mapper.findAll();}
}
