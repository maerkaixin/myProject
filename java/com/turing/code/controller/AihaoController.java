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
import com.turing.code.entity.CodeAihao;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IAIhaoService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("aihao")
@Scope("prototype")
public class AihaoController {
	
	@Autowired
	private IAIhaoService aihaoService;
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
		List<CodeAihao> list = aihaoService.queryAll();
		model.put("list", list);
		return "jsp/code/aihao/query_aihao";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/aihao/add_aihao";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeAihao aihao = aihaoService.queryById(id);
		System.out.println(id);
		mp.put("aihao", aihao);
		return "jsp/code/aihao/edit_aihao";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("爱好类型", 3, "删除一些数据");
		aihaoService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeAihao aihao){
		logUtils.write("爱好类型", 1, "添加一个数据");
		aihao.setCahId(UUID.randomUUID().toString());
		aihaoService.save(aihao);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeAihao aihao){
		logUtils.write("爱好类型", 2, "修改一条数据");
		aihaoService.edit(aihao);
		return "redirect:query.action";
	}
}
