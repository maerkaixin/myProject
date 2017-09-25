package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeJinjichengdu;

public interface CodeJinjichengduMapper {
    int deleteByPrimaryKey(String cjcId);

    int insert(CodeJinjichengdu record);

    int insertSelective(CodeJinjichengdu record);

    CodeJinjichengdu selectByPrimaryKey(String cjcId);

    int updateByPrimaryKeySelective(CodeJinjichengdu record);

    int updateByPrimaryKey(CodeJinjichengdu record);
    
    List<CodeJinjichengdu> queryAll();
}