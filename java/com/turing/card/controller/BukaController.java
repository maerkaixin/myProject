package com.turing.card.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.card.entity.CardBuka;
import com.turing.card.page.BukaPage;
import com.turing.card.service.IBukaService;

@Controller
@Scope(value="prototype")
@RequestMapping(value="bk")
@SessionAttributes(types=BukaPage.class)
public class BukaController {
	@Autowired
	private IBukaService setvice ;
	
	@RequestMapping(value="query")
	public String query(ModelMap modelMap,BukaPage page){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CardBuka> list = setvice.queryAll(page);
		PageInfo<CardBuka> pageInfo = new PageInfo<CardBuka>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/buka/buka_query";
	}
	@RequestMapping(value="page")
	public String page(String id,ModelMap modelMap){
		if (StringUtils.isNotBlank(id)) {
			CardBuka bk = setvice.selectById(id);
			modelMap.put("bk", bk);
		}
		return "jsp/card/buka/buka_page";
	}
	@RequestMapping(value="save")
	public String save(CardBuka bk){
		setvice.save(bk);
		return "redirect:query.action";
	}
	@RequestMapping(value="delete")
	public String delete(String[] ids){
		setvice.delete(ids);
		return "redirect:query.action";
	}
	
}
