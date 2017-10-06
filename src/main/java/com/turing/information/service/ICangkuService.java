package com.turing.information.service;

import java.util.List;

import com.turing.information.entity.KcglCangku;
import com.turing.information.page.CangkuPage;

public interface ICangkuService {

	List<KcglCangku> queryAll(CangkuPage page);

	KcglCangku queryById(String id);

	void save(KcglCangku ck);

	void delete(String[] ids);

}
