package com.turing.khgl.mapper;

import java.util.List;

import com.turing.khgl.entity.KhglQiye;

public interface KhglQiyeMapper {
    int deleteByPrimaryKey(String qyId);

    int insert(KhglQiye record);

    int insertSelective(KhglQiye record);

    KhglQiye selectByPrimaryKey(String qyId);

    int updateByPrimaryKeySelective(KhglQiye record);

    int updateByPrimaryKey(KhglQiye record);

	List<KhglQiye> queryAllWithList();
}