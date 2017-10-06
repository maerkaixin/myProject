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
import com.turing.cardmanager.CardPage;
import com.turing.cardmanager.entity.CardType;
import com.turing.cardmanager.service.ICardService;

@Controller
@RequestMapping(value = "cardType")
@Scope(value = "prototype")
@SessionAttributes(types = CardPage.class)
public class CardController {
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
	
	

}
