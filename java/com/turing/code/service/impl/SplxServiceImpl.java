package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeShangpinleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeShangpinleixingMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ISplxService;
import com.turing.code.service.IXydjService;

@Service
public class SplxServiceImpl implements ISplxService{

	@Autowired
	private CodeShangpinleixingMapper splxMapper;
	@Override
	public List<CodeShangpinleixing> queryAll() {
		return splxMapper.queryAll();
	}
	@Override
	public CodeShangpinleixing queryById(String id) {
		return splxMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			splxMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeShangpinleixing splx) {
		splxMapper.insertSelective(splx);
	}
	@Override
	public void edit(CodeShangpinleixing splx) {
		splxMapper.updateByPrimaryKeySelective(splx);
	}

}
