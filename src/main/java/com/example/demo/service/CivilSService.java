package com.example.demo.service;

import com.example.demo.entity.CivilStructure;
import com.example.demo.entity.CollRecord;
import com.example.demo.mapper.CivilSMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CivilSService {
    @Autowired(required = false)
    private CivilSMapper mapper;

    public CivilStructure query(String disasterID){return mapper.query(disasterID);}

    public int insert(CivilStructure structure){return mapper.insert(structure);}

    public int update(CivilStructure civilStructure){return mapper.update(civilStructure);}

    public int delete(int ID){return mapper.delete(ID);}

    public Map<String,Object> getPage(Integer limit, Integer offset){
        Map<String,Object> resultMap = new HashMap();
        List<CivilStructure> userList = null;
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
    public List<CivilStructure> findAll(){return mapper.findAll();}
}
