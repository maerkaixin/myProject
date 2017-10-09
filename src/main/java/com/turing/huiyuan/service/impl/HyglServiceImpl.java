package com.turing.huiyuan.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.turing.framework.util.FileUtils;
import com.turing.huiyuan.entity.HyglHuiyuan;
import com.turing.huiyuan.mapper.HyglHuiyuanMapper;
import com.turing.huiyuan.page.HyglHuiyuanPage;
import com.turing.huiyuan.service.IHyglService;
@Service
public class HyglServiceImpl implements IHyglService {
	@Autowired
	private HyglHuiyuanMapper mapper;
	@Override
	public List<HyglHuiyuan> queryAll(HyglHuiyuanPage page) {
		return mapper.queryAll(page);
	}
	@Override
	public HyglHuiyuan selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}
	@Override
	public void insert(HyglHuiyuan hy, CommonsMultipartFile picFile, HttpServletRequest request) {
		if (!picFile.isEmpty()) {
			String path = FileUtils.upload(picFile, request);
			hy.setHyPic(path);
		}
		mapper.insert(hy);
		
	}
	@Override
	public void updateByPrimaryKey(HyglHuiyuan hy, CommonsMultipartFile picFile, HttpServletRequest request) {
		if (!picFile.isEmpty()) {
			FileUtils.delete(mapper.selectByPrimaryKey(hy.getHyId()).getHyPic(), request);
			String hyPic = FileUtils.upload(picFile, request);
			hy.setHyPic(hyPic);
		}
		
		
		mapper.updateByPrimaryKey(hy);
	}
	@Override
	public void deleteByPrimaryKey(String[] ids, HttpServletRequest request) {
		for (String string : ids) {
			FileUtils.delete(mapper.selectByPrimaryKey(string).getHyPic(), request);
			mapper.deleteByPrimaryKey(string);
		}
	}
	@Override
	public List<HyglHuiyuan> srtxQuery(HyglHuiyuanPage page) {
		if (page!=null && page.getHyName()!=null) {
			page.setHyNames(page.getHyName().split(" "));;
		}
		return mapper.srtxQuery(page);
	}

}
