package com.gaoxi.mapper;

import com.gaoxi.entity.Pet;
import com.gaoxi.entity.UserOfPets;
import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetMapperTest {
    //属性
    private SqlSession sqlSession;
    private PetMapper petMapper;

    //编写方法完成初始化任务
    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        petMapper = sqlSession.getMapper(PetMapper.class);
    }

    @Test
    public void getPetByUserId() {
        List<Pet> pets = petMapper.getPetByUserId(2);
        for (Pet pet : pets) {
            System.out.println("pet信息 " + pet);
            UserOfPets user = pet.getUser();
            System.out.println("user信息 name-" + user.getName());
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }

    @Test
    public void getPetById() {
        Pet pet = petMapper.getPetById(1);
        System.out.println("pet信息 - " + pet);
        UserOfPets user = pet.getUser();
        System.out.println("user信息 - " + user.getName());
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }
}
