package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeAihao;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeAihaoMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IAIhaoService;
import com.turing.code.service.IXydjService;

@Service
public class AihaoServiceImpl implements IAIhaoService{

	@Autowired
	private CodeAihaoMapper aihaoMapper;
	@Override
	public List<CodeAihao> queryAll() {
		return aihaoMapper.queryAll();
	}
	@Override
	public CodeAihao queryById(String id) {
		return aihaoMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			aihaoMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeAihao aihao) {
		aihaoMapper.insertSelective(aihao);
	}
	@Override
	public void edit(CodeAihao aihao) {
		aihaoMapper.updateByPrimaryKeySelective(aihao);
	}

}
