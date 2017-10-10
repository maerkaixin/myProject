package com.turing.cardmanager.service;

import java.util.List;

import com.turing.cardmanager.entity.CardType;
import com.turing.cardmanager.page.CardPage;

public interface ICardService {

	List<CardType> queryAll(CardPage page);

	CardType queryById(String id);

	void save(CardType cardTyp);

	void delete(List<String> idsList);

	String yanzhengKaxinxi(String id);

}
