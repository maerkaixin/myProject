package com.turing.card.mapper;

import java.util.List;

import com.turing.card.entity.CardTuika;
import com.turing.card.page.TuikaPage;

public interface CardTuikaMapper {
    int deleteByPrimaryKey(String tkId);

    int insert(CardTuika record);

    int insertSelective(CardTuika record);

    CardTuika selectByPrimaryKey(String tkId);

    int updateByPrimaryKeySelective(CardTuika record);

    int updateByPrimaryKey(CardTuika record);

	List<CardTuika> queryAll(TuikaPage page);

	CardTuika selectById(String id);
}