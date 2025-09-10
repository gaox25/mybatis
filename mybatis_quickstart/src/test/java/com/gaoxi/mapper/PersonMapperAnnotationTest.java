package com.gaoxi.mapper;

import com.gaoxi.entity.Person;
import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class PersonMapperAnnotationTest {
    //属性
    private SqlSession sqlSession;
    private PersonMapperAnnotation personMapperAnnotation;

    /*
     1.当一个方法标注了@Before，表示在执行你的目标测试方法前，会先执行该方法
     */
    //编写方法完成初始化任务
    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        personMapperAnnotation = sqlSession.getMapper(PersonMapperAnnotation.class);
    }

    @Test
    public void getPersonById() {
        Person person = personMapperAnnotation.getPersonById(1);
        System.out.println("person--注解-- = " + person);
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }
}
