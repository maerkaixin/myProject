package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeShangpinpinpai;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeShangpinpinpaiMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ISpppService;
import com.turing.code.service.IXydjService;

@Service
public class SpppServiceImpl implements ISpppService{

	@Autowired
	private CodeShangpinpinpaiMapper spppMapper;
	@Override
	public List<CodeShangpinpinpai> queryAll() {
		return spppMapper.queryAll();
	}
	@Override
	public CodeShangpinpinpai queryById(String id) {
		return spppMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			spppMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeShangpinpinpai sppp) {
		spppMapper.insertSelective(sppp);
	}
	@Override
	public void edit(CodeShangpinpinpai sppp) {
		spppMapper.updateByPrimaryKeySelective(sppp);
	}

}
