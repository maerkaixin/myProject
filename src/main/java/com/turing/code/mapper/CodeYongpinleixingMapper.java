package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeYongpinleixing;

public interface CodeYongpinleixingMapper {
    int deleteByPrimaryKey(String cylId);

    int insert(CodeYongpinleixing record);

    int insertSelective(CodeYongpinleixing record);

    CodeYongpinleixing selectByPrimaryKey(String cylId);

    int updateByPrimaryKeySelective(CodeYongpinleixing record);

    int updateByPrimaryKey(CodeYongpinleixing record);
    
    List<CodeYongpinleixing> queryAll();
}