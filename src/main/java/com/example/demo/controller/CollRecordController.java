package com.example.demo.controller;

import com.example.demo.entity.CollRecord;
import com.example.demo.service.CollRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/testCollR")
public class CollRecordController {
    @Autowired(required = false)
    private CollRecordService collRecordService;

    @RequestMapping("/index")
    public String map(){return "collrrecord";}

    @ResponseBody
    @RequestMapping("/getPage")
    public Map<String,Object> getPage(@RequestParam(value = "limit", required = true) Integer limit,
                                      @RequestParam(value = "offset", required = true) Integer offset){
        return collRecordService.getPage(limit,offset);
    }

    @ResponseBody
    @RequestMapping("/insert")
    public int InsertDP(@RequestBody CollRecord collRecord){return  collRecordService.insert(collRecord);}



    @ResponseBody
    @RequestMapping("/update")
    public int UpdateDP(@RequestBody CollRecord collRecord){return  collRecordService.update19(collRecord);}

    @ResponseBody
    @RequestMapping("/search/{id}")
    public CollRecord search(@PathVariable("id") String disasterID) {
        return collRecordService.query(disasterID);
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public int delete(@PathVariable("id") String disasterID) {

        return collRecordService.delete19(disasterID);
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public List<CollRecord> findAll(){return collRecordService.findAll();}




}
