package com.turing.information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.information.page.CwgPage;
import com.turing.information.service.ICwgService;

@Controller
@Scope(value = "proptotype")
@RequestMapping(value = "cwg")
public class CwgController {
	@Autowired
	private ICwgService service;
	
	public String query(CwgPage page, ModelMap mm){
		//接
		//掉
		
		
		//存
		
		
		//转
		return "jsp/information/cwg/query_cwg";
	}
	

}
