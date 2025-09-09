package com.gaoxi.mapper;

import com.gaoxi.entity.Monster;
import com.gaoxi.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
    @Test
    public void addMonster() {
        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(10 + i);
            monster.setBirthday(new Date());
            monster.setEmail("kate@qq.com");
            monster.setGender(1);
            monster.setName("kangroo-" + i);
            monster.setSalary(1000 + i * 10);
            monsterMapper.addMonster(monster);
            System.out.println("添加对象" + monster);
            System.out.println("添加到monster表中后，自增长的id = " + monster.getId());
        }
        //如果是增、删、改，需要提交事务，默认是不提交的
        if (sqlSession != null) {
            //提交事务
            sqlSession.commit();
            //释放连接到连接池
            sqlSession.close();
        }
        System.out.println("保存成功");
    }

    @Test
    public void delMonster() {
        monsterMapper.delMonster(2);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("删除成功");
    }

    @Test
    public void updateMonster() {
        Monster monster = new Monster();
        monster.setAge(50);
        monster.setBirthday(new Date());
        monster.setEmail("king@gmail.com");
        monster.setGender(0);
        monster.setName("mouse-01");
        monster.setSalary(2000);
        monster.setId(5);
        monsterMapper.updateMonster(monster);
        //提交事务
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("更新成功");
    }

    @Test
    public void getMonsterById() {
        Monster monster = monsterMapper.getMonsterById(3);
        System.out.println(monster);
        if (sqlSession != null) {
            //释放连接到连接池
            sqlSession.close();
        }
    }

    @Test
    public void findAllMonster() {
        List<Monster> allMonster = monsterMapper.findAllMonster();
        for (Monster monster : allMonster) {
            System.out.println(monster);
        }
        //释放连接到连接池
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByNameOrId() {
        Monster monster = new Monster();
        monster.setId(3);
        monster.setName("jacket");
        List<Monster> monsters = monsterMapper.findMonsterByNameOrId(monster);
        System.out.println("findMonsterByNameOrId()查询结果为：");
        for (Monster monster1 : monsters) {
            System.out.println(monster1);
        }
        System.out.println("查询成功");
    }

    @Test
    public void findMonsterByName() {
        List<Monster> monsters = monsterMapper.findMonsterByName("牛魔王");
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }

    @Test
    public void findMonsterByIdAndSalary_ParameterHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("salary", 40);
        List<Monster> monsters = monsterMapper.findMonsterByIdAndSalary_ParameterHashMap(map);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }

    @Test
    public void findMonsterByIdAndSalary_ParameterHashMap_ReturnHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("salary", 40);
        List<Map<String, Object>> monsterList = monsterMapper.findMonsterByIdAndSalary_ParameterHashMap_ReturnHashMap(map);
        //取出返回的结果
        for (Map<String, Object> monsterMap : monsterList) {
//            Set<String> keys = monsterMap.keySet();
//            for (String key : keys) {
//                System.out.print(key + " => " + monsterMap.get(key) + "\t");
//            }
//            System.out.println();
            Set<Map.Entry<String, Object>> entries = monsterMap.entrySet();
            for (Map.Entry entry : entries) {
                System.out.print(entry.getKey() + " => " + entry.getValue() + "\t");
            }
            System.out.println();
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }

    //动态SQL
    @Test
    public void findMonsterByAge() {
        List<Monster> monsters = monsterMapper.findMonsterByAge(-2);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByIdAndName() {
        Monster monster = new Monster();
        monster.setId(1);
        monster.setName("elephant-0");
        List<Monster> monsters = monsterMapper.findMonsterByIdAndName(monster);
        for (Monster monster1 : monsters) {
            System.out.println(monster1);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }

    @Test
    public void findMonsterByIdOrName_choose() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "elephant-0");
        map.put("id", 1);
        List<Monster> monsters = monsterMapper.findMonsterByIdOrName_choose(map);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }

    @Test
    public void findMonsterById_forEach() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ids", Arrays.asList(3, 5, 7));
        List<Monster> monsters = monsterMapper.findMonsterById_forEach(map);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }

    @Test
    public void findMonsterByName_Trim() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "elephant-0");
        map.put("age", 1);
        List<Monster> monsters = monsterMapper.findMonsterByName_Trim(map);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功");
    }
}
