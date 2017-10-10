package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeBank;


public interface CodeBankMapper {
    int deleteByPrimaryKey(String cbId);

    int insert(CodeBank record);

    int insertSelective(CodeBank record);

    CodeBank selectByPrimaryKey(String cbId);

    int updateByPrimaryKeySelective(CodeBank record);

    int updateByPrimaryKey(CodeBank record);
    
    List<CodeBank> queryAll();
}