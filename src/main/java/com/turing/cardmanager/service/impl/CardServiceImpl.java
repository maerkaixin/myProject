package com.turing.cardmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.cardmanager.CardPage;
import com.turing.cardmanager.entity.CardType;
import com.turing.cardmanager.mapper.CardTypeMapper;
import com.turing.cardmanager.service.ICardService;

@Service
public class CardServiceImpl implements ICardService {
	@Autowired
	private CardTypeMapper mapper;

	@Override
	public List<CardType> queryAll(CardPage page) {
		return mapper.queryAll();
	}

}
