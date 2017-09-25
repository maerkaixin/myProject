package com.turing.huiyuan.service;

import java.util.List;




import com.turing.huiyuan.entity.HyglHuiyuan;

public interface IHyglService {

	List<HyglHuiyuan> queryAll();

	HyglHuiyuan selectByPrimaryKey(String id);

	void insert(HyglHuiyuan hy);

	void updateByPrimaryKey(HyglHuiyuan hy);

	void deleteByPrimaryKey(String[] ids);

}
