package com.turing.information.mapper;

import java.util.List;

import com.turing.information.entity.GdzcWeixiu;
import com.turing.information.page.WxPage;

public interface GdzcWeixiuMapper {
    int deleteByPrimaryKey(String wxjlId);

    int insert(GdzcWeixiu record);

    int insertSelective(GdzcWeixiu record);

    GdzcWeixiu selectByPrimaryKey(String wxjlId);

    int updateByPrimaryKeySelective(GdzcWeixiu record);

    int updateByPrimaryKey(GdzcWeixiu record);

	List<GdzcWeixiu> queryAll(WxPage page);
}