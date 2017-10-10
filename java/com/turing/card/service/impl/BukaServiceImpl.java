package com.turing.card.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.card.entity.CardBuka;
import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.mapper.CardBukaMapper;
import com.turing.card.mapper.CardHuiyuanbankaMapper;
import com.turing.card.page.BukaPage;
import com.turing.card.service.IBukaService;
@Service
public class BukaServiceImpl implements IBukaService {
	@Autowired
	 private CardBukaMapper mapper;
	@Autowired
	private CardHuiyuanbankaMapper hybkMapper;
	@Override
	public List<CardBuka> queryAll(BukaPage page) {
		return mapper.queryAll(page);
	}
	@Override
	public void save(CardBuka bk) {
		if (StringUtils.isNotBlank(bk.getBkId())) {//修改保存
			//将旧卡的卡号还原
			CardBuka oldbk = mapper.selectById(bk.getBkId());
			CardHuiyuanbanka oldhybk = hybkMapper.selectOne(oldbk.getHcId());
			oldhybk.setHcNo(oldbk.getBkOldNo());
			hybkMapper.updateByPrimaryKey(oldhybk);
			//修改新卡的卡号
			CardHuiyuanbanka newhybk = hybkMapper.selectOne(bk.getHcId());
			newhybk.setHcNo(bk.getBkNo());
			hybkMapper.updateByPrimaryKey(newhybk);
			//修改补卡记录
			bk.setBkTime(new Date());
			mapper.updateByPrimaryKeySelective(bk);
			
		}else{
			//更新会员办卡表字段
			CardHuiyuanbanka hybk = hybkMapper.selectOne(bk.getHcId());
			hybk.setHcNo(bk.getBkNo());
			hybkMapper.updateByPrimaryKeySelective(hybk);
			
			//新增保存
			bk.setBkId(UUID.randomUUID().toString());
			bk.setBkTime(new Date());
			mapper.insertSelective(bk);
		}
		
		
		
	}
	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			CardBuka bk = mapper.selectByPrimaryKey(id);
			CardHuiyuanbanka hybk = hybkMapper.selectOne(bk.getHcId());
			hybk.setHcNo(bk.getBkOldNo());
			hybkMapper.updateByPrimaryKeySelective(hybk);
			mapper.deleteByPrimaryKey(id);
		}
		
		
		
		
	}
	@Override
	public CardBuka selectById(String id) {
		return mapper.selectById(id);
	}

}
