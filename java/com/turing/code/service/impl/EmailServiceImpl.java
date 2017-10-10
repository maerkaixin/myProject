package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeEmail;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeEmailMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IEmailService;
import com.turing.code.service.IXydjService;

@Service
public class EmailServiceImpl implements IEmailService{

	@Autowired
	private CodeEmailMapper emailMapper;
	@Override
	public List<CodeEmail> queryAll() {
		return emailMapper.queryAll();
	}
	@Override
	public CodeEmail queryById(String id) {
		return emailMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			emailMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeEmail email) {
		emailMapper.insertSelective(email);
	}
	@Override
	public void edit(CodeEmail email) {
		emailMapper.updateByPrimaryKeySelective(email);
	}

}
