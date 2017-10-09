package com.turing.information.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.information.entity.GdzcChuwugui;
import com.turing.information.mapper.GdzcChuwuguiMapper;
import com.turing.information.page.CwgPage;
import com.turing.information.service.ICwgService;
@Service
public class CwgServiceImpl implements ICwgService {
	@Autowired
	private GdzcChuwuguiMapper mapper;

	@Override
	public List<GdzcChuwugui> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public void save(GdzcChuwugui cwg) {
		if (cwg.getCwgId()!=null && !cwg.getCwgId().equals("")) {
			mapper.updateByPrimaryKey(cwg);
		}else{
			cwg.setCwgId(UUID.randomUUID().toString());
			cwg.setCwgState("A");
			mapper.insert(cwg);
		}
	}

	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			mapper.changeState(ids[i]);
		}
	}

	@Override
	public GdzcChuwugui queryById(String cwgId) {
		return mapper.selectByPrimaryKey(cwgId);
	}

	@Override
	public void huifu(String id) {
		 mapper.huifu(id);
	}
	
	
	
}
