package com.example.demo.controller;

import com.example.demo.entity.CollRecord;
import com.example.demo.entity.DisasterRequest;
import com.example.demo.service.CollRecordService;

import com.example.demo.service.DisasterRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Request")
public class DisasterRequestController {
    @Autowired(required = false)
    private DisasterRequestService disasterRequestService;

    @RequestMapping("/index")
    public String map(){return "collrrecord";}

    @ResponseBody
    @RequestMapping("/getPage")
    public Map<String,Object> getPage(@RequestParam(value = "limit", required = true) Integer limit,
                                      @RequestParam(value = "offset", required = true) Integer offset){
        return disasterRequestService.getPage(limit,offset);
    }

    @ResponseBody
    @RequestMapping("/insert")
    public int InsertDP(@RequestBody DisasterRequest disasterRequest){return  disasterRequestService.insert(disasterRequest);}



    @ResponseBody
    @RequestMapping("/findAll")
    public List<DisasterRequest> findAll(){return disasterRequestService.findAll();}

    @ResponseBody
    @RequestMapping("/update")
    public int UpdateDP(@RequestBody DisasterRequest disasterRequest){return  disasterRequestService.update(disasterRequest);}




}
