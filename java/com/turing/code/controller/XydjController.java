package com.turing.code.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;

@Controller
@RequestMapping("xydj")
@Scope("prototype")
@SessionAttributes(types=XydjPage.class)
public class XydjController {
	
	@Autowired
	private IXydjService xydjService;
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
	public String query(ModelMap model,XydjPage page){
		
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CodeXinyvdengji> list = xydjService.queryAll();
		
		PageInfo<CodeXinyvdengji> pageInfo = new PageInfo<CodeXinyvdengji>(list);
		model.put("pageInfo", pageInfo);
		model.put("page", page);
		
		
		return "jsp/code/xydj/query_xydj";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/xydj/add_xydj";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeXinyvdengji xydj = xydjService.queryById(id);
		mp.put("xydj", xydj);
		return "jsp/code/xydj/edit_xydj";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("信誉等级", 3, "删除一些数据");
		xydjService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeXinyvdengji xydj){
		logUtils.write("信誉等级", 1, "添加一个数据");
		xydj.setCxyId(UUID.randomUUID().toString());
		xydjService.save(xydj);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeXinyvdengji xydj){
		logUtils.write("信誉等级", 2, "修改一条数据");
		xydjService.edit(xydj);
		return "redirect:query.action";
	}
}
