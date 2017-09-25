<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询商品单位</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		<label class="control-label label-default col-xs-12 " style="margin-bottom: 30px;">
			<h4>当前位置：商品单位 － 查询商品单位</h4>
		</label>
		<div class="container">
			<form method="post" action="<%=ctx %>/spdw/query.action" name="searchForm">
				<%-- 此处放条件查询 --%>
			</form>
		</div>
		<form action="<%=ctx %>/spdw/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped table-condensed text-center" >
				<caption class="text-center" style="border: 0px solid;">
					<div class="col-sm-3" style="margin-left:-15px;">
						<div class="btn-group" style="display:block;">
							<button type="button" class="btn btn-primary" onclick="addpage()">添加<span class="glyphicon glyphicon-plus"></span></button>
							<button type="button" class="btn btn-danger" onclick="del()">删除<span class="glyphicon glyphicon-minus"></span></button>
						</div>
					</div>
					<div class="col-sm-5 text-center">
						<strong>商品单位信息</strong>
					</div>
				</caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>商品单位名称</td>
						<td>商品单位编码</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }" var="spdw" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td><input type="checkbox" name="ids" value="${spdw.csdId}"></td>
						<td>${spdw.csdName}</td>
						<td>${spdw.csdCode}</td>
						<td>
							<button onclick="editpage('${spdw.csdId}')" type="button" class="btn-sm btn-primary">修改</button>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<%-- 如果是分页查询，则打开此分页标签 --%>
		<%-- 分页start --%>
		
		<div class="container text-center" style="margin-top:-20px;">
			
		</div>
		 
		 <%-- 分页end --%>
	</body>
	
</html>
<script type="text/javascript">
	function addpage(){
		window.location.href = "<%=ctx%>/spdw/addpage.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/spdw/editpage.action?id="+id;
	}
	
	function del(){
		var delids = $("input[name='ids']:checked");
		if(delids.length==0){
			alert("请先选择要删除的记录！");
			return;
		}
		if(confirm("确定要删除吗？")){
			$("form[name='delForm']").submit();
		}
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