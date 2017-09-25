package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeWeixianpingji;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeWeixianpingjiMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IWxpjService;
import com.turing.code.service.IXydjService;

@Service
public class WxpjServiceImpl implements IWxpjService{

	@Autowired
	private CodeWeixianpingjiMapper wxpjMapper;
	@Override
	public List<CodeWeixianpingji> queryAll() {
		return wxpjMapper.queryAll();
	}
	@Override
	public CodeWeixianpingji queryById(String id) {
		return wxpjMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			wxpjMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeWeixianpingji wxpj) {
		wxpjMapper.insertSelective(wxpj);
	}
	@Override
	public void edit(CodeWeixianpingji wxpj) {
		wxpjMapper.updateByPrimaryKeySelective(wxpj);
	}

}
