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
import com.turing.code.entity.CodeRuhuifangshi;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IRhfsService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("rhfs")
@Scope("prototype")
public class RhfsController {
	
	@Autowired
	private IRhfsService rhfsService;
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
		List<CodeRuhuifangshi> list = rhfsService.queryAll();
		model.put("list", list);
		return "jsp/code/rhfs/query_rhfs";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/rhfs/add_rhfs";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeRuhuifangshi xydj = rhfsService.queryById(id);
		mp.put("xydj", xydj);
		return "jsp/code/rhfs/edit_rhfs";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("入会方式", 3, "删除一些数据");
		rhfsService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeRuhuifangshi rhfs){
		logUtils.write("入会方式", 1, "添加一个数据");
		rhfs.setCrfId(UUID.randomUUID().toString());
		rhfsService.save(rhfs);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeRuhuifangshi rhfs){
		logUtils.write("入会方式", 2, "修改一条数据");
		rhfsService.edit(rhfs);
		return "redirect:query.action";
	}
}
