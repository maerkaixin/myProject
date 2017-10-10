package com.turing.card.service;

import java.util.List;

import com.turing.card.entity.CardZhuanka;
import com.turing.card.page.ZhuankaPage;

public interface IZhuankaService {

	List<CardZhuanka> queryAll(ZhuankaPage page);

	void addsave(CardZhuanka zk);

}
