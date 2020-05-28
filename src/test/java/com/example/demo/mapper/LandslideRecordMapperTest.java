package com.example.demo.mapper;

import com.example.demo.entity.LandslideRecord;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class LandslideRecordMapperTest {
    private static SqlSession sqlSession = null;
    private static SqlSessionFactory sqlSessionFactory = null;

    @BeforeAll
    static void beforeAll() throws IOException {
        //读取mybatis-config.xml文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        //初始化mybatis,创建SqlSessionFactory类的实例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }


    @Test
    void insert() {
        LandslideRecord lr = new LandslideRecord();
        lr.setDisasterID("1234567891234562441");
        lr.setNote("This is Unit Test");
        int result = sqlSession.insert("com.example.demo.mapper.LandslideRecordMapper.insert",lr);
        sqlSession.commit();
        if (result > 0)
            System.out.println("存储成功");
        else System.out.println("存储失败");
    }
}