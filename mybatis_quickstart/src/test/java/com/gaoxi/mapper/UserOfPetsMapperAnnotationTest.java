package com.gaoxi.mapper;

import com.gaoxi.entity.Pet;
import com.gaoxi.entity.UserOfPets;
import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserOfPetsMapperAnnotationTest {
    //属性
    private SqlSession sqlSession;
    private UserOfPetsMapperAnnotation userOfPetsMapperAnnotation;

    //编写方法完成初始化任务
    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        userOfPetsMapperAnnotation = sqlSession.getMapper(UserOfPetsMapperAnnotation.class);
    }

    @Test
    public void getUserById() {
        UserOfPets user = userOfPetsMapperAnnotation.getUserById(1);
        System.out.println("user = " + user);
        List<Pet> pets = user.getPets();
        for (Pet pet : pets) {
            System.out.println("pet = " + pet + "\t");
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }

}
