package com.gaoxi.mapper;

import com.gaoxi.entity.Monster;

import java.util.List;
import java.util.Map;

/*
 1.这是一个接口，
 2.该接口用于声明操作monster表的方法
 3.这些方法可以通过注解或者xml文件来实现
 */
public interface MonsterMapper {
    //添加monster
    public void addMonster(Monster monster);

    //根据id删除一个Monster
    public void delMonster(Integer id);

    //根据id更新Monster
    public void updateMonster(Monster monster);

    //根据id查询单个Monster
    public Monster getMonsterById(Integer id);

    //查询所有的Monster
    public List<Monster> findAllMonster();

    //根据id或者name查询Monster
    public List<Monster> findMonsterByNameOrId(Monster monster);

    //根据name模糊查询Monster
    public List<Monster> findMonsterByName(String name);

    //查询id>10并且salary>40，要求传入的参数是HashMap
    public List<Monster> findMonsterByIdAndSalary_ParameterHashMap(Map<String, Object> map);

    //查询，返回的结果为map
    public List<Map<String, Object>> findMonsterByIdAndSalary_ParameterHashMap_ReturnHashMap(Map<String, Object> map);

}
