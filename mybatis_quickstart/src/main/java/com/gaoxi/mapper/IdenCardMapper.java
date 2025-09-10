package com.gaoxi.mapper;

import com.gaoxi.entity.IdenCard;

public interface IdenCardMapper {
    //根据id获取到身份证序列号
    public IdenCard getIdenCardById(Integer id);
}
