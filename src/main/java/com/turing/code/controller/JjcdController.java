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
import com.turing.code.entity.CodeJinjichengdu;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IJjcdService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("jjcd")
@Scope("prototype")
public class JjcdController {
	
	@Autowired
	private IJjcdService jjcdService;
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
		List<CodeJinjichengdu> list = jjcdService.queryAll();
		model.put("list", list);
		return "jsp/code/jjcd/query_jjcd";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/jjcd/add_jjcd";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeJinjichengdu jjcd = jjcdService.queryById(id);
		mp.put("jjcd", jjcd);
		return "jsp/code/jjcd/edit_jjcd";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("紧急程度", 3, "删除一些数据");
		jjcdService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeJinjichengdu jjcd){
		logUtils.write("紧急程度", 1, "添加一个数据");
		jjcd.setCjcId(UUID.randomUUID().toString());
		jjcdService.save(jjcd);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeJinjichengdu jjcd){
		logUtils.write("紧急程度", 2, "修改一条数据");
		jjcdService.edit(jjcd);
		return "redirect:query.action";
	}
}
