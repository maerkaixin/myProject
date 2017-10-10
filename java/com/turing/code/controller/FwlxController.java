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
import com.turing.code.entity.CodeFuwuleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IFwlxService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("fwlx")
@Scope("prototype")
public class FwlxController {
	
	@Autowired
	private IFwlxService fwlxService;
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
		List<CodeFuwuleixing> list = fwlxService.queryAll();
		model.put("list", list);
		return "jsp/code/fwlx/query_fwlx";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/fwlx/add_fwlx";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeFuwuleixing fwlx = fwlxService.queryById(id);
		mp.put("fwlx", fwlx);
		return "jsp/code/fwlx/edit_fwlx";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("服务类型", 3, "删除一些数据");
		fwlxService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeFuwuleixing fwlx){
		logUtils.write("服务类型", 1, "添加一个数据");
		fwlx.setCflId(UUID.randomUUID().toString());
		fwlxService.save(fwlx);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeFuwuleixing fwlx){
		logUtils.write("服务类型", 2, "修改一条数据");
		fwlxService.edit(fwlx);
		return "redirect:query.action";
	}
}
