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
import com.turing.code.entity.CodeGongchengleixing;
import com.turing.code.entity.CodeWeixiuleixing;
import com.turing.code.service.IGclxService;
import com.turing.code.service.IWxlxService;
import com.turing.information.entity.GdzcWeixiu;
import com.turing.information.page.WxPage;
import com.turing.information.service.IWxService;
import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysPerson;
import com.turing.system.service.IDeptService;
import com.turing.system.service.IPersonService;

@Controller
@RequestMapping(value = "wx")
@Scope(value = "prototype")
@SessionAttributes(types = WxPage.class)
public class WxController {
	@Autowired
	IWxService service;
	@Autowired
	private IWxlxService wxlxService;
	@Autowired
	private IPersonService personService;
	@Autowired
	private IDeptService deptService;
	@RequestMapping(value = "query")
	public String query(ModelMap modelMap, WxPage page) {

		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<GdzcWeixiu> list = service.queryAll(page);
		PageInfo<GdzcWeixiu> pageInfo = new PageInfo<GdzcWeixiu>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		
		return "jsp/information/wx/query_wx";
	}
	@RequestMapping(value="page")
	public String page(String id,ModelMap modelMap){
		List<CodeWeixiuleixing> wxlxList = wxlxService.queryAll();
		modelMap.put("wxlxList", wxlxList);
		List<SysPerson> personList = personService.queryPersonList();
		modelMap.put("personList", personList);
		List<SysDept> deptList = deptService.queryAllWithList();
		modelMap.put("deptList", deptList);
		if (id!=null && !id.equals("")) {
			GdzcWeixiu wx = service.queryById(id);
			modelMap.put("wx", wx);
		}	
		return "jsp/information/wx/page_wx";
	}

}
