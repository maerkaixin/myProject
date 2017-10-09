package com.turing.information.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.information.entity.KcglCangku;
import com.turing.information.mapper.KcglCangkuMapper;
import com.turing.information.page.CangkuPage;
import com.turing.information.service.ICangkuService;

@Service
public class CangkuServiceImpl implements ICangkuService {
	@Autowired
	private KcglCangkuMapper mapper;

	@Override
	public List<KcglCangku> queryAll(CangkuPage page) {
		return mapper.queryAll(page);
	}

	@Override
	public KcglCangku queryById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(KcglCangku ck) {
		if (ck.getCkId() != null && !ck.getCkId().equals("")) {
			mapper.updateByPrimaryKey(ck);
		} else {
			ck.setCkId(UUID.randomUUID().toString());
			mapper.insert(ck);
		}
	}

	@Override
	public void delete(String[] ids) {
		for (String string : ids) {
			mapper.deleteByPrimaryKey(string);
		}
	}

	@Override
	public List<KcglCangku> queryByCkName(String ckName) {
		return mapper.queryByCkName(ckName);
	}

	@Override
	public List<KcglCangku> queryByCkNo(String ckNo) {
		return mapper.queryByCkNo(ckNo);
	}

}
