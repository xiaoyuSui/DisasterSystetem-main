package com.example.demo.service;



import com.example.demo.entity.CommDisaster;

import com.example.demo.mapper.CommDisasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommDisasterService {

    @Autowired(required = false)
    private  CommDisasterMapper mapper;

    //public CommDisasterService(CommDisasterMapper mapper){this.mapper = mapper;}

    public List<CommDisaster> queryAll(){return mapper.queryAll();}

    public CommDisaster query(String disasterID){return mapper.query(disasterID);}

    public int insert(CommDisaster commDisaster){return mapper.insert(commDisaster);}

    public int  delete(int id){return mapper.delete(id);}

    public int  delete19(String disasterID){return mapper.delete19(disasterID);}

    public  int update19(CommDisaster commDisaster){return mapper.update19(commDisaster);}


    public  int update(CommDisaster commDisaster){return mapper.update(commDisaster);}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<CommDisaster> userList = null;
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

    public List<CommDisaster> findAll(){
        return  mapper.findAll();
    }

}
