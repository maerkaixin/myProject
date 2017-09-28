package com.turing.information.mapper;

import com.turing.information.entity.YxglXuanchuanfangshi;

public interface YxglXuanchuanfangshiMapper {
    int deleteByPrimaryKey(String xcfsId);

    int insert(YxglXuanchuanfangshi record);

    int insertSelective(YxglXuanchuanfangshi record);

    YxglXuanchuanfangshi selectByPrimaryKey(String xcfsId);

    int updateByPrimaryKeySelective(YxglXuanchuanfangshi record);

    int updateByPrimaryKey(YxglXuanchuanfangshi record);
}