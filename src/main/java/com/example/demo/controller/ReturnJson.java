package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @Data 2020/6/2 2:50
 * @Author ruary
 * @Version 1.0
 * @Describe 数据库表中的数据，以 Json 格式写到指定目录（例如灾情信 息类型 DisasterType=336：URL/336/CommDisaster）
 **/
@Controller
@RequestMapping("/return")
public class ReturnJson {
    @Autowired(required = false)
    private DeathStatisticsService deathStatisticsService;//111

    @Autowired(required = false)
    private MissingStatisticsService missingStatisticsService;//113

    @Autowired(required = false)
    private CivilSService civilSService;//221

    @Autowired(required = false)
    private MasonryStructureService masonryStructureService;//223

    @Autowired(required = false)
    private TrafficDisasterService trafficDisasterService;//331

    @Autowired(required = false)
    private CommDisasterService commDisasterService;//336

    @Autowired(required = false)
    private CollRecordService collRecordService;//441

    @Autowired(required = false)
    private LandslideRecordService landslideRecordService;//442

    @Autowired(required = false)
    private DisasterInfoService disasterInfoService;//551

    @Autowired(required = false)
    private DisaPredictionService disaPredictionService;//552

    public String getReturnURL(int i){
        if(i<10){
            Integer[] type = new Integer[]{111, 113, 221, 223, 331, 336, 441, 442, 551, 552};
            String[] name = new String[]{"DeathStatistics", "MissingStatistics"
                    , "CivilStructure", "MasonryStructure", "TrafficDisaster", "CommDisaster"
                    , "CollRecord", "LandslideRecord", "DisasterInfo", "DisaPrediction"};
            return new String("\\"+type[i]+"\\"+name[i]+".json");
        }else {
            return "#";
        }
    }


    public void saveToURL() {
        StringBuffer[] sb = new StringBuffer[]{};
        String url;
        Integer[] type = new Integer[]{111, 113, 221, 223, 331, 336, 441, 442, 551, 552};
        String[] name = new String[]{"DeathStatistics", "MissingStatistics"
                , "CivilStructure", "MasonryStructure", "TrafficDisaster", "CommDisaster"
                , "CollRecord", "LandslideRecord", "DisasterInfo", "DisaPrediction"};
        List<DeathStatistics> list111 = deathStatisticsService.findAll();

        for (DeathStatistics d : list111) {
            //每一行MySQL查询返回的disasterType类型的
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[0].append(jsonObject.toString());
        }
        List<MissingStatistics> list113 = missingStatisticsService.findAll();
        for (MissingStatistics d : list113) {
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[1].append(jsonObject.toString());
        }
        List<CivilStructure> list221 = civilSService.findAll();
        for (CivilStructure d : list221) {
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[2].append(jsonObject.toString());
        }
        List<MasonryStructure> list223 = masonryStructureService.findAll();
        for (MasonryStructure d : list223) {
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[3].append(jsonObject.toString());
        }
        List<TrafficDisaster> list331 = trafficDisasterService.findAll();
        for (TrafficDisaster t : list331) {
            JSONObject jsonObject = JSONObject.fromObject(t);
            sb[4].append(jsonObject.toString());
        }
        List<CommDisaster> list336 = commDisasterService.findAll();
        for (CommDisaster d : list336) {
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[5].append(jsonObject.toString());
        }
        List<CollRecord> list441 = collRecordService.findAll();
        for (CollRecord d : list441) {
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[6].append(jsonObject.toString());
        }
        List<LandslideRecord> list442 = landslideRecordService.findAll();
        for (LandslideRecord d : list442) {
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[7].append(jsonObject.toString());
        }
        List<DisasterInfo> list551 = disasterInfoService.findAll();
        for (DisasterInfo d : list551) {
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[8].append(jsonObject.toString());
        }
        List<DisaPrediction> list552 = disaPredictionService.findAll();
        for (DisaPrediction d : list552) {
            JSONObject jsonObject = JSONObject.fromObject(d);
            sb[9].append(jsonObject.toString());
        }

        try {
            File file = null;
            BufferedWriter writer = null;
            PrintWriter out = null;
            //获取当前服务器地址
            InetAddress address = InetAddress.getLocalHost();
            url = address.getHostAddress();
            for(int i=0;i<name.length;i++){
                 file = new File(url +"\\"+type[i]);
                //首先需要建立目录
                file.mkdirs();
                file = new File(url +"\\"+type[i]+"\\"+name[i]+".json");
                //创建文件
                if(!file.exists()){
                    file.createNewFile();
                }

                //写入
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false),"UTF-8"));
                out = new PrintWriter(writer);
                out.write(String.valueOf(sb[i]));
                out.println();
            }
            writer.close();
            out.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
