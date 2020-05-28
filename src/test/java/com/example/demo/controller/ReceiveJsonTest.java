package com.example.demo.controller;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveJsonTest {

    @Test
    void getString() throws IOException {
        String x = "{\n" +
                "    \"idCommDisaster\" : 1,\n" +
                "    \"key2\" : \"string\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(x);
        String name = jsonObject.get("idCommDisaster").toString();
        File root = new File(".");
        String rootDir = root.getCanonicalPath();
        rootDir += "\\src\\336\\CommDisaster\\";
        System.out.println("当前工程所在文件夹：" + rootDir);
        rootDir += "\\" + name + ".json";
        File file = new File(rootDir);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//如果文件不存在，建一个文件

        BufferedWriter writer = null;

        //写入
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
        PrintWriter out = new PrintWriter(writer);
        out.write(jsonObject.toString());
        out.println();
        writer.close();
        out.close();

    }
}