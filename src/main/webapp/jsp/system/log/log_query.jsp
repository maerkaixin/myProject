<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询日志</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		<label class="control-label label-default col-xs-12 " style="margin-bottom: 30px;">
			<h4>当前位置：系统设置 － 系统维护</h4>
		</label>
		<div class="container">
			<hr />
			<form class="form-horizontal text-center" action="<%=ctx%>/login/queryLog.action" method="post">
				<div class="container">
					<div class="input-group col-sm-6 col-sm-offset-3">
					  <input type="text" name="name" value="${ page.name}" class="form-control" placeHolder="输入操作人姓名">
					  <div class="input-group-btn"><button type="submit" class="btn btn-primary">搜索</button></div>
					</div>
				</div>
			</form>
		</div>
		<form action="" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>日志信息</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td>操作人姓名</td>
						<td>操作时间</td>
						<td>操作模块</td>
						<td>操作类型</td>
						<td>操作描述</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list }" var="t" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${t.operPersonname}</td>
						<td>${t.operTime}</td>
						<td>${t.operModel}</td>
						<td>
							<c:choose>
								<c:when test="${t.operType==1}">添加</c:when>
								<c:when test="${t.operType==2}">修改</c:when>
								<c:when test="${t.operType==3}">删除</c:when>
							</c:choose>
						</td>
						<td>${t.operDesc}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
			<page:page pageName="pageInfo" uri="login/queryLog.action"></page:page>
	</body>
	
</html>
<script type="text/javascript">
	
</script>