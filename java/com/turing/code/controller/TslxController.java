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
import com.turing.code.entity.CodeTousuleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ITslxService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("tslx")
@Scope("prototype")
public class TslxController {
	
	@Autowired
	private ITslxService tslxService;
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
		List<CodeTousuleixing> list = tslxService.queryAll();
		model.put("list", list);
		return "jsp/code/tslx/query_tslx";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/tslx/add_tslx";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeTousuleixing tslx = tslxService.queryById(id);
		mp.put("tslx", tslx);
		return "jsp/code/tslx/edit_tslx";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("投诉类型", 3, "删除一些数据");
		tslxService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeTousuleixing tslx){
		logUtils.write("投诉类型", 1, "添加一个数据");
		tslx.setCtlId(UUID.randomUUID().toString());
		tslxService.save(tslx);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeTousuleixing tslx){
		logUtils.write("投诉类型", 2, "修改一条数据");
		tslxService.edit(tslx);
		return "redirect:query.action";
	}
}
