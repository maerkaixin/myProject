package com.turing.khgl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.khgl.entity.KhglQiye;
import com.turing.khgl.mapper.KhglQiyeMapper;
import com.turing.khgl.service.IQiyeService;
@Service
public class QiyeServiceImpl implements IQiyeService {
	@Autowired
	private KhglQiyeMapper mapper;
	
	public List<KhglQiye> queryAllWithList(){
		return mapper.queryAllWithList(); 
	}
}
