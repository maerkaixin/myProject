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
import com.turing.code.entity.CodeShangpindanwei;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ISpdwService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("spdw")
@Scope("prototype")
public class SpdwController {
	
	@Autowired
	private ISpdwService spdwService;
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
		List<CodeShangpindanwei> list = spdwService.queryAll();
		model.put("list", list);
		return "jsp/code/spdw/query_spdw";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/spdw/add_spdw";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeShangpindanwei xydj = spdwService.queryById(id);
		mp.put("xydj", xydj);
		return "jsp/code/spdw/edit_spdw";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("商品单位", 3, "删除一些数据");
		spdwService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeShangpindanwei spdw){
		logUtils.write("商品单位", 1, "添加一个数据");
		spdw.setCsdId(UUID.randomUUID().toString());
		spdwService.save(spdw);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeShangpindanwei spdw){
		logUtils.write("商品单位", 2, "修改一条数据");
		spdwService.edit(spdw);
		return "redirect:query.action";
	}
}
