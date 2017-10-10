package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeHangyeleixing;

public interface CodeHangyeleixingMapper {
    int deleteByPrimaryKey(String chlId);

    int insert(CodeHangyeleixing record);

    int insertSelective(CodeHangyeleixing record);

    CodeHangyeleixing selectByPrimaryKey(String chlId);

    int updateByPrimaryKeySelective(CodeHangyeleixing record);

    int updateByPrimaryKey(CodeHangyeleixing record);
    
    List<CodeHangyeleixing> queryAll();
}