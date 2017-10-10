package com.turing.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.page.HybkPage;
import com.turing.card.service.IHybkService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "hybk")
@SessionAttributes(types = HybkPage.class)
public class HybkController {
	@Autowired
	private IHybkService service;
	@RequestMapping(value="query")
	public String query(ModelMap modelMap,HybkPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CardHuiyuanbanka> list = service.queryAll(page);
		PageInfo<CardHuiyuanbanka> pageInfo = new PageInfo<CardHuiyuanbanka>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/hybk/query_hybk";
	}
	@RequestMapping(value="getHybk")
	public String getHybk(ModelMap modelMap,HybkPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CardHuiyuanbanka> list = service.getHybk(page);
		PageInfo<CardHuiyuanbanka> pageInfo = new PageInfo<CardHuiyuanbanka>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/chongzhi/query_hybk";
	}
	@RequestMapping(value="queryHybkForBk")
	public String queryHybkForBk(ModelMap modelMap,HybkPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CardHuiyuanbanka> list = service.getHybk(page);
		PageInfo<CardHuiyuanbanka> pageInfo = new PageInfo<CardHuiyuanbanka>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/buka/query_hybk";
	}
	@RequestMapping(value="queryHybkForTk")
	public String queryHybkForTk(ModelMap modelMap,HybkPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CardHuiyuanbanka> list = service.getHybk(page);
		PageInfo<CardHuiyuanbanka> pageInfo = new PageInfo<CardHuiyuanbanka>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/tuika/query_hybk";
	}
	
	
	@RequestMapping(value="page")
	public String page(String id,ModelMap modelMap){
		
		
		
		
		return "jsp/card/hybk/page_hybk";
	}
	@RequestMapping(value="save")
	public String save(CardHuiyuanbanka hybk){
		service.save(hybk);
		return "redirect:query.action";
	}
	
	@RequestMapping(value="editpage")
	public String editpage(String id,ModelMap modelMap){
		CardHuiyuanbanka hybk = service.selectOne(id);
		modelMap.put("hybk", hybk);
		return "jsp/card/hybk/editpage_hybk";
	}
	@RequestMapping(value="update")
	public String update(CardHuiyuanbanka hybc){
		service.update(hybc);
		return "redirect:query.action";
	}
	@RequestMapping(value="delete")
	public String delete(String ids[]){
		service.delete(ids);
		return "redirect:query.action";
	}
}
