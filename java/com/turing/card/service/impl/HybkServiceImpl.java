package com.turing.card.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.mapper.CardHuiyuanbankaMapper;
import com.turing.card.page.HybkPage;
import com.turing.card.service.IHybkService;
@Service
public class HybkServiceImpl implements IHybkService {
	@Autowired
	private CardHuiyuanbankaMapper mapper;
	@Override
	public List<CardHuiyuanbanka> queryAll(HybkPage page) {
		return mapper.queryAll(page);
	}
	@Override
	public void save(CardHuiyuanbanka hybk) {
		hybk.setHcId(UUID.randomUUID().toString());
		hybk.setHcTime(new Date());
		hybk.setHcState("A");
		mapper.insert(hybk);
	}
	@Override
	public CardHuiyuanbanka selectOne(String id) {
		return mapper.selectOne(id);
	}
	@Override
	public void update(CardHuiyuanbanka hybc) {
		CardHuiyuanbanka old = mapper.selectOne(hybc.getHcId());
		if (!old.getCardId().equals(hybc.getCardId())|| !old.getHyId().equals(hybc.getHyId())) {
			hybc.setHcTime(new Date());
		}
		mapper.updateByPrimaryKey(hybc);
	}
	@Override
	public void delete(String[] ids) {
		
		for (String string : ids) {
			mapper.deleteByPrimaryKey(string);
		}
	}
	@Override
	public List<CardHuiyuanbanka> getHybk(HybkPage page) {
		return mapper.getHybk(page);
	}

}
