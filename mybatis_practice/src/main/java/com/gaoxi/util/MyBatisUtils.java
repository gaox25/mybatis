package com.gaoxi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//工具类，用于获取会话sqlSession
public class MyBatisUtils {
    //会话工厂
    private static SqlSessionFactory sqlSessionFactory;

    //编写静态代码块，初始化sqlSessionFactory
    static {
        //指定资源文件/配置文件mybatis-config.xml，从其中加载配置会话工厂
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //编写方法，返回一个SqlSession对象即会话
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
