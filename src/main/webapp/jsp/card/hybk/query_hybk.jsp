<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询会员办卡</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		
		<div class="container">
			<hr />
			<form class="form-horizontal text-center" action="<%=ctx%>/hybk/query.action?pageNo=1" method="post">
				<div class="container ">
					<div class="form-group">
						<label class="control-label col-md-2 col-sm-2">会员名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyName" value="${page.hyName }" placeholder="请输入会员名称">
						</div>
						<label class="control-label col-md-2 col-sm-2">卡类型名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="cardName" value="${page.cardName }" placeholder="请输入卡类型名称">
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
								<input class="form-control btn-danger" type="button" onclick="del()" value="删除" />
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
					</div>
				</div>
			</form>
		</div>
		<form action="<%=ctx %>/hybk/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>会员办卡</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>会员名称</td>
						<td>卡类型名称</td>
						<td>卡号</td>
						<td>售卡时间</td>
						<td>余额</td>
						<td>卡状态</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list }" var="c" varStatus="i">
						<tr>
							<td>${i.count+page.start }</td>
							<td><input type="checkbox" name="ids" value="${c.hcId }"/></td>
							<td>${c.hyName }</td>
							<td>${c.cardName }</td>
							<td>${c.hcNo }</td>
							<td><fmt:formatDate value="${c.hcTime }" pattern="yyyy-MM-dd"/></td>
							<td>${c.hcNum }</td>
							<td>${c.hcState=='A'?"可用":"不可用" }</td>
							<td><a href="javascript:editpage('${c.hcId }')">修改</a></td>
						</tr>
						</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div class="container text-center">
			<page:page pageName="pageInfo" uri="hynk/query.action"></page:page>
		</div>
	</body>
	
</html>
<script type="text/javascript">
	function addpage(){
		window.location.href = "<%=ctx%>/hybk/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/hybk/editpage.action?id="+id;
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
	function cleanUp(){
		$("input[name='hyName']").val("");
		$("input[name='cardName']").val("");
	}
	
	
</script>