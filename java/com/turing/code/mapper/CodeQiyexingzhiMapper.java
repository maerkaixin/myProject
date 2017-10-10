package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeQiyexingzhi;

public interface CodeQiyexingzhiMapper {
    int deleteByPrimaryKey(String cqxId);

    int insert(CodeQiyexingzhi record);

    int insertSelective(CodeQiyexingzhi record);

    CodeQiyexingzhi selectByPrimaryKey(String cqxId);

    int updateByPrimaryKeySelective(CodeQiyexingzhi record);

    int updateByPrimaryKey(CodeQiyexingzhi record);
    
    List<CodeQiyexingzhi> queryAll();
}