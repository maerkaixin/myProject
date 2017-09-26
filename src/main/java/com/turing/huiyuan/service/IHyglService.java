package com.turing.huiyuan.service;

import java.util.List;





import com.turing.huiyuan.entity.HyglHuiyuan;
import com.turing.huiyuan.page.HyglHuiyuanPage;

public interface IHyglService {

	List<HyglHuiyuan> queryAll(HyglHuiyuanPage page);

	HyglHuiyuan selectByPrimaryKey(String id);

	void insert(HyglHuiyuan hy);

	void updateByPrimaryKey(HyglHuiyuan hy);

	void deleteByPrimaryKey(String[] ids);

	List<HyglHuiyuan> srtxQuery(HyglHuiyuanPage page);

}
