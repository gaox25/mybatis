package com.gaoxi.mapper;

import com.gaoxi.entity.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PetMapperAnnotation {
    @Select("select * from `mybatis_pet` where `user_id` = #{userId}")
    //id="PetResultMap"就是给Results[Result Map]指定一个名字，目的是为了后面的复用
    @Results(id="PetResultMap",value={
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "userId", column = "user_id"),
//            @Result(property = "user",
//                    column = "user_id",
//                    one = @One(select = "com.gaoxi.mapper.UserMapperAnnotation.getUserById"))
    })
    public List<Pet> getPetByUserId(Integer userId);

    @Select("select * from `mybatis_pet` where `id` = #{id}")
    //复用上面的results
    @ResultMap("PetResultMap")
    public Pet getPetById(Integer id);
}
