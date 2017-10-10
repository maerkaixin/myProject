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
import com.turing.card.entity.CardTuika;
import com.turing.card.page.TuikaPage;
import com.turing.card.service.ITuikaService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "tk")
@SessionAttributes(types = TuikaPage.class)
public class TuikaController {
	@Autowired
	private ITuikaService service;

	@RequestMapping(value = "query")
	public String query( ModelMap modelMap,TuikaPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CardTuika> list = service.queryAll(page);
		PageInfo<CardTuika> pageInfo = new PageInfo<CardTuika>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/tuika/tuika_query";
	}
	@RequestMapping(value="addpage")
	public String addpage(){
		return "jsp/card/tuika/tuika_add";
	}
	@RequestMapping(value="addsave")
	public String addsave(CardTuika tk){
		service.add(tk);
		return "redirect:query.action";
	}
	
	@RequestMapping(value="delete")
	public String delete(String[]  ids){
		service.delete(ids);
		
		return "redirect:query.action";
	}
	
	@RequestMapping(value="editpage")
	public String editpage(String id,ModelMap modelMap){
		CardTuika tk = service.selectById(id);
		modelMap.put("tk", tk);
		return "jsp/card/tuika/tuika_edit";
	}
	@RequestMapping(value="editsave")
	public String editsave(CardTuika tk){
		service.editsave(tk);
		return "redirect:query.action";
	}
	
}
