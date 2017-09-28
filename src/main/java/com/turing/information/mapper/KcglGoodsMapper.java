package com.turing.information.mapper;

import java.util.List;

import com.turing.information.entity.KcglGoods;
import com.turing.information.page.GoodsPage;

public interface KcglGoodsMapper {
    int deleteByPrimaryKey(String goodsId);

    int insert(KcglGoods record);

    int insertSelective(KcglGoods record);

    KcglGoods selectByPrimaryKey(String goodsId);

    int updateByPrimaryKeySelective(KcglGoods record);

    int updateByPrimaryKey(KcglGoods record);

	List<KcglGoods> queryAll(GoodsPage page);

	void updateStatsById(String string);
}