package com.turing.card.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.entity.CardZhuanka;
import com.turing.card.mapper.CardHuiyuanbankaMapper;
import com.turing.card.mapper.CardZhuankaMapper;
import com.turing.card.page.ZhuankaPage;
import com.turing.card.service.IZhuankaService;

@Service
public class ZhuankaServiceImpl implements IZhuankaService {
	@Autowired
	private CardZhuankaMapper mapper;
	@Autowired
	private CardHuiyuanbankaMapper hybkmapper;
	@Override
	public List<CardZhuanka> queryAll(ZhuankaPage page) {
		return mapper.queryAll(page);
	}

	@Override
	public void addsave(CardZhuanka zk) {
		//校验转卡金额
		
		//转出卡扣钱 
		CardHuiyuanbanka zck = hybkmapper.selectOne(zk.getZkOldId());
		zck.setHcNum(zck.getHcNum().subtract(zk.getZkNum()));
		hybkmapper.updateByPrimaryKeySelective(zck);
		//转入卡加钱
		CardHuiyuanbanka zrk = hybkmapper.selectOne(zk.getZkNewId());
		zrk.setHcNum(zrk.getHcNum().add(zk.getZkNum()));
		hybkmapper.updateByPrimaryKeySelective(zrk);
		//添加转卡记录
		zk.setZkId(UUID.randomUUID().toString());
		zk.setZkTime(new Date());
		mapper.insertSelective(zk);
	}

}
