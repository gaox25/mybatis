package com.gaoxi.mapper;

import com.gaoxi.entity.Monster;

import java.util.List;

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

}
