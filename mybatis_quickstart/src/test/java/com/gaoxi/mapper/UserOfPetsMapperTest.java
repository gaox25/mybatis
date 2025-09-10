package com.gaoxi.mapper;

import com.gaoxi.entity.Pet;
import com.gaoxi.entity.UserOfPets;
import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserOfPetsMapperTest {
    //属性
    private SqlSession sqlSession;
    private UserOfPetsMapper userOfPetsMapper;

    //编写方法完成初始化任务
    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        userOfPetsMapper = sqlSession.getMapper(UserOfPetsMapper.class);
    }

    @Test
    public void getUserById() {
        UserOfPets user = userOfPetsMapper.getUserById(1);
        System.out.println("user信息-" + user.getId() + " - " + user.getName());
        List<Pet> pets = user.getPets();
        for (Pet pet : pets) {
            System.out.print("养的宠物信息-" + pet.getId() + "-" + pet.getNickname() + ",");
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
