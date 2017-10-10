package com.turing.code.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.code.entity.CodeQiyexingzhi;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IQyxzService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("qyxz")
@Scope("prototype")
public class QyxzController {
	
	@Autowired
	private IQyxzService qyxzService;
	@Autowired
	private OperLogUtils logUtils;
	/**
	 * 查询信誉等级信息
	 * @param model	模型数据
	 * @param pageNum	当前页
	 * @param pageSize  每页多少条
	 * @return 页面
	 */
	@RequestMapping("query")
	public String query(ModelMap model){
		List<CodeQiyexingzhi> list = qyxzService.queryAll();
		model.put("list", list);
		return "jsp/code/qyxz/query_qyxz";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/qyxz/add_qyxz";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeQiyexingzhi qyxz = qyxzService.queryById(id);
		mp.put("qyxz", qyxz);
		return "jsp/code/qyxz/edit_qyxz";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("企业性质", 3, "删除一些数据");
		qyxzService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeQiyexingzhi qyxz){
		logUtils.write("企业性质", 1, "添加一个数据");
		qyxz.setCqxId(UUID.randomUUID().toString());
		qyxzService.save(qyxz);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeQiyexingzhi qyxz){
		logUtils.write("企业性质", 2, "修改一条数据");
		qyxzService.edit(qyxz);
		return "redirect:query.action";
	}
}
