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
import com.turing.code.entity.CodeFuwufangshi;
import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.page.XydjPage;
import com.turing.code.service.IFwfsService;
import com.turing.code.service.IXydjService;
import com.turing.framework.util.OperLogUtils;
import com.turing.system.entity.OperLog;

@Controller
@RequestMapping("fwfs")
@Scope("prototype")
public class FwfsController {
	
	@Autowired
	private IFwfsService fwfsService;
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
		List<CodeFuwufangshi> list = fwfsService.queryAll();
		model.put("list", list);
		return "jsp/code/fwfs/query_fwfs";
	}
	
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/fwfs/add_fwfs";
	}
	
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeFuwufangshi fwfs = fwfsService.queryById(id);
		mp.put("fwfs", fwfs);
		return "jsp/code/fwfs/edit_fwfs";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		logUtils.write("服务方式", 3, "删除一些数据");
		fwfsService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(CodeFuwufangshi fwfs){
		logUtils.write("服务方式", 1, "添加一个数据");
		fwfs.setCffId(UUID.randomUUID().toString());
		fwfsService.save(fwfs);
		return "redirect:query.action";
	}
	
	@RequestMapping("edit")
	public String edit(CodeFuwufangshi fwfs){
		logUtils.write("服务方式", 2, "修改一条数据");
		fwfsService.edit(fwfs);
		return "redirect:query.action";
	}
}
