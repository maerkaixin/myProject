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
import com.turing.code.entity.CodeWeixiuleixing;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IWxlxService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("wxlx")
@Scope("prototype")
public class WxlxController {
	
	@Autowired
	private IWxlxService wxlxService;
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
		List<CodeWeixiuleixing> list = wxlxService.queryAll();
		model.put("list", list);
		return "jsp/code/wxlx/query_wxlx";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/wxlx/add_wxlx";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeWeixiuleixing wxlx = wxlxService.queryById(id);
		mp.put("wxlx", wxlx);
		return "jsp/code/wxlx/edit_wxlx";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("维修类型", 3, "删除一些数据");
		wxlxService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeWeixiuleixing wxlx){
		logUtils.write("维修类型", 1, "添加一个数据");
		wxlx.setCwlId(UUID.randomUUID().toString());
		wxlxService.save(wxlx);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeWeixiuleixing wxlx){
		logUtils.write("维修类型", 2, "修改一条数据");
		wxlxService.edit(wxlx);
		return "redirect:query.action";
	}
}
