package com.turing.card.mapper;

import java.util.List;

import com.turing.card.entity.CardBuka;
import com.turing.card.page.BukaPage;

public interface CardBukaMapper {
    int deleteByPrimaryKey(String bkId);

    int insert(CardBuka record);

    int insertSelective(CardBuka record);

    CardBuka selectByPrimaryKey(String bkId);

    int updateByPrimaryKeySelective(CardBuka record);

    int updateByPrimaryKey(CardBuka record);

	List<CardBuka> queryAll(BukaPage page);

	CardBuka selectById(String id);
}