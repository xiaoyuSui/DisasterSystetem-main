package com.example.demo.service;

import com.example.demo.entity.DisasterRequest;
import com.example.demo.mapper.DisasterRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Data 2020/5/22 11:42
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Service
public class DisasterRequestService {
    @Autowired(required = false)
    private DisasterRequestMapper mapper;

    public DisasterRequest query(String disasterID){return mapper.query(disasterID);}

    public int insert(DisasterRequest disasterRequest){return mapper.insert(disasterRequest);}

    public int update(DisasterRequest disasterRequest){return mapper.update(disasterRequest);}

    public int delete(int ID){return mapper.delete(ID);}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<DisasterRequest> userList = null;
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
    public List<DisasterRequest> findAll(){return mapper.findAll();}
}
