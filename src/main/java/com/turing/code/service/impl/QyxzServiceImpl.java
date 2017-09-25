package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeQiyexingzhi;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeQiyexingzhiMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IQyxzService;
import com.turing.code.service.IXydjService;

@Service
public class QyxzServiceImpl implements IQyxzService{

	@Autowired
	private CodeQiyexingzhiMapper qyxzMapper;
	@Override
	public List<CodeQiyexingzhi> queryAll() {
		return qyxzMapper.queryAll();
	}
	@Override
	public CodeQiyexingzhi queryById(String id) {
		return qyxzMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			qyxzMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeQiyexingzhi qyxz) {
		qyxzMapper.insertSelective(qyxz);
	}
	@Override
	public void edit(CodeQiyexingzhi qyxz) {
		qyxzMapper.updateByPrimaryKeySelective(qyxz);
	}

}
