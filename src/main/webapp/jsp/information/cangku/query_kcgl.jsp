<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询仓库信息</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		
		<div class="container">
			<hr />
			<form class="form-horizontal text-center" action="<%=ctx%>/ck/query.action?" method="post">
				<div class="container ">
					<div class="form-group">
						<label class="control-label col-md-2 col-sm-2">仓库编号</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="ckNo" value="${page.ckNo}" placeholder="请输入仓库编号"/>
						</div>
						<label class="control-label col-sm-2 col-md-2">所属部门:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="deptId" >
								<option value="">===请选择===</option>
								<c:forEach items="${deptList}" var="dept">
								<option value="${dept.deptId}" ${dept.deptId==page.deptId?"selected":"" }>${dept.deptName}</option>
								</c:forEach>
							</select>
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
		<form action="<%=ctx %>/ck/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>仓库信息</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>仓库名称</td>
						<td>所属部门名称</td>
						<td>仓库编号</td>
						<td>库管人员</td>
						<td>地址说明</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list }" var="ck" varStatus="i">
					<tr>
						<td>${i.count+page.start}</td>
						<td><input type="checkbox" name="ids" value="${ck.ckId}"></td>
						<td>${ck.ckName}</td>
						<td>${ck.deptName}</td>
						<td>${ck.ckNo}</td>
						<td>${ck.ppName}</td>
						<td>${ck.ckAdds}</td>
						<td>
							<a href="javascript:editpage('${ck.ckId }')">修改</a>&nbsp;&nbsp;
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div align="center">
			<page:page pageName="pageInfo" uri="/ck/query.action"></page:page>
		</div>
	</body>
</html>
<script type="text/javascript">
	function addpage(){
		window.location.href = "<%=ctx%>/ck/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/ck/page.action?id="+id;
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