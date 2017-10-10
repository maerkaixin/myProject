package com.turing.card.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.card.entity.CardChongzhi;
import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.mapper.CardChongzhiMapper;
import com.turing.card.mapper.CardHuiyuanbankaMapper;
import com.turing.card.page.ChongzhiPage;
import com.turing.card.service.IChongzhiService;
@Service
public class ChongzhiServiceImpl implements IChongzhiService {
	@Autowired
	private CardChongzhiMapper mapper;
	@Autowired
	private CardHuiyuanbankaMapper hybkMapper;
	
	@Override
	public List<CardChongzhi> queryAll(ChongzhiPage page) {
		return mapper.queryAll(page);
	}

	@Override
	public void addsave(CardChongzhi cz) {
		//会员办卡Id
		String hcId = cz.getHcId();
		//查询会员办卡信息
		CardHuiyuanbanka hybk = hybkMapper.selectByPrimaryKey(hcId);
		//充值前卡内余额
		cz.setCzId(UUID.randomUUID().toString());
		cz.setCzTime(new Date());
		cz.setOldNum(hybk.getHcNum());
		CardHuiyuanbanka ch = new CardHuiyuanbanka();
		ch.setHcId(hcId);
		ch.setHcNum(hybk.getHcNum().add(cz.getCzNum()));
		hybkMapper.updateByPrimaryKeySelective(ch);
		
		mapper.insert(cz);
	}

	@Override
	public CardChongzhi selectById(String id) {
		
		
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			CardChongzhi cz = mapper.selectByPrimaryKey(id);
			
			CardHuiyuanbanka hybk = hybkMapper.selectOne(cz.getHcId());
			hybk.setHcNum(hybk.getHcNum().subtract(cz.getCzNum()));
			
			hybkMapper.updateByPrimaryKeySelective(hybk);
			mapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public void editsave(CardChongzhi cz) {
		//获取旧的充值记录
		CardChongzhi oldcz = mapper.selectByPrimaryKey(cz.getCzId());
		//把钱还回去
		CardHuiyuanbanka oldhybk = hybkMapper.selectOne(oldcz.getHcId());
		oldhybk.setHcNum(oldhybk.getHcNum().subtract(oldcz.getCzNum()));
		hybkMapper.updateByPrimaryKeySelective(oldhybk);
		//把新卡内的余额充进去
		CardHuiyuanbanka hybk = hybkMapper.selectOne(cz.getHcId());
		hybk.setHcNum(hybk.getHcNum().add(cz.getCzNum()));
		hybkMapper.updateByPrimaryKeySelective(hybk);
		//修改充值表
		cz.setCzTime(new Date());
		mapper.updateByPrimaryKeySelective(cz);
		
	}

	
	
}
