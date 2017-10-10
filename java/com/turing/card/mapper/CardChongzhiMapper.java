package com.turing.card.mapper;

import java.util.List;

import com.turing.card.entity.CardChongzhi;
import com.turing.card.page.ChongzhiPage;

public interface CardChongzhiMapper {
    int deleteByPrimaryKey(String czId);

    int insert(CardChongzhi record);

    int insertSelective(CardChongzhi record);

    CardChongzhi selectByPrimaryKey(String czId);

    int updateByPrimaryKeySelective(CardChongzhi record);

    int updateByPrimaryKey(CardChongzhi record);

	List<CardChongzhi> queryAll(ChongzhiPage page);
}