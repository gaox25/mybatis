package com.gaoxi.mapper;

import com.gaoxi.entity.Monk;

import java.util.List;

public interface MonkMapper {

    //添加单个Monk
    public void addMonk(Monk monk);

    //根据id删除单个Monk
    public void delMonk(Integer id);

    //修改单个Monk
    public void updateMonk(Monk monk);

    //根据id查询单个Monk
    public Monk getMonkById(Integer id);

    //查询所有Monk
    public List<Monk> findAllMonk();

}
