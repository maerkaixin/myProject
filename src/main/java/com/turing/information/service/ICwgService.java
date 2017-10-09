package com.turing.information.service;

import java.util.List;

import com.turing.information.entity.GdzcChuwugui;
import com.turing.information.page.CwgPage;

public interface ICwgService {

	List<GdzcChuwugui> queryAll();

	void save(GdzcChuwugui cwg);

	void delete(String[] ids);


	GdzcChuwugui queryById(String cwgId);

	void huifu(String id);

}
