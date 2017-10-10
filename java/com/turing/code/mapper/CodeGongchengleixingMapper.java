package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeGongchengleixing;

public interface CodeGongchengleixingMapper {
    int deleteByPrimaryKey(String cglId);

    int insert(CodeGongchengleixing record);

    int insertSelective(CodeGongchengleixing record);

    CodeGongchengleixing selectByPrimaryKey(String cglId);

    int updateByPrimaryKeySelective(CodeGongchengleixing record);

    int updateByPrimaryKey(CodeGongchengleixing record);
    
    List<CodeGongchengleixing> queryAll();
}