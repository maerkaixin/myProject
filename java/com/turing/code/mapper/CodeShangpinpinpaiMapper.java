package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeShangpinpinpai;

public interface CodeShangpinpinpaiMapper {
    int deleteByPrimaryKey(String cspId);

    int insert(CodeShangpinpinpai record);

    int insertSelective(CodeShangpinpinpai record);

    CodeShangpinpinpai selectByPrimaryKey(String cspId);

    int updateByPrimaryKeySelective(CodeShangpinpinpai record);

    int updateByPrimaryKey(CodeShangpinpinpai record);
    
    List<CodeShangpinpinpai> queryAll();
}