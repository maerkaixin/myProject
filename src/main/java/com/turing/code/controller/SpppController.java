package com.turing.code.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.code.entity.CodeShangpinpinpai;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ISpppService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("sppp")
@Scope("prototype")
public class SpppController {
	
	@Autowired
	private ISpppService spppService;
	@Autowired
	private OperLogUtils logUtils;
	/**
	 * 查询信誉等级信息
	 * @param model	模型数据
	 * @param pageNum	当前页
	 * @param pageSize  每页多少条
	 * @return 页面
	 */
	@RequestMapping("query")
	public String query(ModelMap model){
		List<CodeShangpinpinpai> list = spppService.queryAll();
		model.put("list", list);
		return "jsp/code/sppp/query_sppp";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/sppp/add_sppp";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeShangpinpinpai xydj = spppService.queryById(id);
		mp.put("xydj", xydj);
		return "jsp/code/sppp/edit_sppp";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("商品品牌", 3, "删除一些数据");
		spppService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeShangpinpinpai sppp){
		logUtils.write("商品品牌", 1, "添加一个数据");
		sppp.setCspId(UUID.randomUUID().toString());
		spppService.save(sppp);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeShangpinpinpai sppp){
		logUtils.write("商品品牌", 2, "修改一条数据");
		spppService.edit(sppp);
		return "redirect:query.action";
	}
}
