package com.gaoxi.mapper;

import com.gaoxi.entity.Monk;
import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MonkMapperTest {
    private SqlSession sqlSession;
    private MonkMapper monkMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        monkMapper = sqlSession.getMapper(MonkMapper.class);
    }

    @Test
    public void addMonk() {
        for (int i = 0; i < 2; i++) {
            Monk monk = new Monk();
            monk.setNickname("jerry");
            monk.setSkill("running");
            monk.setGrade("level-02");
            monk.setSalary(299.9);
            monk.setBirthday(new Date());
            monk.setEntry(new Date());
            monkMapper.addMonk(monk);
        }
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("保存成功");
    }

    @Test
    public void delMonk() {
        monkMapper.delMonk(2);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("删除成功");
    }

    @Test
    public void updateMonk() {
        Monk monk = new Monk();
        monk.setId(3);
        monk.setNickname("spike");
        monkMapper.updateMonk(monk);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("更新成功");
    }

    @Test
    public void getMonkById() {
        Monk monk = monkMapper.getMonkById(3);
        System.out.println("monk = " + monk);
    }

    @Test
    public void findAllMonk() {
        List<Monk> allMonk = monkMapper.findAllMonk();
        for (Monk monk : allMonk) {
            System.out.println(monk);
        }

    }

}
