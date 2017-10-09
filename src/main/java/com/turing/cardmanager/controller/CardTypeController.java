package com.turing.cardmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.cardmanager.entity.CardType;
import com.turing.cardmanager.page.CardPage;
import com.turing.cardmanager.service.ICardService;

@Controller
@RequestMapping(value = "cardType")
@Scope(value = "prototype")
@SessionAttributes(types = CardPage.class)
public class CardTypeController {
	@Autowired
	private ICardService service;

	@RequestMapping(value = "query")
	public String query(ModelMap modelMap, CardPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		 List<CardType> list = service.queryAll(page);
		 PageInfo<CardType> pageInfo = new PageInfo<CardType>(list);
		 modelMap.put("pageInfo", pageInfo);
		 modelMap.put("page", page);
		return "jsp/cardmanager/cardType/query_cardType";
	}
	@RequestMapping(value = "getCardType")
	public String getCardType(ModelMap modelMap, CardPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CardType> list = service.queryAll(page);
		PageInfo<CardType> pageInfo = new PageInfo<CardType>(list);
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/hybk/query_cardType";
	}
	
	@RequestMapping(value="page")
	public String page(String id,ModelMap modelMap){
		CardType cardType = service.queryById(id);
		modelMap.put("cardType", cardType);
		return "jsp/cardmanager/cardType/page_cardType";
	}
	@RequestMapping(value="save")
	public String save(CardType cardTyp){
		service.save(cardTyp);
		return "redirect:query.action";
	}
	@RequestMapping(value="delete")
	public String delete(String[] ids){
		service.delete(ids);
		return "redirect:query.action";
	}
	

}
