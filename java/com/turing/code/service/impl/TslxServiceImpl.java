package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeTousuleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeTousuleixingMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ITslxService;
import com.turing.code.service.IXydjService;

@Service
public class TslxServiceImpl implements ITslxService{

	@Autowired
	private CodeTousuleixingMapper tslxMapper;
	@Override
	public List<CodeTousuleixing> queryAll() {
		return tslxMapper.queryAll();
	}
	@Override
	public CodeTousuleixing queryById(String id) {
		return tslxMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			tslxMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeTousuleixing tslx) {
		tslxMapper.insertSelective(tslx);
	}
	@Override
	public void edit(CodeTousuleixing tslx) {
		tslxMapper.updateByPrimaryKeySelective(tslx);
	}

}
