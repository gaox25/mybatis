package com.gaoxi.mapper;

import com.gaoxi.entity.Person;

public interface PersonMapper {
    //通过Person的id获取到Person，包括这个Person关联的IdenCard对象[级联查询]
    //第一种方式
    public Person getPersonById(Integer id);
    //第二种方式
    public Person getPersonById2(Integer id);
}
