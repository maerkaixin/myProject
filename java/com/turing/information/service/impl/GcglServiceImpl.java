package com.turing.information.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.information.entity.GdzcGongcheng;
import com.turing.information.mapper.GdzcGongchengMapper;
import com.turing.information.page.GcglPage;
import com.turing.information.service.IGcglService;
@Service
public class GcglServiceImpl implements IGcglService{
	@Autowired
	private GdzcGongchengMapper mapper;

	@Override
	public List<GdzcGongcheng> queryAll(GcglPage page) {
		return mapper.queryAll(page);
	}

	@Override
	public void save(GdzcGongcheng gcgl) {
		if (gcgl.getGcId()!=null && !"".equals(gcgl.getGcId())) {
			mapper.updateByPrimaryKey(gcgl);
		}else{
			gcgl.setGcId(UUID.randomUUID().toString());
			mapper.insert(gcgl);
		}
	}

	@Override
	public void delete(String[] ids) {
		for (String string : ids) {
			mapper.deleteByPrimaryKey(string);
		}
	}

	@Override
	public GdzcGongcheng queryById(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	
	
}
