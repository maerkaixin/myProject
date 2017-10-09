package com.turing.huiyuan.service;

import java.util.List;






import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.turing.huiyuan.entity.HyglHuiyuan;
import com.turing.huiyuan.page.HyglHuiyuanPage;

public interface IHyglService {

	List<HyglHuiyuan> queryAll(HyglHuiyuanPage page);

	HyglHuiyuan selectByPrimaryKey(String id);

	void insert(HyglHuiyuan hy, CommonsMultipartFile picFile, HttpServletRequest request);

	void updateByPrimaryKey(HyglHuiyuan hy, CommonsMultipartFile picFile, HttpServletRequest request);

	void deleteByPrimaryKey(String[] ids, HttpServletRequest request);

	List<HyglHuiyuan> srtxQuery(HyglHuiyuanPage page);

}
