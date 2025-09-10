package com.gaoxi.mapper;

import com.gaoxi.entity.UserOfPets;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

//以注解的方式来配置多对一
public interface UserOfPetsMapperAnnotation {
    //通过id获取UserOfPets对象
    /*
     1.注解的配置就是对应的Mapper.xml文件配置的形式的改写
     */
    @Select("select * from `mybatis_user` where `id` = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            //这里pets属性对应的是集合
            @Result(property = "pets",
                    column = "id",
                    many = @Many(select = "com.gaoxi.mapper.PetMapperAnnotation.getPetByUserId"))
    })
    public UserOfPets getUserById(Integer id);

}
