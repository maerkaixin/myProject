package com.turing.cardmanager.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.cardmanager.entity.CardType;
import com.turing.cardmanager.mapper.CardTypeMapper;
import com.turing.cardmanager.page.CardPage;
import com.turing.cardmanager.service.ICardService;

@Service
public class CardServiceImpl implements ICardService {
	@Autowired
	private CardTypeMapper mapper;

	@Override
	public List<CardType> queryAll(CardPage page) {
		return mapper.queryAll();
	}

	@Override
	public CardType queryById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(CardType cardTyp) {
		if (cardTyp.getCardId()!=null && !cardTyp.getCardId().equals("")) {
			mapper.updateByPrimaryKey(cardTyp);
		}else{
			cardTyp.setCardId(UUID.randomUUID().toString());
			mapper.insert(cardTyp);
		}
	}

	@Override
	public void delete(String[] ids) {
		for (String string : ids) {
			mapper.deleteByPrimaryKey(string);
		}
	}

}
