<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询维护管理</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		
		<div class="container">
			<hr />
			<form class="form-horizontal text-center" action="<%=ctx%>/wx/query.action?" method="post">
				<div class="container ">
					<div class="form-group">
						<label class="control-label col-md-2 col-sm-2">维修名称</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="wxjlName" value="${page.wxjlName}" placeholder="请输入维修名称"/>
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
		<form action="<%=ctx %>/wx/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>维护管理列表</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>维修类型名称</td>
						<td>报修人员</td>
						<td>报修部门</td>
						<td>维修名称</td>
						<td>报修时间</td>
						<td>维修时长</td>
						<td>维修状态</td>
						<td>维修描述</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list}" var="t" varStatus="i">
					<tr>
						<td>${i.count+page.start }</td>
						<td><input type="checkbox" name="ids" value="${t.wxjlId}"></td>
						<td>${t.cwlName}</td>
						<td>${t.ppName }</td>
						<td>${t.deptName }</td>
						<td>${t.wxjlName }</td>
						<td><fmt:formatDate value="${t.wxjlTime }"/></td>
						<td>${t.wxjlLen }</td>
						<td>${t.wxjlState }</td>
						<td>${t.wxjlInfo }</td>
						<td>
							<a href="javascript:editpage('${t.wxjlId}')">修改</a>&nbsp;&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div align="center">
			<page:page pageName="pageInfo" uri="/wx/query.action"></page:page>
		</div>
	</body>
</html>
<script type="text/javascript">
	function addpage(){
		window.location.href = "<%=ctx%>/wx/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/wx/page.action?id="+id;
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
	
	
</script>