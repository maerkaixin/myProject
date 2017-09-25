<%@page import="com.turing.huiyuan.page.HyglHuiyuanPage"%> 
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
			<form name="queryForm" class="form-horizontal text-center" action="<%=ctx %>/hy/query.action?pageNo=1" method="post">
				<div class="container">
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyName" value="${page.hyName }" placeholder="请输入会员名称" />
						</div>
						<label class="control-label col-sm-2 col-md-2">会员代号:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyNo" value="${page.hyNo }" placeholder="请输入会员代号" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员电话:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyPhone" value="${page.hyPhone }" placeholder="请输入会员电话" />
						</div>
						<label class="control-label col-sm-2 col-md-2">入会方式:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="crfId">
								<option value="">===请选择===</option>
								<c:forEach items="${rhfsList}" var="rhfs">
								<option value="${rhfs.crfId}"${rhfs.crfId==page.crfId?"selected":"" }>${rhfs.crfName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">入会时间:</label>
						<div class="col-md-7 col-sm-7">
							<div class="input-group">
								<div class="input-group date form_date" data-date-format="yyyy-mm-dd" >
				                    <input class="form-control" id="showTime" name="hyInDate" value="<fmt:formatDate value="${page.hyInDate }"/>" type="text"  readonly>
				                    <span class="input-group-addon"><span  onclick="clearTime(this)" class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								<div class="input-group-addon">
									至
								</div>
								<div class="input-group date form_date"  data-date-format="yyyy-mm-dd">
				                    <input class="form-control" name="hyDateTo" id="showTime1" value="<fmt:formatDate value="${page.hyDateTo }"/>" type="text" readonly>
				                    <span class="input-group-addon"><span  onclick="clearTime(this)" class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
							</div>
						</div>
					</div>
					<%
						HyglHuiyuanPage page1=(HyglHuiyuanPage)request.getAttribute("page");
						List xxList=null; 
						if(xxList==null){
							xxList=new ArrayList();
						} 
					%>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员血型:</label>
						<div class="col-md-8 col-sm-8 text-left" >
							<label class="checkbox-inline">
								<input type="checkbox"  name="hyXuexing"  value="A" <%=xxList.contains("A")?"checked":"" %>>A型
							</label>
							<label class="checkbox-inline">
								<input type="checkbox"  name="hyXuexing" value="B" <%=xxList.contains("B")?"checked":"" %>>B型
							</label>
							<label class="checkbox-inline">
								<input type="checkbox"  name="hyXuexing"  value="O" <%=xxList.contains("O")?"checked":"" %>>O型
							</label>
							<label class="checkbox-inline">
								<input type="checkbox"  name="hyXuexing"  value="AB" <%=xxList.contains("AB")?"checked":"" %>>AB型
							</label>
							<label class="checkbox-inline">
								<input type="checkbox"  name="hyXuexing"  value="Other" <%=xxList.contains("Other")?"checked":"" %>>其他
							</label>
							<input type="hidden" name="hyXuexing">
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
							<div class="col-md-3 col-sm-3">
								<input class="form-control btn-primary" type="button" onclick="addpage()" value="增加" />
							</div>
							<div class="col-md-3 col-sm-3">
								<input class="form-control btn-primary" type="button" onclick="del()" value="删除" />
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
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>会员名称</td>
						<td>会员代号</td>
						<td>入会时间</td>
						<td>性别</td>
						<td>会员电话</td>
						<td>入会方式</td>
						<td>血型</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list }" var="hy" varStatus="i">
					<tr>
						<td>${i.count+page.start}</td>
						<td><input type="checkbox" name="ids" value="${hy.hyId}"></td>
						<td>${hy.hyName}</td>
						<td>${hy.hyNo}</td>
						<td><fmt:formatDate value="${hy.hyInDate}"/></td>
						<td>
						<c:if test="${hy.hySex=='1'}">男</c:if>
						<c:if test="${hy.hySex=='0'}">女</c:if>
						</td>
						<td>${hy.hyPhone}</td>
						<td>${hy.crfName}</td>
						<td>${hy.hyXuexing}</td>
						<td>
							<a href="javascript:editpage('${hy.hyId }')">修改</a>&nbsp;&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div align="center">
			<page:page pageName="pageInfo" uri="/huiyuan/query.action"></page:page>
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