package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeWeixiuleixing;

public interface CodeWeixiuleixingMapper {
    int deleteByPrimaryKey(String cwlId);

    int insert(CodeWeixiuleixing record);

    int insertSelective(CodeWeixiuleixing record);

    CodeWeixiuleixing selectByPrimaryKey(String cwlId);

    int updateByPrimaryKeySelective(CodeWeixiuleixing record);

    int updateByPrimaryKey(CodeWeixiuleixing record);
    
    List<CodeWeixiuleixing> queryAll();
}