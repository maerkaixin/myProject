package com.turing.huiyuan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.turing.huiyuan.entity.HyglHuiyuan;
import com.turing.huiyuan.page.HyglHuiyuanPage;

public interface HyglHuiyuanMapper {
    int deleteByPrimaryKey(String hyId);

    int insert(HyglHuiyuan record);

    int insertSelective(HyglHuiyuan record);

    HyglHuiyuan selectByPrimaryKey(String hyId);

    int updateByPrimaryKeySelective(HyglHuiyuan record);

    int updateByPrimaryKey(HyglHuiyuan record);
    
    List<HyglHuiyuan>  queryAll(HyglHuiyuanPage page);

	List<HyglHuiyuan> srtxQuery(HyglHuiyuanPage page);
}