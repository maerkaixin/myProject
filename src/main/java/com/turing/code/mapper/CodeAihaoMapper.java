package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeAihao;


public interface CodeAihaoMapper {
    int deleteByPrimaryKey(String cahId);

    int insert(CodeAihao record);

    int insertSelective(CodeAihao record);

    CodeAihao selectByPrimaryKey(String cahId);

    int updateByPrimaryKeySelective(CodeAihao record);

    int updateByPrimaryKey(CodeAihao record);
    
    List<CodeAihao> queryAll();
}