package com.gaoxi.mapper;

import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class MonsterMapperTest {
    //属性
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    /*
     1.当一个方法标注了@Before，表示在执行你的目标测试方法前，会先执行该方法
     2.
     */
    //编写方法完成初始化任务
    @Before
    public void init() {
        //1.获取到sqlSession
        sqlSession = MyBatisUtils.getSqlSession();
        //2.获取到MonsterMapper对象？该对象应该是什么类型？
        //  这个地方有点像Spring中的获取代理对象
        //monsterMapper=class com.sun.proxy.$Proxy7 monsterMapper是一个代理对象
        //底层是使用了动态代理机制，后面我们自己实现MyBatis底层机制时，会讲到
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
        System.out.println("monsterMapper=" + monsterMapper.getClass());
    }

}
