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
import com.turing.code.service.IGclxService;
import com.turing.information.entity.GdzcGongcheng;
import com.turing.information.page.GcglPage;
import com.turing.information.service.IGcglService;
import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysPerson;
import com.turing.system.service.IDeptService;
import com.turing.system.service.IPersonService;

@Controller
@RequestMapping(value="gcgl")
@Scope(value="prototype")
@SessionAttributes(types=GcglPage.class)
public class GcglController {
	@Autowired
	private IGcglService service;
	@Autowired
	private IGclxService gclxService;
	@Autowired
	private IPersonService personService;
	@Autowired
	private IDeptService deptService;
	
	@RequestMapping(value="query")
	public String queryAll(ModelMap modelMap,GcglPage page){
		
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<GdzcGongcheng> list = service.queryAll(page);
		PageInfo<GdzcGongcheng> pageInfo = new PageInfo<GdzcGongcheng>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page",page);
		
		return "jsp/information/gcgl/query_gcgl";
	}
	@RequestMapping(value="page")
	public String page(ModelMap modelMap,String id){
		List<CodeGongchengleixing> gclxList = gclxService.queryAll();
		modelMap.put("gclxList", gclxList);
		List<SysPerson> personList = personService.queryPersonList();
		modelMap.put("personList", personList);
		List<SysDept> deptList = deptService.selectAll();
		modelMap.put("deptList", deptList);
		if (id!=null && !id.equals("")) {
			GdzcGongcheng gcgl = service.queryById(id);
			modelMap.put("gcgl", gcgl);
		}
		return "jsp/information/gcgl/page_gcgl";
	}
	@RequestMapping(value="save")
	public String save(GdzcGongcheng gcgl){
		service.save(gcgl);
		return "redirect:query.action";
	}
	@RequestMapping(value="delete")
	public String delete(String ids[]){
		service.delete(ids);
		return "redirect:query.action";
	}
	
}
