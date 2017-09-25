package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeTousuleixing;

public interface CodeTousuleixingMapper {
    int deleteByPrimaryKey(String ctlId);

    int insert(CodeTousuleixing record);

    int insertSelective(CodeTousuleixing record);

    CodeTousuleixing selectByPrimaryKey(String ctlId);

    int updateByPrimaryKeySelective(CodeTousuleixing record);

    int updateByPrimaryKey(CodeTousuleixing record);
    
    List<CodeTousuleixing> queryAll();
}