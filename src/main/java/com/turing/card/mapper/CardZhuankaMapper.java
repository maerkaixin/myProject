package com.turing.card.mapper;

import java.util.List;

import com.turing.card.entity.CardZhuanka;
import com.turing.card.page.ZhuankaPage;

public interface CardZhuankaMapper {
    int deleteByPrimaryKey(String zkId);

    int insert(CardZhuanka record);

    int insertSelective(CardZhuanka record);

    CardZhuanka selectByPrimaryKey(String zkId);

    int updateByPrimaryKeySelective(CardZhuanka record);

    int updateByPrimaryKey(CardZhuanka record);

	List<CardZhuanka> queryAll(ZhuankaPage page);
}