<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询宣传方式</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		
		<div class="container">
			<hr />
			<form class="form-horizontal text-center" action="<%=ctx%>/xcfs/query.action" method="post">
				<div class="container ">
					<div class="form-group">
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
						<div class=" col-lg-6 col-md-6 col-sm-8 col-xs-8" >
							<div class="col-md-6 col-sm-6">
								<input class="form-control btn-primary" type="button" onclick="addpage()" value="增加" />
							</div>
							<div class="col-md-6 col-sm-6">
								<input class="form-control btn-primary" type="button" onclick="del()" value="删除" />
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
					</div>
				</div>
			</form>
		</div>
		<form action="<%=ctx %>/xcfs/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>宣传方式信息</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>宣传方式名称</td>
						<td>宣传方式价格</td>
						<td>联系人</td>
						<td>联系电话</td>
						<td>效果评定</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach  items="${pageInfo.list }" var="xcfs" varStatus="i">
						<tr>
							<td>${i.count+page.start }</td>
							<td><input type="checkbox" name="ids" value="${xcfs.xcfsId}"></td>
							<td>${xcfs.xcfsName}</td>
							<td>${xcfs.xcfsJiage}</td>
							<td>${xcfs.xcfsLxr}</td>
							<td>${xcfs.xcfsPhone}</td>
							<td>${xcfs.xcfsXiaoguo}</td>
							<td>
								<a href="javascript:editpage('${xcfs.xcfsId }')">修改</a>&nbsp;&nbsp;
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div align="center">
			<page:page pageName="pageInfo" uri="/xcfs/query.action"></page:page>
		</div>
	</body>
	
</html>
<script type="text/javascript">
	function addpage(){
		window.location.href = "<%=ctx%>/xcfs/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/xcfs/page.action?id="+id;
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