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
import com.turing.code.entity.CodeEmail;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IEmailService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("email")
@Scope("prototype")
public class EmailController {
	
	@Autowired
	private IEmailService emailService;
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
		List<CodeEmail> list = emailService.queryAll();
		model.put("list", list);
		return "jsp/code/email/query_email";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/email/add_email";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeEmail email = emailService.queryById(id);
		mp.put("email", email);
		return "jsp/code/email/edit_email";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("邮箱信息", 3, "删除一些数据");
		emailService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeEmail email){
		logUtils.write("邮箱信息", 1, "添加一个数据");
		email.setCemId(UUID.randomUUID().toString());
		emailService.save(email);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeEmail email){
		logUtils.write("邮箱信息", 2, "修改一条数据");
		emailService.edit(email);
		return "redirect:query.action";
	}
}
