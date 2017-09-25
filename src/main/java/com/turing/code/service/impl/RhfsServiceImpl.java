package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeRuhuifangshi;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeRuhuifangshiMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IRhfsService;
import com.turing.code.service.IXydjService;

@Service
public class RhfsServiceImpl implements IRhfsService{

	@Autowired
	private CodeRuhuifangshiMapper rhfsMapper;
	@Override
	public List<CodeRuhuifangshi> queryAll() {
		return rhfsMapper.queryAll();
	}
	@Override
	public CodeRuhuifangshi queryById(String id) {
		return rhfsMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			rhfsMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeRuhuifangshi rhfs) {
		rhfsMapper.insertSelective(rhfs);
	}
	@Override
	public void edit(CodeRuhuifangshi rhfs) {
		rhfsMapper.updateByPrimaryKeySelective(rhfs);
	}

}
