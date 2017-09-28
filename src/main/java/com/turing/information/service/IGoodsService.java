package com.turing.information.service;

import java.util.List;

import com.turing.information.entity.KcglGoods;
import com.turing.information.page.GoodsPage;

public interface IGoodsService {

	List<KcglGoods> queryAll(GoodsPage page);

	KcglGoods queryById(String id);

	void save(KcglGoods goods);

	void delete(String[] ids);

}
