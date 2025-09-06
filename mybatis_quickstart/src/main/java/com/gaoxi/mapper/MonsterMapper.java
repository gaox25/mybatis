package com.gaoxi.mapper;

import com.gaoxi.entity.Monster;

/*
 1.这是一个接口，
 2.该接口用于声明操作monster表的方法
 3.这些方法可以通过注解或者xml文件来实现
 */
public interface MonsterMapper {
    //添加monster
    public void addMonster(Monster monster);

}
