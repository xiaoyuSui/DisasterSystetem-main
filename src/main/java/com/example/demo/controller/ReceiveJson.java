package com.example.demo.controller;

import com.example.demo.entity.CommDisaster;
import com.example.demo.service.CommDisasterService;
import com.fasterxml.jackson.core.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/post")
public class ReceiveJson {
    @Autowired(required = false)
    private CommDisasterService commDisasterService;
//    @Resource
//    protected HttpServletRequest request;
    @RequestMapping(value="/authentication",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public String getString() throws UnsupportedEncodingException, IOException {
        System.out.println("进入=====================");
        //后台接收
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8");
        char [] buff=new char[1024];
        int length=0;
        String x=null;
        while((length=reader.read(buff))!=-1){
            x=new String(buff,0,length);
            System.out.println(x);
        }

        //String joStr = "{name:\"张三\",age:\"20\"}";//将json字符串转化为JSONObject
        JSONObject jsonObject = JSONObject.fromObject(x);
        System.out.println(jsonObject.toString());


        //判断disasterType的第一位，创建对应的实体类对象（eg:目前默认336，创建了）

        //响应
        //Map<String,Object> jsonObject = new HashMap<String, Object>(); //创建Json对象
//        jsonObject.put("username", "张三");     //设置Json对象的属性
//        jsonObject.put("password", "123456");
        CommDisaster commDisaster=new CommDisaster();
       // commDisaster.setIdCommDisaster(Integer.parseInt(jsonObject.get("idCommDisaster").toString()));
        commDisaster.setDisasterID(jsonObject.get("disasterID").toString());
        commDisaster.setDisasterDate(jsonObject.get("disasterDate").toString());
        //读202和key=location取到的值合起来，存到commondisaster的lcocation属性中
        commDisaster.setLocation(jsonObject.get("location").toString());
        commDisaster.setDisasterType(jsonObject.get("disasterType").toString());
        commDisaster.setGrade(jsonObject.get("grade").toString());
        commDisaster.setNote(jsonObject.get("note").toString());
        commDisaster.setReportingUnit(jsonObject.get("reportingUnit").toString());
/*
        FileWriter fileWriter = null;
        File file = new File(".");//获得当前文件夹（工程目录）
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fileWriter);
            out.write(x,0,x.length()-1);
            out.close();
            System.out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        //19位编码解析，解析出的结果用commDisaster.set存储




        commDisasterService.insert(commDisaster);

        return "index";
        //return jsonObject.toString();
    }
}
