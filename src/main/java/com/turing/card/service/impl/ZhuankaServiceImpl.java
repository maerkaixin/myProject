package com.turing.card.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.card.entity.CardZhuanka;
import com.turing.card.mapper.CardZhuankaMapper;
import com.turing.card.page.ZhuankaPage;
import com.turing.card.service.IZhuankaService;

@Service
public class ZhuankaServiceImpl implements IZhuankaService {
	@Autowired
	private CardZhuankaMapper mapper;

	@Override
	public List<CardZhuanka> queryAll(ZhuankaPage page) {
		return mapper.queryAll(page);
	}

}
