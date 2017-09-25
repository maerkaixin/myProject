package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeHangyeleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeHangyeleixingMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IHylxService;
import com.turing.code.service.IXydjService;

@Service
public class HylxServiceImpl implements IHylxService{

	@Autowired
	private CodeHangyeleixingMapper hyxlMapper;
	@Override
	public List<CodeHangyeleixing> queryAll() {
		return hyxlMapper.queryAll();
	}
	@Override
	public CodeHangyeleixing queryById(String id) {
		return hyxlMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			hyxlMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeHangyeleixing hylx) {
		hyxlMapper.insertSelective(hylx);
	}
	@Override
	public void edit(CodeHangyeleixing hylx) {
		hyxlMapper.updateByPrimaryKeySelective(hylx);
	}

}
