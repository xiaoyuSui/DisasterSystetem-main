package com.example.demo.mapper;

import com.example.demo.entity.DeathStatistics;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class DeathStatisticsMapperTest {

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
        DeathStatistics d = new DeathStatistics();
        d.setDisasterID("1234567891234562111");
        d.setDisasterDate("202005131044");
        d.setNumberDeath(20);
        d.setLocation("单元省测试");
        d.setReportingUnit("111");
        int result = sqlSession.insert("com.example.demo.mapper.DeathStatisticsMapper.insert",d);
        sqlSession.commit();
        if (result > 0)
            System.out.println("存储成功");
        else System.out.println("存储失败");
    }
}