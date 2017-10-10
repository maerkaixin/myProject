package com.turing.code.service;

import java.util.List;

import com.turing.code.entity.CodeGongchengleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;

public interface IGclxService {
	/**
	 * 查询信誉等级所有数据
	 * @return
	 */
	List<CodeGongchengleixing> queryAll();
	/**
	 * 根据主键，查询一个信誉等级对象
	 * @param id
	 * @return
	 */
	CodeGongchengleixing queryById(String id);
	/**
	 * 根据主键的集合删除数据库中的数据
	 * @param ids
	 */
	void delete(String[] ids);
	/**
	 * 保存一个对象
	 * @param xydj
	 */
	void save(CodeGongchengleixing gclx);
	/**
	 * 修改一个对象
	 * @param xydj
	 */
	void edit(CodeGongchengleixing gclx);

}
