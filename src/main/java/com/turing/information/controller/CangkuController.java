package com.turing.information.controller;

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
import com.turing.information.entity.KcglCangku;
import com.turing.information.page.CangkuPage;
import com.turing.information.service.ICangkuService;
import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysPerson;
import com.turing.system.service.IDeptService;
import com.turing.system.service.IPersonService;

@Controller
@RequestMapping(value="ck")
@Scope(value="prototype")
@SessionAttributes(types=CangkuPage.class)
public class CangkuController {
	@Autowired
	private ICangkuService service;
	@Autowired
	private IDeptService deptService;
	@Autowired
	private IPersonService perService;
	
	@RequestMapping(value="query")
	public String query(ModelMap modelMap,CangkuPage page){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		
		List<KcglCangku> list = service.queryAll(page);
		PageInfo<KcglCangku> pageInfo = new PageInfo<KcglCangku>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		List<SysDept> deptList = deptService.selectAll();
		modelMap.put("deptList", deptList);
		return "jsp/information/cangku/query_kcgl";
	}
	@RequestMapping(value="page")
	public String page(ModelMap modelMap,String id){
		KcglCangku ck = service.queryById(id);
		modelMap.put("ck", ck);
		List<SysDept> deptList = deptService.selectAll();
		modelMap.put("deptList", deptList);
		if (id!=null && !id.equals("")) {
			List<SysPerson> perList = perService.queryPersonByDeptId(ck.getDeptId());
			modelMap.put("perList", perList);
		}
		
		return "jsp/information/cangku/page_kcgl";
	}
	
	@RequestMapping(value="save")
	public String save(KcglCangku ck){
		 service.save(ck);
		return "redirect:query.action";
	}
	
	@RequestMapping(value="delete")
	public String delete(String[] ids){
		service.delete(ids);
		return "redirect:query.action";
	}
	
	
	
}
