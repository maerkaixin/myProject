package com.turing.information.mapper;

import java.util.List;

import com.turing.information.entity.KcglCangku;
import com.turing.information.page.CangkuPage;

public interface KcglCangkuMapper {
    int deleteByPrimaryKey(String ckId);

    int insert(KcglCangku record);

    int insertSelective(KcglCangku record);

    KcglCangku selectByPrimaryKey(String ckId);

    int updateByPrimaryKeySelective(KcglCangku record);

    int updateByPrimaryKey(KcglCangku record);

	List<KcglCangku> queryAll(CangkuPage page);

	List<KcglCangku> queryByCkName(String ckName);

	List<KcglCangku> queryByCkNo(String ckNo);

}