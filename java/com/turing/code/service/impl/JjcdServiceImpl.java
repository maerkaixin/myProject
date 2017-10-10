package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeJinjichengdu;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeJinjichengduMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IJjcdService;
import com.turing.code.service.IXydjService;

@Service
public class JjcdServiceImpl implements IJjcdService{

	@Autowired
	private CodeJinjichengduMapper jjcdMapper;
	@Override
	public List<CodeJinjichengdu> queryAll() {
		return jjcdMapper.queryAll();
	}
	@Override
	public CodeJinjichengdu queryById(String id) {
		return jjcdMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			jjcdMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeJinjichengdu jjcd) {
		jjcdMapper.insertSelective(jjcd);
	}
	@Override
	public void edit(CodeJinjichengdu jjcd) {
		jjcdMapper.updateByPrimaryKeySelective(jjcd);
	}

}
