package com.gaoxi.mapper;

import com.gaoxi.entity.Pet;
import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetMapperAnnotationTest {
    //属性
    private SqlSession sqlSession;
    private PetMapperAnnotation petMapperAnnotation;

    //编写方法完成初始化任务
    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        petMapperAnnotation = sqlSession.getMapper(PetMapperAnnotation.class);
    }

    @Test
    public void getPetByUserId() {
        List<Pet> pets = petMapperAnnotation.getPetByUserId(1);
        for (Pet pet : pets) {
            System.out.println(pet);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询完成");
    }

    @Test
    public void getPetById() {
        Pet pet = petMapperAnnotation.getPetById(1);
        System.out.println("pet = " + pet);
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询完成");
    }
}
