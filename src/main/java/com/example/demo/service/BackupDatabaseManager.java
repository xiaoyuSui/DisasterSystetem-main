package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class BackupDatabaseManager {
    private static final Logger log = LoggerFactory.getLogger(BackupDatabaseManager.class);
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;

    /**     * 获取数据库名     */
    public String getDataBaseName() {
        return url.substring(url.indexOf("3306"), url.indexOf("?"))
                .replaceAll("/", "")
                .replaceAll("3306", "");
    }

    /**     * 获取主机地址     */
    private String getHost() {
        return url.substring(url.indexOf("mysql"), url.indexOf("3306"))
                .replace(":", "")
                .replace("//", "")
                .replace("mysql", "");
    }

    /**     * 导出 sql 并返回相关信息     */
    public void exportSql(String time) {
        StringBuilder sb = new StringBuilder();

        //不要用变量拼接 路径不要有符号
        sb.append("mysqldump");
        sb.append(" -u root ");
        sb.append(" --password=");
        sb.append("root ");
        sb.append(" mshd ");
        //备份数据存储位置，需要在mysql所在的盘
        sb.append(">D:\\data.sql");

        //mysql的exe位置
        File dir = new File("D:\\Program Files\\mysql-8.0.20-winx64\\bin");

        try {
            Process exec = Runtime.getRuntime().exec("cmd /c "+sb.toString(),null,dir);

            if (exec.waitFor() == 0) {
                log.info("数据库备份成功，保存路径：" +"!!!");
            } else {
                System.out.println("process.waitFor()=" + exec.waitFor());

            }
        } catch (IOException e) {
            log.error("备份 数据库 出现 IO异常 ", e);
        } catch (InterruptedException e) {
            log.error("备份 数据库 出现 线程中断异常 ", e);
        } catch (Exception e) {
            log.error("备份 数据库 出现 其他异常 ", e);
        }
    }

    //执行子系统发送来的sql文件，覆盖原有数据库
    public void executeBackupFile() throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();

        //不要用变量拼接 路径不要有符号
        sb.append("mysql");
        sb.append(" -u root ");
        sb.append(" --password=");
        sb.append("root ");
        sb.append(" -Dspringboot ");
        //该路径为 存储接收子系统发送数据的位置
        sb.append("<D:\\backup.sql");

        File dir = new File("D:\\Program Files\\mysql-8.0.20-winx64\\bin");

        Process exec = Runtime.getRuntime().exec("cmd /c "+sb.toString(),null,dir);

        if (exec.waitFor() == 0) {
            log.info("数据库恢复成功，保存路径：" +"!!!");
        } else {
            System.out.println("process.waitFor()=" + exec.waitFor());

        }
    }
}
