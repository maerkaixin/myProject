package com.turing.card.service;

import java.util.List;




import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.page.HybkPage;


public interface IHybkService {

	List<CardHuiyuanbanka> queryAll(HybkPage page);

	void save(CardHuiyuanbanka hybk);

	CardHuiyuanbanka selectOne(String id);

	void update(CardHuiyuanbanka hybc);

	void delete(String[] ids);

	List<CardHuiyuanbanka> getHybk(HybkPage page);

}
