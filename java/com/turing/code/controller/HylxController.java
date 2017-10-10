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
import com.turing.code.entity.CodeHangyeleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IHylxService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("hylx")
@Scope("prototype")
public class HylxController {
	
	@Autowired
	private IHylxService hylxService;
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
		List<CodeHangyeleixing> list = hylxService.queryAll();
		model.put("list", list);
		return "jsp/code/hylx/query_hylx";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/hylx/add_hylx";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeHangyeleixing xydj = hylxService.queryById(id);
		mp.put("xydj", xydj);
		return "jsp/code/hylx/edit_hylx";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("行业类型", 3, "删除一些数据");
		hylxService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeHangyeleixing hylx){
		logUtils.write("行业类型", 1, "添加一个数据");
		hylx.setChlId(UUID.randomUUID().toString());
		hylxService.save(hylx);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeHangyeleixing hylx){
		logUtils.write("行业类型", 2, "修改一条数据");
		hylxService.edit(hylx);
		return "redirect:query.action";
	}
}
