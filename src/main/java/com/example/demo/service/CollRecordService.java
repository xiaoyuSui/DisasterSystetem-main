package com.example.demo.service;

import com.example.demo.entity.CollRecord;
import com.example.demo.entity.CommDisaster;
import com.example.demo.mapper.CollRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollRecordService {

    @Autowired(required = false)
    private CollRecordMapper mapper;

    public CollRecord query(String disasterID){return mapper.query(disasterID);}//按照19位编码查询查询

    public List<CollRecord> queryAll(){return mapper.queryAll();}//全部查询

    public int insert(CollRecord collRecord){return mapper.insert(collRecord);}//插入一条新数据

    public int delete(int id){return mapper.delete(id);}//按照id删除

    public int update(CollRecord collRecord){return mapper.update(collRecord);}//修改数据

    public int delete19(String disasterID){return mapper.delete19(disasterID);}

    public int update19(CollRecord collRecord){return mapper.update19(collRecord) ;}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<CollRecord> userList = null;
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
    public List<CollRecord> findAll(){return mapper.findAll();}
}
