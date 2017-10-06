package com.turing.information.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.code.entity.CodeAdds;
import com.turing.code.entity.CodeShangpindanwei;
import com.turing.code.entity.CodeShangpinleixing;
import com.turing.code.entity.CodeShangpinpinpai;
import com.turing.code.service.IAddsService;
import com.turing.code.service.ISpdwService;
import com.turing.code.service.ISplxService;
import com.turing.code.service.ISpppService;
import com.turing.information.entity.KcglGoods;
import com.turing.information.mapper.KcglGoodsMapper;
import com.turing.information.page.GoodsPage;
import com.turing.information.service.IGoodsService;
import com.turing.khgl.entity.KhglQiye;
import com.turing.khgl.service.IQiyeService;

@Controller
@RequestMapping(value = "goods")
@Scope(value = "prototype")
@SessionAttributes(types = GoodsPage.class)
public class GoodsController {
	@Autowired
	private IGoodsService service;
	@Autowired
	private IQiyeService qiyeService;
	@Autowired
	private ISpppService spppService;
	@Autowired
	private ISplxService splxService;
	@Autowired
	private ISpdwService spdwService;
	@Autowired
	private IAddsService addsService;
	
	@RequestMapping(value = "query")
	public String query(ModelMap modelMap, GoodsPage page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<KcglGoods> list = service.queryAll(page);
		PageInfo<KcglGoods> pageInfo = new PageInfo<KcglGoods>(list);
		modelMap.put("pageInfo", pageInfo);
		List<KhglQiye> qiyeList = qiyeService.queryAllWithList();
		modelMap.put("qiyeList", qiyeList);
		List<CodeShangpinpinpai> spppList = spppService.queryAll();
		modelMap.put("spppList", spppList);
		List<CodeShangpinleixing> splxList = splxService.queryAll();
		modelMap.put("splxList", splxList);
		modelMap.put("page", page);
		return "jsp/information/kcgl/query_goods";

	}
	
	@RequestMapping(value = "page")
	public String page(ModelMap modelMap,String	id ) {
		List<KhglQiye> qiyeList = qiyeService.queryAllWithList();
		modelMap.put("qiyeList", qiyeList);
		List<CodeShangpinpinpai> spppList = spppService.queryAll();
		modelMap.put("spppList", spppList);
		List<CodeShangpinleixing> splxList = splxService.queryAll();
		modelMap.put("splxList", splxList);
		List<CodeShangpindanwei> spdwList= spdwService.queryAll();
		modelMap.put("spdwList", spdwList);
		List<CodeAdds> shengList = addsService.queryShengList();		
		modelMap.put("shengList", shengList);
		
		
		if (id!=null && !id.equals("")) {
			KcglGoods goods = service.queryById(id);
			modelMap.put("goods", goods);
			List<CodeAdds> shiList = addsService.queryByParentId(goods.getCaShengId());		
			modelMap.put("shiList", shiList);
		}
		return "jsp/information/kcgl/page_goods";
	}
	@RequestMapping(value="save")
	public String save(KcglGoods goods){
		service.save(goods);
		
		return "redirect:query.action";
	}
	
	@RequestMapping(value="delete")
	public String delete(String ids[]){
		service.delete(ids);
		
		return "redirect:query.action";
	}
	
	@RequestMapping(value="queryShiList")
	public void queryShiList(HttpServletResponse response,String id) throws IOException{
		List<CodeAdds>  list = addsService.queryByParentId(id);
		response.setCharacterEncoding("utf-8");
//		String json = JSONUtils.toJSONString(list);
		String json = JSONArray.toJSONString(list);
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
}
