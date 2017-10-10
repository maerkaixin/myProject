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
import com.turing.code.entity.CodeGongchengleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IGclxService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("gclx")
@Scope("prototype")
public class GclxController {
	
	@Autowired
	private IGclxService gclxService;
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
		List<CodeGongchengleixing> list = gclxService.queryAll();
		model.put("list", list);
		return "jsp/code/gclx/query_gclx";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/gclx/add_gclx";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeGongchengleixing gclx = gclxService.queryById(id);
		mp.put("gclx", gclx);
		return "jsp/code/gclx/edit_gclx";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("工程类型", 3, "删除一些数据");
		gclxService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeGongchengleixing gclx){
		logUtils.write("工程类型", 1, "添加一个数据");
		gclx.setCglId(UUID.randomUUID().toString());
		gclxService.save(gclx);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeGongchengleixing gclx){
		logUtils.write("工程类型", 2, "修改一条数据");
		gclxService.edit(gclx);
		return "redirect:query.action";
	}
}
