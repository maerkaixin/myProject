package com.turing.card.service;

import java.util.List;

import com.turing.card.entity.CardChongzhi;
import com.turing.card.page.ChongzhiPage;

public interface IChongzhiService {

	List<CardChongzhi> queryAll(ChongzhiPage page);

	void addsave(CardChongzhi cz);

	CardChongzhi selectById(String id);

	void delete(String[] ids);

	void editsave(CardChongzhi cz);

}
