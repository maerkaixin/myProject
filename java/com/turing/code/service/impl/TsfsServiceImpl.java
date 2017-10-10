package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeTousufangshi;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeTousufangshiMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ITsfsService;
import com.turing.code.service.IXydjService;

@Service
public class TsfsServiceImpl implements ITsfsService{

	@Autowired
	private CodeTousufangshiMapper tsfsMapper;
	@Override
	public List<CodeTousufangshi> queryAll() {
		return tsfsMapper.queryAll();
	}
	@Override
	public CodeTousufangshi queryById(String id) {
		return tsfsMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			tsfsMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeTousufangshi tsfs) {
		tsfsMapper.insertSelective(tsfs);
	}
	@Override
	public void edit(CodeTousufangshi tsfs) {
		tsfsMapper.updateByPrimaryKeySelective(tsfs);
	}

}
