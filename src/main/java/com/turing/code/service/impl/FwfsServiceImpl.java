package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeFuwufangshi;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeFuwufangshiMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IFwfsService;
import com.turing.code.service.IXydjService;

@Service
public class FwfsServiceImpl implements IFwfsService{

	@Autowired
	private CodeFuwufangshiMapper fwfsMapper;
	@Override
	public List<CodeFuwufangshi> queryAll() {
		return fwfsMapper.queryAll();
	}
	@Override
	public CodeFuwufangshi queryById(String id) {
		return fwfsMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			fwfsMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeFuwufangshi fwfs) {
		fwfsMapper.insertSelective(fwfs);
	}
	@Override
	public void edit(CodeFuwufangshi fwfs) {
		fwfsMapper.updateByPrimaryKeySelective(fwfs);
	}

}
