package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeTousufangshi;

public interface CodeTousufangshiMapper {
    int deleteByPrimaryKey(String ctfId);

    int insert(CodeTousufangshi record);

    int insertSelective(CodeTousufangshi record);

    CodeTousufangshi selectByPrimaryKey(String ctfId);

    int updateByPrimaryKeySelective(CodeTousufangshi record);

    int updateByPrimaryKey(CodeTousufangshi record);
    
    List<CodeTousufangshi> queryAll();
}