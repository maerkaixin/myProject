package com.turing.card.service;

import java.util.List;

import com.turing.card.entity.CardBuka;
import com.turing.card.page.BukaPage;

public interface IBukaService {

	List<CardBuka> queryAll(BukaPage page);

	void save(CardBuka bk);

	void delete(String[] ids);

	CardBuka selectById(String id);

}
