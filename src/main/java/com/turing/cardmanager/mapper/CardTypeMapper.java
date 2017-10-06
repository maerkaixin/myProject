package com.turing.cardmanager.mapper;

import java.util.List;

import com.turing.cardmanager.entity.CardType;

public interface CardTypeMapper {
    int deleteByPrimaryKey(String cardId);

    int insert(CardType record);

    int insertSelective(CardType record);

    CardType selectByPrimaryKey(String cardId);

    int updateByPrimaryKeySelective(CardType record);

    int updateByPrimaryKey(CardType record);

	List<CardType> queryAll();
}