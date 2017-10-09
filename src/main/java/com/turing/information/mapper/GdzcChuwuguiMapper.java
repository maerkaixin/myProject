package com.turing.information.mapper;

import java.util.List;

import com.turing.information.entity.GdzcChuwugui;

public interface GdzcChuwuguiMapper {
    int deleteByPrimaryKey(String cwgId);

    int insert(GdzcChuwugui record);

    int insertSelective(GdzcChuwugui record);

    GdzcChuwugui selectByPrimaryKey(String cwgId);

    int updateByPrimaryKeySelective(GdzcChuwugui record);

    int updateByPrimaryKey(GdzcChuwugui record);

	List<GdzcChuwugui> queryAll();
	
	void changeState(String string);

	void huifu(String id);
}