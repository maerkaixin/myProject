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
import com.turing.code.entity.CodeBank;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IBankService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("bank")
@Scope("prototype")
public class BankController {
	
	@Autowired
	private IBankService bankService;
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
		List<CodeBank> list = bankService.queryAll();
		model.put("list", list);
		return "jsp/code/bank/query_bank";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/bank/add_bank";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeBank bank = bankService.queryById(id);
		mp.put("bank", bank);
		return "jsp/code/bank/edit_bank";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("银行信息", 3, "删除一些数据");
		bankService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeBank bank){
		logUtils.write("银行信息", 1, "添加一个数据");
		bank.setCbId(UUID.randomUUID().toString());
		bankService.save(bank);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeBank bank){
		logUtils.write("银行信息", 2, "修改一条数据");
		bankService.edit(bank);
		return "redirect:query.action";
	}
}
