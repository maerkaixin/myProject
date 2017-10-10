package com.turing.huiyuan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
	@RequestMapping(value="getHuiyuan")
	public String getHuiyuan(ModelMap modelMap,HyglHuiyuanPage page){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		
		page.setStart(page.getPageSize()*(page.getPageNum()-1));
		
		List<HyglHuiyuan> list = service.queryAll(page);
		modelMap.put("pageInfo", new PageInfo<HyglHuiyuan>(list));
		modelMap.put("page",page);
		System.out.println("page"+page);
		List<CodeRuhuifangshi> rhfsList = rhfsService.queryAll();
		modelMap.put("rhfsList",rhfsList);
		return "jsp/card/hybk/query_huiyuan";
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
	public String save(HyglHuiyuan hy,@RequestParam("pic")CommonsMultipartFile picFile,HttpServletRequest request){
		hy.setHyId(UUID.randomUUID().toString());
		hy.setHyInDate(new Date());
		service.insert(hy,picFile,request);
		return "redirect:query.action";
	}
	@RequestMapping("edit")
	public String edit(HyglHuiyuan hy,@RequestParam("pic")CommonsMultipartFile picFile,HttpServletRequest request){
		service.updateByPrimaryKey(hy,picFile,request);
		return "redirect:query.action";
	}
	/**
	 * 会员删除功能
	 * @param ids 需要删除的会员ids数组
	 * @param request 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(String[] ids,HttpServletRequest request,ModelMap modelMap){
		List<String> listDel = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		for (String id : ids) {
			String hyName = service.yanzhengHuiyuan(id);
			if (StringUtils.isNotBlank(hyName)) {
				sb.append("会员"+hyName+"已办理会员卡,请先删除其办卡信息再删除会员<br>");
			}else{
				listDel.add(id);
			}
		}
		if (!listDel.isEmpty()) {
			service.deleteByPrimaryKey(listDel, request);
		}
		if (sb.equals("")) {
			return "redirect:query.action";
		}
		sb.append("<a href='"+request.getContextPath()+"/huiyuan/query.action'>返回</a>");
			modelMap.put("message", sb.toString());
			return "error/message";
	}

}
