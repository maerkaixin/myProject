package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeFuwuleixing;

public interface CodeFuwuleixingMapper {
    int deleteByPrimaryKey(String cflId);

    int insert(CodeFuwuleixing record);

    int insertSelective(CodeFuwuleixing record);

    CodeFuwuleixing selectByPrimaryKey(String cflId);

    int updateByPrimaryKeySelective(CodeFuwuleixing record);

    int updateByPrimaryKey(CodeFuwuleixing record);
    
    List<CodeFuwuleixing> queryAll();
}