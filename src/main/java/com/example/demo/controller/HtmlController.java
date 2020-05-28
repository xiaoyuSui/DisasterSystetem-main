package com.example.demo.controller;
import com.example.demo.service.CivilSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller

public class HtmlController {
    @Autowired(required = false)
    private CivilSService civilSService;

    @RequestMapping("/commd")
    public String commd(){return "commdisaster";}
    @RequestMapping("/coll")
    public String corrl(){return "collrrecord";}
    @RequestMapping("/request")
    public String requeset(){return "request";}
    @RequestMapping("/test")
    public String test(){return "daohang";}
    @RequestMapping("/total")
    public String total(){return "test";}

    @ResponseBody
    @RequestMapping("/getPage")
    public Map<String,Object> getPage(@RequestParam(value = "limit", required = true) Integer limit,
                                      @RequestParam(value = "offset", required = true) Integer offset){
        return civilSService.getPage(limit,offset);
    }


}

