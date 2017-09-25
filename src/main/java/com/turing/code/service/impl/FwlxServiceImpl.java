package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeFuwuleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeFuwuleixingMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IFwfsService;
import com.turing.code.service.IFwlxService;
import com.turing.code.service.IXydjService;

@Service
public class FwlxServiceImpl implements IFwlxService{

	@Autowired
	private CodeFuwuleixingMapper fwlxMapper;
	@Override
	public List<CodeFuwuleixing> queryAll() {
		return fwlxMapper.queryAll();
	}
	@Override
	public CodeFuwuleixing queryById(String id) {
		return fwlxMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			fwlxMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeFuwuleixing fwlx) {
		fwlxMapper.insertSelective(fwlx);
	}
	@Override
	public void edit(CodeFuwuleixing fwlx) {
		fwlxMapper.updateByPrimaryKeySelective(fwlx);
	}

}
