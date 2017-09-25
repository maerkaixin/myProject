package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeShangpindanwei;

public interface CodeShangpindanweiMapper {
    int deleteByPrimaryKey(String csdId);

    int insert(CodeShangpindanwei record);

    int insertSelective(CodeShangpindanwei record);

    CodeShangpindanwei selectByPrimaryKey(String csdId);

    int updateByPrimaryKeySelective(CodeShangpindanwei record);

    int updateByPrimaryKey(CodeShangpindanwei record);
    
    List<CodeShangpindanwei> queryAll();
}