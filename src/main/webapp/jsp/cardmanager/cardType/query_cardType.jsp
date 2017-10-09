<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询会员卡类型</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		<label class="control-label label-default col-xs-12 " style="margin-bottom: 30px;">
			<h4>当前位置：会员卡类型－ 查询会员卡类型</h4>
		</label>
		<div class="container">
			<form method="post" action="<%=ctx %>/cardType/query.action" name="searchForm">
				<%-- 此处放条件查询 --%>
			</form>
		</div>
		<form action="<%=ctx %>/cardType/delete.action" method="post" name="delForm">
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
						<strong>会员卡类型信息</strong>
					</div>
				</caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>会员卡名称</td>
						<td>会员卡代号</td>
						<td>会员卡价格</td>
						<td>预存金额</td>
						<td>会员卡说明</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list }" var="cardType" varStatus="i">
					<tr>
						<td>${i.count+page.start}</td>
						<td><input type="checkbox" name="ids" value="${cardType.cardId}"></td>
						<td>${cardType.cardName}</td>
						<td>${cardType.cardNo}</td>
						<td>${cardType.cardJiage}</td>
						<td>${cardType.cardYucunjine}</td>
						<td>${cardType.cardInfo}</td>
						<td>
							<button onclick="editpage('${cardType.cardId}')" type="button" class="btn-sm btn-primary">修改</button>
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
			<page:page pageName="pageInfo" uri="/cardType/query.action"></page:page>
		</div>
		 
		 <%-- 分页end --%>
	</body>
	
</html>
<script type="text/javascript">
	function addpage(){
		window.location.href = "<%=ctx%>/cardType/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/cardType/page.action?id="+id;
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