package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeShangpindanwei;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeShangpindanweiMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ISpdwService;
import com.turing.code.service.IXydjService;

@Service
public class SpdwServiceImpl implements ISpdwService{

	@Autowired
	private CodeShangpindanweiMapper spdwMapper;
	@Override
	public List<CodeShangpindanwei> queryAll() {
		return spdwMapper.queryAll();
	}
	@Override
	public CodeShangpindanwei queryById(String id) {
		return spdwMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			spdwMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeShangpindanwei spdw) {
		spdwMapper.insertSelective(spdw);
	}
	@Override
	public void edit(CodeShangpindanwei spdw) {
		spdwMapper.updateByPrimaryKeySelective(spdw);
	}

}
