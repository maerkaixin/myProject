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
import com.turing.code.entity.CodeWeixianpingji;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IWxpjService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("wxpj")
@Scope("prototype")
public class WxpjController {
	
	@Autowired
	private IWxpjService wxpjService;
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
		List<CodeWeixianpingji> list = wxpjService.queryAll();
		model.put("list", list);
		return "jsp/code/wxpj/query_wxpj";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/wxpj/add_wxpj";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeWeixianpingji xydj = wxpjService.queryById(id);
		mp.put("xydj", xydj);
		return "jsp/code/wxpj/edit_wxpj";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("危险评级", 3, "删除一些数据");
		wxpjService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeWeixianpingji wxpj){
		logUtils.write("危险评级", 1, "添加一个数据");
		wxpj.setCwpId(UUID.randomUUID().toString());
		wxpjService.save(wxpj);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeWeixianpingji wxpj){
		logUtils.write("危险评级", 2, "修改一条数据");
		wxpjService.edit(wxpj);
		return "redirect:query.action";
	}
}
