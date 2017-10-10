package com.turing.cardmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.turing.cardmanager.entity.CardType;

public interface CardTypeMapper {
    int deleteByPrimaryKey(String cardId);

    int insert(CardType record);

    int insertSelective(CardType record);

    CardType selectByPrimaryKey(String cardId);

    int updateByPrimaryKeySelective(CardType record);

    int updateByPrimaryKey(CardType record);

	List<CardType> queryAll();
	@Select("select distinct ct.card_name from card_huiyuanbanka ch "
			+ " left join card_type ct on ch.card_id =ct.card_id where ch.card_id =#{id} ")
	String yanzhengKaxinxi(String id);
}