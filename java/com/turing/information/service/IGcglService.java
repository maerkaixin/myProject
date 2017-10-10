package com.turing.information.service;

import java.util.List;

import com.turing.information.entity.GdzcGongcheng;
import com.turing.information.page.GcglPage;

public interface IGcglService {

	List<GdzcGongcheng> queryAll(GcglPage page);

	void save(GdzcGongcheng gcgl);

	void delete(String[] ids);

	GdzcGongcheng queryById(String id);

}
