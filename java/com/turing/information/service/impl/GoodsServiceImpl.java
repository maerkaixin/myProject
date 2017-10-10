package com.turing.information.service.impl;

import java.util.List;
import java.util.UUID;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.information.entity.KcglGoods;
import com.turing.information.mapper.KcglGoodsMapper;
import com.turing.information.page.GoodsPage;
import com.turing.information.service.IGoodsService;
@Service
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private KcglGoodsMapper mapper;
	@Override
	public List<KcglGoods> queryAll(GoodsPage page) {
		return mapper.queryAll(page);
	}
	@Override
	public KcglGoods queryById(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(KcglGoods goods) {
		if (goods.getGoodsId()!=null && !goods.getGoodsId().equals("")) {
			mapper.updateByPrimaryKey(goods);
		}else {
			goods.setGoodsId(UUID.randomUUID().toString());
			goods.setGoodsState("A");
			mapper.insert(goods);
		}
	}
	@Override
	public void delete(String[] ids) {
		for (String string : ids) {
			mapper.updateStatsById(string);
		}
	}

}
