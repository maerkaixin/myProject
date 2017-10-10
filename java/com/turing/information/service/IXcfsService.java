package com.turing.information.service;

import java.util.List;

import com.turing.information.entity.YxglXuanchuanfangshi;
import com.turing.information.page.XcfsPage;

public interface IXcfsService {

	List<YxglXuanchuanfangshi> queryAll(XcfsPage page);

	YxglXuanchuanfangshi queryById(String id);

	void save(YxglXuanchuanfangshi xcfs);

	void delete(String[] ids);

}
