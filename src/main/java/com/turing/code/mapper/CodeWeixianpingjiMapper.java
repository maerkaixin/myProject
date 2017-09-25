package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeWeixianpingji;

public interface CodeWeixianpingjiMapper {
    int deleteByPrimaryKey(String cwpId);

    int insert(CodeWeixianpingji record);

    int insertSelective(CodeWeixianpingji record);

    CodeWeixianpingji selectByPrimaryKey(String cwpId);

    int updateByPrimaryKeySelective(CodeWeixianpingji record);

    int updateByPrimaryKey(CodeWeixianpingji record);
    
    List<CodeWeixianpingji> queryAll();
}