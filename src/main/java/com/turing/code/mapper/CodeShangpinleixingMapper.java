package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeShangpinleixing;

public interface CodeShangpinleixingMapper {
    int deleteByPrimaryKey(String cslId);

    int insert(CodeShangpinleixing record);

    int insertSelective(CodeShangpinleixing record);

    CodeShangpinleixing selectByPrimaryKey(String cslId);

    int updateByPrimaryKeySelective(CodeShangpinleixing record);

    int updateByPrimaryKey(CodeShangpinleixing record);
    
    List<CodeShangpinleixing> queryAll();
}