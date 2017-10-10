package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeAdds;
import com.turing.code.mapper.CodeAddsMapper;
import com.turing.code.service.IAddsService;
@Service
public class AddsServiceImpl implements IAddsService {
	@Autowired
	private CodeAddsMapper mapper;
	@Override
	public List<CodeAdds> queryShengList() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}
	@Override
	public List<CodeAdds> queryByParentId(String id) {
		return mapper.queryByParentId(id);
	}

}
