package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeGongchengleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeGongchengleixingMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IGclxService;
import com.turing.code.service.IXydjService;

@Service
public class GclxServiceImpl implements IGclxService{

	@Autowired
	private CodeGongchengleixingMapper gclxMapper;
	@Override
	public List<CodeGongchengleixing> queryAll() {
		return gclxMapper.queryAll();
	}
	@Override
	public CodeGongchengleixing queryById(String id) {
		return gclxMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			gclxMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeGongchengleixing gclx) {
		gclxMapper.insertSelective(gclx);
	}
	@Override
	public void edit(CodeGongchengleixing gclx) {
		gclxMapper.updateByPrimaryKeySelective(gclx);
	}

}
