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
import com.turing.card.entity.CardZhuanka;
import com.turing.card.page.ZhuankaPage;
import com.turing.card.service.IZhuankaService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "zk")
@SessionAttributes(types = ZhuankaPage.class)
public class ZhuankaController {

	@Autowired
	private IZhuankaService service;

	@RequestMapping(value = "query")
	public String query(ModelMap modelMap,ZhuankaPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		
		List<CardZhuanka> list = service.queryAll(page);
		PageInfo<CardZhuanka> pageInfo = new PageInfo<CardZhuanka>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/zhuanka/zk_query";
	}
	@RequestMapping(value="addpage")
	public String addpage(){
		return "jsp/card/zhuanka/zk_add";
	}
	@RequestMapping(value="addsave")
	public String addsave(CardZhuanka zk){
		service.addsave(zk);
		return "redirect:query.action";
	}

}
