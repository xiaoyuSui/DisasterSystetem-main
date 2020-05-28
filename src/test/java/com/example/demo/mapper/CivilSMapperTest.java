package com.example.demo.mapper;

import com.example.demo.entity.CivilStructure;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CivilSMapperTest {
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
        CivilStructure d = new CivilStructure();
        d.setDisasterID("test");
        d.setDisasterDate("202005131044");
        d.setNote("单元测试");
        d.setLocation("台湾省");
        d.setReportingUnit("221");
        int result = sqlSession.insert("com.example.demo.mapper.CivilSMapper.insert",d);
        sqlSession.commit();
        if (result > 0)
            System.out.println("存储成功");
        else System.out.println("存储失败");
    }
}