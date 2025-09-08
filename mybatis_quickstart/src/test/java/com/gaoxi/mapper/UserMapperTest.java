package com.gaoxi.mapper;

import com.gaoxi.entity.User;
import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    //属性
    private SqlSession sqlSession;
    private UserMapper userMapper;

    //编写方法完成初始化任务
    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("jerry");
        user.setUseremail("jerry@gmail.com");
        userMapper.addUser(user);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("保存成功");
    }

    @Test
    public void findAllUser() {
        List<User> allUser = userMapper.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
