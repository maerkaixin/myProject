package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeEmail;


public interface CodeEmailMapper {
    int deleteByPrimaryKey(String cemId);

    int insert(CodeEmail record);

    int insertSelective(CodeEmail record);

    CodeEmail selectByPrimaryKey(String cemId);

    int updateByPrimaryKeySelective(CodeEmail record);

    int updateByPrimaryKey(CodeEmail record);
    
    List<CodeEmail> queryAll();
}