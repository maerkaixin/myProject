package com.turing.card.mapper;

import java.util.List;

import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.page.HybkPage;

public interface CardHuiyuanbankaMapper {
    int deleteByPrimaryKey(String hcId);

    int insert(CardHuiyuanbanka record);

    int insertSelective(CardHuiyuanbanka record);

    CardHuiyuanbanka selectByPrimaryKey(String hcId);

    int updateByPrimaryKeySelective(CardHuiyuanbanka record);

    int updateByPrimaryKey(CardHuiyuanbanka record);

	List<CardHuiyuanbanka> queryAll(HybkPage page);

	CardHuiyuanbanka selectOne(String id);
}