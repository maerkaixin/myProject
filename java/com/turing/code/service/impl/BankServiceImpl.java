package com.turing.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.code.entity.CodeBank;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.mapper.CodeBankMapper;
import com.turing.code.mapper.CodeXinyvdengjiMapper;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IBankService;
import com.turing.code.service.IXydjService;

@Service
public class BankServiceImpl implements IBankService{

	@Autowired
	private CodeBankMapper bankMapper;
	@Override
	public List<CodeBank> queryAll() {
		return bankMapper.queryAll();
	}
	@Override
	public CodeBank queryById(String id) {
		return bankMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			bankMapper.deleteByPrimaryKey(ids[i]);
		}
	}
	@Override
	public void save(CodeBank bank) {
		bankMapper.insertSelective(bank);
	}
	@Override
	public void edit(CodeBank bank) {
		bankMapper.updateByPrimaryKeySelective(bank);
	}

}
