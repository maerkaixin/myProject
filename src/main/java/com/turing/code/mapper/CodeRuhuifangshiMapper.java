package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeRuhuifangshi;

public interface CodeRuhuifangshiMapper {
    int deleteByPrimaryKey(String crfId);

    int insert(CodeRuhuifangshi record);

    int insertSelective(CodeRuhuifangshi record);

    CodeRuhuifangshi selectByPrimaryKey(String crfId);

    int updateByPrimaryKeySelective(CodeRuhuifangshi record);

    int updateByPrimaryKey(CodeRuhuifangshi record);
    
    List<CodeRuhuifangshi> queryAll();
}