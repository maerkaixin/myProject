package com.turing.card.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.entity.CardTuika;
import com.turing.card.mapper.CardHuiyuanbankaMapper;
import com.turing.card.mapper.CardTuikaMapper;
import com.turing.card.page.TuikaPage;
import com.turing.card.service.ITuikaService;

@Service
public class TuikaServiceImpl implements ITuikaService {
	@Autowired
	private CardTuikaMapper mapper;
	@Autowired
	private CardHuiyuanbankaMapper hybkmapper;

	@Override
	public List<CardTuika> queryAll(TuikaPage page) {
		// TODO Auto-generated method stub
		return mapper.queryAll(page);
	}

	@Override
	public void add(CardTuika tk) {
		// 改变卡的状态
		CardHuiyuanbanka hybk = hybkmapper.selectOne(tk.getHcId());
		hybk.setHcState("P");
		hybkmapper.updateByPrimaryKeySelective(hybk);
		// 新增退卡记录
		tk.setTkId(UUID.randomUUID().toString());
		tk.setTkTime(new Date());
		mapper.insertSelective(tk);
	}

	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			// 还原卡的状态
			CardTuika tk = mapper.selectByPrimaryKey(id);
			CardHuiyuanbanka hybk = hybkmapper.selectOne(tk.getHcId());
			hybk.setHcState("A");
			hybkmapper.updateByPrimaryKeySelective(hybk);
			// 删除退卡记录
			mapper.deleteByPrimaryKey(id);

		}
	}

	@Override
	public CardTuika selectById(String id) {
		return mapper.selectById(id);
	}

	@Override
	public void editsave(CardTuika tk) {
		//查询原来的卡并还原其状态
		CardTuika oldtk = mapper.selectById(tk.getTkId());
		CardHuiyuanbanka oldhybk = hybkmapper.selectOne(oldtk.getHcId());
		oldhybk.setHcState("A");
		hybkmapper.updateByPrimaryKeySelective(oldhybk);
		//把新卡的状态改为不可用
		CardHuiyuanbanka newhybk = hybkmapper.selectOne(tk.getHcId());
		newhybk.setHcState("P");
		hybkmapper.updateByPrimaryKeySelective(newhybk);
		//添加退卡信息记录
		tk.setTkTime(new Date());
		mapper.updateByPrimaryKeySelective(tk);
		
		
		
	}
}
