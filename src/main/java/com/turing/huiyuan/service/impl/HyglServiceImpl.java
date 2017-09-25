package com.turing.huiyuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.huiyuan.entity.HyglHuiyuan;
import com.turing.huiyuan.mapper.HyglHuiyuanMapper;
import com.turing.huiyuan.service.IHyglService;
@Service
public class HyglServiceImpl implements IHyglService {
	@Autowired
	private HyglHuiyuanMapper mapper;
	@Override
	public List<HyglHuiyuan> queryAll() {
		return mapper.queryAll();
	}
	@Override
	public HyglHuiyuan selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}
	@Override
	public void insert(HyglHuiyuan hy) {
		mapper.insert(hy);
		
	}
	@Override
	public void updateByPrimaryKey(HyglHuiyuan hy) {
		mapper.updateByPrimaryKey(hy);
	}
	@Override
	public void deleteByPrimaryKey(String[] ids) {
		for (String string : ids) {
			mapper.deleteByPrimaryKey(string);
		}
	}

}