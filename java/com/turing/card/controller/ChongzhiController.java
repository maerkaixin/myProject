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
import com.turing.card.entity.CardChongzhi;
import com.turing.card.entity.CardHuiyuanbanka;
import com.turing.card.page.ChongzhiPage;
import com.turing.card.service.IChongzhiService;
import com.turing.card.service.IHybkService;

@Controller
@Scope(value="prototype")
@RequestMapping(value="cz")
@SessionAttributes(types=ChongzhiPage.class)
public class ChongzhiController {
	@Autowired 
	private IChongzhiService service;
	@Autowired 
	private IHybkService hybcService;	
	
	@RequestMapping(value="query")
	public String query(ModelMap modelMap,ChongzhiPage page){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		
		List<CardChongzhi> list= service.queryAll(page);
		PageInfo<CardChongzhi> pageInfo = new PageInfo<CardChongzhi>(list);
//		page.setStart(page.getPageSize()*(page.getPageNum()-1));
		modelMap.put("pageInfo", pageInfo);
		modelMap.put("page", page);
		return "jsp/card/chongzhi/chongzhi_query";
	}
	@RequestMapping(value="addpage")
	public String addpage(){
		
		return "jsp/card/chongzhi/chongzhi_add";
	}
	@RequestMapping(value="addsave")
	public String addsave(CardChongzhi cz){
		service.addsave(cz);
		return "redirect:query.action";
	}
	@RequestMapping(value="editpage")
	public String editpage(String id,ModelMap modelMap){
		CardChongzhi cz= service.selectById(id);
		modelMap.put("cz", cz);
		CardHuiyuanbanka hybk = hybcService.selectOne(cz.getHcId());
		modelMap.put("hybk", hybk);
		return "jsp/card/chongzhi/chongzhi_edit";
	}
	
	@RequestMapping(value="delete")
	public String delete(String[] ids){
		service.delete(ids);
		
		
		return "redirect:query.action";
	}
	@RequestMapping(value="editsave")
	public String editsave(CardChongzhi cz){
		service.editsave(cz);
		return "redirect:query.action";
	}
	
}
