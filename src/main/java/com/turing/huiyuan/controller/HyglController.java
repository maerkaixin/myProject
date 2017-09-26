package com.turing.huiyuan.controller;

import java.util.Date;
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
import com.turing.code.entity.CodeRuhuifangshi;
import com.turing.code.service.IRhfsService;
import com.turing.huiyuan.entity.HyglHuiyuan;
import com.turing.huiyuan.mapper.HyglHuiyuanMapper;
import com.turing.huiyuan.page.HyglHuiyuanPage;
import com.turing.huiyuan.service.IHyglService;

@Controller
@RequestMapping(value="huiyuan")
@Scope("prototype")
@SessionAttributes(types=HyglHuiyuanPage.class)
public class HyglController {
	@Autowired
	private IHyglService service;
	@Autowired
	private IRhfsService rhfsService;
	@RequestMapping(value="query")
	public String queryAll(ModelMap modelMap,HyglHuiyuanPage page){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<HyglHuiyuan> list = service.queryAll(page);
		modelMap.put("pageInfo", new PageInfo<HyglHuiyuan>(list));
		modelMap.put("page",page);
		System.out.println("page"+page);
		List<CodeRuhuifangshi> rhfsList = rhfsService.queryAll();
		modelMap.put("rhfsList",rhfsList);
		return "jsp/huiyuan/query_huiyuan";
	}
	
	@RequestMapping(value="srtxQuery")
	public String srtxQuery(ModelMap modelMap,HyglHuiyuanPage srtxPage){
		PageHelper.startPage(srtxPage.getPageNum(), srtxPage.getPageSize());
		List<HyglHuiyuan> list = service.srtxQuery(srtxPage);
		modelMap.put("srtxPageInfo", new PageInfo<HyglHuiyuan>(list));
		modelMap.put("srtxPage",srtxPage);
		System.out.println("srtxPage"+srtxPage);
		return "jsp/huiyuan/srtx_huiyuan";
	}
	
	@RequestMapping(value="addpage")
	public String addpage(ModelMap modelMap){
		List<CodeRuhuifangshi> rhfsList = rhfsService.queryAll();
		modelMap.put("rhfsList", rhfsList);
		return "jsp/huiyuan/add_huiyuan";
	}
	
	@RequestMapping(value="editpage")
	public String editpage(ModelMap modelMap,String id){
		HyglHuiyuan  hy = service.selectByPrimaryKey(id);
		List<CodeRuhuifangshi> rhfsList = rhfsService.queryAll();
		modelMap.put("rhfsList", rhfsList);
		modelMap.put("hy", hy);
		return "jsp/huiyuan/edit_huiyuan";
	}
	@RequestMapping("save")
	public String save(HyglHuiyuan hy){
		hy.setHyId(UUID.randomUUID().toString());
		hy.setHyInDate(new Date());
		service.insert(hy);
		return "redirect:query.action";
	}
	@RequestMapping("edit")
	public String edit(HyglHuiyuan hy){
		service.updateByPrimaryKey(hy);
		return "redirect:query.action";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		service.deleteByPrimaryKey(ids);
		return "redirect:query.action";
	}

}
