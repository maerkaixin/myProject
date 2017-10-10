package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.entity.CodeYongpinleixing;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.mapper.CodeYongpinleixingMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IXydjService;
import com.turing.code.service.IYplxService;

@Service
public class YplxServiceImpl implements IYplxService{

	@Autowired
	private CodeYongpinleixingMapper yplxMapper;
	@Override
	public List<CodeYongpinleixing> queryAll() {
		return yplxMapper.queryAll();
	}
	@Override
	public CodeYongpinleixing queryById(String id) {
		return yplxMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			yplxMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeYongpinleixing yplx) {
		yplxMapper.insertSelective(yplx);
	}
	@Override
	public void edit(CodeYongpinleixing yplx) {
		yplxMapper.updateByPrimaryKeySelective(yplx);
	}

}
