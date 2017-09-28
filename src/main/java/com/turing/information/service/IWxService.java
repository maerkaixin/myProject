package com.turing.information.service;

import java.util.List;

import com.turing.code.entity.CodeWeixiuleixing;
import com.turing.information.entity.GdzcWeixiu;
import com.turing.information.page.WxPage;

public interface IWxService {

	List<GdzcWeixiu> queryAll(WxPage page);

	GdzcWeixiu queryById(String id);

	void save(GdzcWeixiu wx);

	void delete(String[] ids);

}
