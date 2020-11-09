package com.example.demo.controller;

import com.example.demo.service.BackupDatabaseManager;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

@Controller
@Component
public class BackupDatabase {

    private static final Logger log = LoggerFactory.getLogger(BackupDatabase.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");

    @Autowired
    private BackupDatabaseManager backUpDataBaseManager;

    /**
     * 每1min执行一次  可以改成10
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void reportCurrentTime() throws IOException, InterruptedException {
        String format = dateFormat.format(System.currentTimeMillis());
        log.info("The time is now {}", format);
        backUpDataBaseManager.exportSql(format);
        System.out.println("BackUp Successfully");
        getDB();
    }

    public void getDB() throws IOException, InterruptedException {
        //开启Socket服务端
        // 建立服务端
        ServerSocket ss = new ServerSocket(9001);// 需要指定端口，客户端与服务端相同，一般在1000-65535之间
        //发送请求
        JSONObject jsobj = new JSONObject();
        post(jsobj);
        // 获取客户端Socket
        Socket s = ss.accept();
        // 获取输入流与输出流
        InputStream in = s.getInputStream();// 输入流
        //存储子系统发送来的数据
        File file = new File("D:\\backup.sql");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        // 创建缓冲区关联输入流与输出流
        byte[] buf = new byte[1024*1024];
        int len = 0;
        // 数据的写入
        while ((len = in.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        // 关流
        fos.close();
        s.close();
        ss.close();
        System.out.println("!!!!!!!!!!!!!!!!RECEIVE DB!!!!!!!!!!!!!!!!");
        String format = dateFormat.format(System.currentTimeMillis());
        log.info("The time is now {}", format);
        backUpDataBaseManager.executeBackupFile();
    }

    public static String post(JSONObject json) {
        String result = "";
        try {
            HttpClient client = new DefaultHttpClient();
            String url= "http://localhost:8080/demo_war/db/backupDB";
            HttpPost post = new HttpPost(url);
            post.setHeader("Content-Type", "appliction/json");
            post.addHeader("Authorization", "Basic YWRtaW46");
            StringEntity s = new StringEntity(json.toString(), "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "appliction/json"));
            post.setEntity(s);
            HttpResponse httpResponse = client.execute(post);
            InputStream in = httpResponse.getEntity().getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                strber.append(line + "\n");
            }
            in.close();
            result = strber.toString();
            if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                result = "服务器异常";
            }
        } catch (Exception e) {
            System.out.println("请求异常");
            throw new RuntimeException(e);
        }
        System.out.println("result==" + result);
        return result;
    }

}

