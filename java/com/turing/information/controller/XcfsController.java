package com.turing.information.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.information.entity.YxglXuanchuanfangshi;
import com.turing.information.page.XcfsPage;
import com.turing.information.service.IXcfsService;

@Controller
@RequestMapping(value = "xcfs")
@Scope(value = "prototype")
@SessionAttributes(types = XcfsPage.class)
public class XcfsController {
	@Autowired
	private IXcfsService service;
	
	@RequestMapping(value="query")
	public String query(ModelMap modelMap, XcfsPage page){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<YxglXuanchuanfangshi> list= service.queryAll(page);
		PageInfo<YxglXuanchuanfangshi> pageInfo = new PageInfo<YxglXuanchuanfangshi>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/information/xcfs/query_xcfs";
	}
	
	@RequestMapping(value="page")
	public String page(ModelMap modelMap ,String id){
		if (id!=null && !id.equals("")) {
			YxglXuanchuanfangshi xcfs = service.queryById(id);
			modelMap.put("xcfs", xcfs);
		}
		return "jsp/information/xcfs/page_xcfs";
	}
	
	@RequestMapping(value="save")	
	public String save(YxglXuanchuanfangshi xcfs){
		service.save(xcfs);
		return "redirect:query.action";
	}
	
	@RequestMapping(value="delete")	
	public String delete(String ids[]){
		service.delete(ids);
		return "redirect:query.action";
	}
}
