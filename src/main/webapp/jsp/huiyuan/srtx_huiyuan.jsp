﻿<%@page import="com.turing.huiyuan.page.HyglHuiyuanPage"%> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询会员</title>
	</head>
	<body style="background:linear-gradient(white、#ebebeb,white);">
		
		<div class="container">
			<hr />
			<form name="queryForm" class="form-horizontal text-center" action="<%=ctx %>/huiyuan/srtxQuery.action?pageNo=1" method="post">
				<div class="container">
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyName" value="${srtxPage.hyName }" placeholder="请输入会员名称" />
						</div>
						<label class="control-label col-sm-2 col-md-2">会员代号:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyNo" value="${srtxPage.hyNo }" placeholder="请输入会员代号" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员电话:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyPhone" value="${srtxPage.hyPhone }" placeholder="请输入会员电话" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
						<div class=" col-lg-6 col-md-6 col-sm-8 col-xs-8" >
							<div class="col-md-3 col-sm-3">
								<input class="form-control btn-primary" type="submit" value="查询" />
							</div>
							<div class="col-md-3 col-sm-3">
								<input class="form-control btn-primary" type="button" onclick="cleanUp()" value="清空" />
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
					</div>
				</div>
			</form>
		</div>
		<form action="<%=ctx %>/huiyuan/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>会员信息列表</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td>会员名称</td>
						<td>会员代号</td>
						<td>会员生日</td>
						<td>会员电话</td>
						<td>会员email</td>
						<td>天数</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${srtxPageInfo.list }" var="hy" varStatus="i">
					<tr>
						<td>${i.count+srtxPage.start}</td>
						<td>${hy.hyName}</td>
						<td>${hy.hyNo}</td>
						<td><fmt:formatDate value="${hy.hyBirth}"/></td>
						<td>${hy.hyPhone}</td>
						<td>${hy.hyEmail}</td>
						<td>${hy.tianshu==0?"今天":hy.tianshu}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div align="center">
			<page:page pageName="srtxPageInfo" uri="/huiyuan/srtxQuery.action"></page:page>
		</div>
	</body>
</html>
<script type="text/javascript">
	$('.form_date').datetimepicker({
		language:  'zh-CN',
		format:'yyyy-mm-dd',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
	});
	
	
	function addpage(){
		window.location.href = "<%=ctx%>/huiyuan/addpage.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/huiyuan/editpage.action?id="+id;
	}
	
	function del(){
		$("form[name='delForm']").submit();
	}
	
	function selectAll(){
		var inpts = $("input[name='ids']");
		for(var i=0;i<inpts.length;i++){
			if(inpts[i].checked!=true){
				inpts[i].checked=true;
			}else{
				inpts[i].checked=false;
			}
		}
	}
	
	function clearTime(span){
		var div = span.parentNode.parentNode;
		div.children[0].value="";
	}
	
	function cleanUp(){
		$("form[name='queryForm'] :text").val("");
		$("form[name='queryForm'] input[type='hidden']").val("");
		$("form:first :checkbox").attr("checked",false);
		$("form[name='queryForm'] select").val("");
	}
	
	
</script>