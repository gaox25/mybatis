package com.gaoxi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    //属性，会话工厂
    private static SqlSessionFactory sqlSessionFactory;

    //编写一个静态代码块，初始化sqlSessionFactory
    static {
        //指定资源文件/配置文件mybatis-config.xml
        String resource = "mybatis-config.xml";
        //获取到配置文件mybatis-config.xml对应的inputStream
        //说明：加载这个文件时，默认到resources目录=>运行后的工作目录classes
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //编写方法，返回一个SqlSession对象-会话
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
