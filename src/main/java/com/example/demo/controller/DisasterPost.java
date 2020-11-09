package com.example.demo.controller;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/testPost")
public class DisasterPost {
    @RequestMapping(value = "/receive", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public String receive() throws UnsupportedEncodingException, IOException {
        System.out.println("进入=====================");
//        后台接收
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8");
        char [] buff=new char[1024];
        int length=0;
        String x;
        while((length=reader.read(buff))!=-1){
            x=new String(buff,0,length);
            System.out.println(x);
        }

        return "success";
    }

//    @RequestMapping(value = "/testpost", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public static String post(JSONObject json, String path) {
        String result = "";
        try {
            System.out.println(json.toString());
            HttpClient client = new DefaultHttpClient();
            System.out.println("client创建");
            String url= path;
            HttpPost post = new HttpPost(url);
            System.out.println("HttpPost创建");
            post.setHeader("Content-Type", "appliction/json");
            post.addHeader("Authorization", "Basic YWRtaW46");

            StringEntity s = new StringEntity(json.toString(), "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "appliction/json"));
            post.setEntity(s);
            System.out.println("String实体注入");
            HttpResponse httpResponse = client.execute(post);
            System.out.println("执行post请求");
            InputStream in = httpResponse.getEntity().getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                strber.append(line + "\n");
            }
            in.close();
            result = strber.toString();
            System.out.println(result);
            if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                result = "服务器异常";
                return "failsend";
            }
        } catch (Exception e) {
            System.out.println("请求异常");
//            e.printStackTrace();
            return "failsend";
//            throw new RuntimeException(e);
        }
        System.out.println("result==" + result);
        return "success";
    }
}
