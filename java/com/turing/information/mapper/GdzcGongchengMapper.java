package com.turing.information.mapper;

import java.util.List;

import com.turing.information.entity.GdzcGongcheng;
import com.turing.information.page.GcglPage;

public interface GdzcGongchengMapper {
    int deleteByPrimaryKey(String gcId);

    int insert(GdzcGongcheng record);

    int insertSelective(GdzcGongcheng record);

    GdzcGongcheng selectByPrimaryKey(String gcId);

    int updateByPrimaryKeySelective(GdzcGongcheng record);

    int updateByPrimaryKey(GdzcGongcheng record);

	List<GdzcGongcheng> queryAll(GcglPage page);
}