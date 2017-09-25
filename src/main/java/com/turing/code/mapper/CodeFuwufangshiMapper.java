package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeFuwufangshi;

public interface CodeFuwufangshiMapper {
    int deleteByPrimaryKey(String cffId);

    int insert(CodeFuwufangshi record);

    int insertSelective(CodeFuwufangshi record);

    CodeFuwufangshi selectByPrimaryKey(String cffId);

    int updateByPrimaryKeySelective(CodeFuwufangshi record);

    int updateByPrimaryKey(CodeFuwufangshi record);
    
    List<CodeFuwufangshi> queryAll();
}