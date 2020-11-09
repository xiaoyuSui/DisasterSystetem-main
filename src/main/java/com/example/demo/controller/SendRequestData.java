package com.example.demo.controller;

import com.example.demo.entity.DisasterRequest;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.net.InetAddress;

@Controller
@RequestMapping("/send")
public class SendRequestData {

    @RequestMapping(value = "/readData", method = RequestMethod.POST)
    public String readData(@RequestBody DisasterRequest disasterRequest){
        System.out.println("request arrive");
        int type = -1;
        try {
            type = Integer.parseInt(disasterRequest.getDisasterType());
        }catch (Exception e) {
            e.printStackTrace();
        }
        String url;
        String name="";
        String[] namelist = new String[]{"DeathStatistics", "MissingStatistics"
                , "CivilStructure", "MasonryStructure", "TrafficDisaster", "CommDisaster"
                , "CollRecord", "LandslideRecord", "DisasterInfo", "DisaPrediction"};
        int[] typelist = new int[]{111, 113, 221, 223, 331, 336, 441, 442, 551, 552};
        for (int i=0;i<typelist.length;i++) {
            if (typelist[i]==type) {
                name = namelist[i];
                break;
            }
        }
        if (name.equals("")){

            System.out.println("no type");
            return "error";
        }
        try {
            System.out.println("try");
            //获取当前服务器地址
            InetAddress address = InetAddress.getLocalHost();
            //url = address.getHostAddress();
            url= ResourceUtils.getURL("classpath:").getPath();
            url = url +type+"/"+name+".json";
            System.out.println(url);

            File file = new File("D:\\Program Files\\apache-tomcat-8.5.55\\webapps\\mshd\\WEB-INF\\classes\\111\\DeathStatistics.json");//定义一个file对象，用来初始化FileReader
            System.out.println("new file");
            FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
            System.out.println("read file");
            BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
            System.out.println("buffer file");
            StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
            String s = "";
            while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
                System.out.println(s);
            }
            bReader.close();
            String str = sb.toString();
            System.out.println(str);
            return sendData(disasterRequest,str);
        }catch (Exception e){
            System.out.println("catch");
            e.printStackTrace();
            return "error";
        }
    }

    public String sendData(DisasterRequest disasterRequest,String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        String str = DisasterPost.post(jsonObject,disasterRequest.getoURL());
        if (str.equals("success"))
            disasterRequest.setStatus(1);
        return str;
    }
}

