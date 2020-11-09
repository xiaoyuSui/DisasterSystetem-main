package com.example.demo;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//解析19位编码
public class Resolving {
    private String code;
    private String kind;
    private String location;
    private String location_name;
    private String kind_name;
    private Workbook wb = null;

    //tring kind_path = "E:\\Study\\Axb\\src\\main\\resources\\data\\kind_data.xls";
    //String kind_path = "..\\..\\..\\..\\..\\resources\\data\\kind_data.xls";
    String kind_path = "src\\main\\resources\\data\\kind_data.xls";
    //String location_path = "E:\\Study\\Axb\\src\\main\\resources\\data\\location_data.xls";
    //String location_path = "..\\..\\..\\..\\resources\\data\\location_data.xls";
    String location_path = "src\\main\\resources\\data\\location_data.xls";

    //构造函数，传入19位编码
    public Resolving(String code) throws IOException {
        this.code = code;
        location = code.substring(0,12);
        kind = code.substring(12);
        location_name = "";
        kind_name = "";
        resolveLocation();
        resolveKind();
        location_name = location_name+"白云镇-白云村";
        System.out.println("Location: "+location_name);
        System.out.println("Kind: "+kind_name);
    }

    //开始解析location信息
    public void resolveLocation() throws IOException {
        File file_location = new File(location_path);
        //判断文件是否存在
        if(file_location.isFile()&&file_location.exists()){
            String[] split = file_location.getName().split("\\.");
            if ( "xls".equals(split[1])){
                //文件流对象
                FileInputStream fis = new FileInputStream(file_location);
                wb = new HSSFWorkbook(fis);
                System.out.println("location open success");
            }else {
                System.out.println("文件类型错误!");
                return;
            }
        }
        else return;
        //解析第一个Sheet
        Sheet sheet = wb.getSheetAt(0);

        //共遍历3个level
        int level_num = 3;
        int row_num = sheet.getLastRowNum();
        int index = 0;
        String parent_id = "0.0";

        for(int i=1;i<=level_num;i++){
            int j=0;
            //遍历area_level列的数据
            while (j<row_num){
                Row row = sheet.getRow(j);
                //当前级别 地区的id
                String area_id = row.getCell(0).toString();
                String area_name = row.getCell(1).toString();
                String cur_parent_id = row.getCell(2).toString();
                String area_level= row.getCell(3).toString().charAt(0)+"";

                //找到当前级别的数据
                if(area_level.equals(""+i)){
                    //和parent_id进行比较，判断是否正确
                    if(cur_parent_id.equals(parent_id)){
                        //如果area_id号码对应
                        if(location.substring(index,index+2).equals(area_id.substring(index,index+2))){
                            index+=2;
                            parent_id = area_id;
                            location_name+=area_name+"-";
                            break;
                        }
                    }
                }
                j++;
            }
        }
    }

    public void resolveKind() throws IOException {
        File file_kind = new File(kind_path);
        //判断文件是否存在
        if(file_kind.isFile()&&file_kind.exists()){
            String[] split = file_kind.getName().split("\\.");
            if ( "xls".equals(split[1])){
                //文件流对象
                FileInputStream fis = new FileInputStream(file_kind);
                wb = new HSSFWorkbook(fis);
                System.out.println("kind open success");
            }else {
                System.out.println("文件类型错误!");
                return;
            }
        }
        else return;
        //解析第一个Sheet
        Sheet sheet = wb.getSheetAt(0);

        //共遍历3个level
        int level_num = 2;
        int row_num = sheet.getLastRowNum();
        int index = 0;
        String parent_id = "0.0";

        for(int i=1;i<=level_num;i++) {
            int j = 1;
            //遍历disaster_level列的数据
            while (j < row_num) {
                Row row = sheet.getRow(j);
                //当前级别 地区的id
                String disaster_id = row.getCell(0).toString();
                String disaster_kind = row.getCell(1).toString().charAt(0)+"";
                String disaster_level = row.getCell(2).toString().charAt(0)+"";
                String cur_parent_id = row.getCell(3).toString();
                String disaster_name = row.getCell(4).toString();

                if(disaster_level.equals(i+"")) {
                    //和parent_id进行比较，判断是否正确
                    if(cur_parent_id.equals(parent_id)){
                        //如果disaster_id号码对应
                        if(kind.substring(index,index+i).equals(disaster_id.substring(index,index+i))){
                            index+=i;
                            parent_id = disaster_id;
                            kind_name+=disaster_name+"-";
                            break;
                        }
                    }
                }
                j++;
            }
        }

    }
}
