package com.gaoxi.mapper;

import com.gaoxi.entity.IdenCard;
import org.apache.ibatis.annotations.Select;

public interface IdenCardMapperAnnotation {
    //使用注解的方式实现1对1的映射
    //这个方法不需要返回任何级联对象
    @Select("select * from `idencard` where `id` = #{id}")
    public IdenCard getIdenCardById(Integer id);
}
