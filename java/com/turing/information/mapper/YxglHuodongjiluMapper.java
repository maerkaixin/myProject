package com.turing.information.mapper;

import com.turing.information.entity.YxglHuodongjilu;

public interface YxglHuodongjiluMapper {
    int deleteByPrimaryKey(String hdjlId);

    int insert(YxglHuodongjilu record);

    int insertSelective(YxglHuodongjilu record);

    YxglHuodongjilu selectByPrimaryKey(String hdjlId);

    int updateByPrimaryKeySelective(YxglHuodongjilu record);

    int updateByPrimaryKey(YxglHuodongjilu record);
}