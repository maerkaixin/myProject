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
import com.turing.code.entity.CodeTousufangshi;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.ITsfsService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("tsfs")
@Scope("prototype")
public class TsfsController {
	
	@Autowired
	private ITsfsService tsfsService;
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
		List<CodeTousufangshi> list = tsfsService.queryAll();
		model.put("list", list);
		return "jsp/code/tsfs/query_tsfs";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/tsfs/add_tsfs";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeTousufangshi tsfs = tsfsService.queryById(id);
		mp.put("tsfs", tsfs);
		return "jsp/code/tsfs/edit_tsfs";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("投诉方式", 3, "删除一些数据");
		tsfsService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeTousufangshi tsfs){
		logUtils.write("投诉方式", 1, "添加一个数据");
		tsfs.setCtfId(UUID.randomUUID().toString());
		tsfsService.save(tsfs);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeTousufangshi tsfs){
		logUtils.write("投诉方式", 2, "修改一条数据");
		tsfsService.edit(tsfs);
		return "redirect:query.action";
	}
}
