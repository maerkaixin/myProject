package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeWeixiuleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeWeixiuleixingMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IWxlxService;
import com.turing.code.service.IXydjService;

@Service
public class WxlxServiceImpl implements IWxlxService{

	@Autowired
	private CodeWeixiuleixingMapper wxlxMapper;
	@Override
	public List<CodeWeixiuleixing> queryAll() {
		return wxlxMapper.queryAll();
	}
	@Override
	public CodeWeixiuleixing queryById(String id) {
		return wxlxMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			wxlxMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeWeixiuleixing wxlx) {
		wxlxMapper.insertSelective(wxlx);
	}
	@Override
	public void edit(CodeWeixiuleixing wxlx) {
		wxlxMapper.updateByPrimaryKeySelective(wxlx);
	}

}
