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
import com.turing.code.entity.CodeShangpinleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ISplxService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("splx")
@Scope("prototype")
public class SplxController {
	
	@Autowired
	private ISplxService splxService;
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
		List<CodeShangpinleixing> list = splxService.queryAll();
		model.put("list", list);
		return "jsp/code/xydj/query_xydj";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/xydj/add_xydj";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeShangpinleixing splx = splxService.queryById(id);
		mp.put("splx", splx);
		return "jsp/code/splx/edit_splx";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("商品类型", 3, "删除一些数据");
		splxService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeShangpinleixing splx){
		logUtils.write("商品类型", 1, "添加一个数据");
		splx.setCslId(UUID.randomUUID().toString());
		splxService.save(splx);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeShangpinleixing splx){
		logUtils.write("商品类型", 2, "修改一条数据");
		splxService.edit(splx);
		return "redirect:query.action";
	}
}
