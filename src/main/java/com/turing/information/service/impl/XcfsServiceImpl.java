package com.turing.information.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.information.entity.YxglXuanchuanfangshi;
import com.turing.information.mapper.YxglXuanchuanfangshiMapper;
import com.turing.information.page.XcfsPage;
import com.turing.information.service.IXcfsService;
@Service
public class XcfsServiceImpl implements IXcfsService{
	@Autowired
	private YxglXuanchuanfangshiMapper mapper;

	@Override
	public List<YxglXuanchuanfangshi> queryAll(XcfsPage page) {
		return mapper.queryAll();
	}

	@Override
	public YxglXuanchuanfangshi queryById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(YxglXuanchuanfangshi xcfs) {
			if (xcfs.getXcfsId()!=null && !xcfs.getXcfsId().equals("")) {
				mapper.updateByPrimaryKey(xcfs);
			}else{
				xcfs.setXcfsId(UUID.randomUUID().toString());
				xcfs.setXcfsInDate(new Date());
				mapper.insert(xcfs);
			}
	}

	@Override
	public void delete(String[] ids) {
		for (String string : ids) {
			mapper.deleteByPrimaryKey(string);
		}
	}
	
	
	
}
