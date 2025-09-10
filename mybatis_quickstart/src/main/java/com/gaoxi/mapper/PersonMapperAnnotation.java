package com.gaoxi.mapper;

import com.gaoxi.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapperAnnotation {
    //这里使用注解实现方法
    //说明：注解的形式就是对前面xml配置形式的体现
    @Select("select * from `person` where `id` = #{id}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "card", column = "card_id", one = @One(select = "com.gaoxi.mapper.IdenCardMapperAnnotation.getIdenCardById"))
    })
    public Person getPersonById(Integer id);
}
