package com.turing.card.service;

import java.util.List;

import com.turing.card.entity.CardTuika;
import com.turing.card.page.TuikaPage;

public interface ITuikaService {

	List<CardTuika> queryAll(TuikaPage page);

	void add(CardTuika tk);

	void delete(String[] ids);

	CardTuika selectById(String id);

	void editsave(CardTuika tk);

}
