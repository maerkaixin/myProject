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
import com.turing.information.entity.GdzcChuwugui;
import com.turing.information.page.CwgPage;
import com.turing.information.service.ICwgService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "cwg")
@SessionAttributes(types = CwgPage.class)
public class CwgController {
	@Autowired
	private ICwgService service;

	@RequestMapping(value = "query")
	public String query(CwgPage page, ModelMap mm) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		// 接
		// 掉
		List<GdzcChuwugui> list = service.queryAll();
		PageInfo<GdzcChuwugui> pageInfo = new PageInfo<GdzcChuwugui>(list);
		// 存
		mm.put("pageInfo", pageInfo);
		mm.put("page", page);
		// 转
		return "jsp/information/cwg/query_cwg";
	}

	@RequestMapping(value = "page")
	public String page(String id,ModelMap mm) {
		if (id != null && !id.equals("")) {
			GdzcChuwugui cwg = service.queryById(id);
			mm.put("cwg", cwg);
		}
		return "jsp/information/cwg/page_cwg";
	}

	@RequestMapping(value = "save")
	public String save(GdzcChuwugui cwg) {
		service.save(cwg);
		return "redirect:query.action";
	}

	@RequestMapping(value = "delete")
	public String delete(String ids[]) {
		service.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping(value = "huifu")
	public String huifu(String id) {
		service.huifu(id);
		return "redirect:query.action";
	}

}
