package com.turing.information.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeWeixiuleixing;
import com.turing.information.entity.GdzcWeixiu;
import com.turing.information.mapper.GdzcWeixiuMapper;
import com.turing.information.page.WxPage;
import com.turing.information.service.IWxService;
@Service
public class WxServiceImpl implements IWxService {
	@Autowired
	private GdzcWeixiuMapper mapper;
	@Override
	public List<GdzcWeixiu> queryAll(WxPage page) {
		return mapper.queryAll(page);
	}
	@Override
	public GdzcWeixiu queryById(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	@Override
	public void save(GdzcWeixiu wx) {
		if (wx.getWxjlId()!=null && !wx.getWxjlId().equals("")) {
			wx.setWxjlId(UUID.randomUUID().toString());
			mapper.insert(wx);
		}else {
			mapper.updateByPrimaryKey(wx);
		}
	}
	@Override
	public void delete(String[] ids) {
		for (String string : ids) {
			mapper.deleteByPrimaryKey(string);
		}
	}

	
	
	
	
}
