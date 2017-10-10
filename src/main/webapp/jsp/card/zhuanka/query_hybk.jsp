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
			<form class="form-horizontal text-center" action="<%=ctx%>/hybk/getHybk.action?pageNo=1" method="post">
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
							<div class="col-md-6 col-sm-6">
								<input class="form-control btn-primary" type="submit" value="查询" />
							</div>
							<div class="col-md-6 col-sm-6">
								<input class="form-control btn-primary" type="button" onclick="cleanUp()" value="清空" />
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
								<td>
								<c:if test="${c.hcState=='A' }">
								<a href="javascript:xuanze('${c.hcId }','${c.hyName }','${c.cardName }','${c.hcNo }','${c.hcNum }')">选择</a>
								</c:if>
								</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div class="container text-center">
			<page:page pageName="pageInfo" uri="hybk/getHybk.action"></page:page>
		</div>
	</body>
	
</html>
<script type="text/javascript">

	function xuanze(hcId,hyName,cardName,hcNo,hcNum){
		if ('${bj}'==1) {//转入卡
		$(parent.document).find("#hyName2").html(hyName);
		$(parent.document).find("#cardName2").html(cardName);
		$(parent.document).find("#hcNo2").html(hcNo);
		$(parent.document).find("#hcNum2").html(hcNum);
		$(parent.document).find("#hcId2").val(hcId);
		}
		if ('${bj}'==0) {//转出卡
		$(parent.document).find("#hyName1").html(hyName);
		$(parent.document).find("#cardName1").html(cardName);
		$(parent.document).find("#hcNo1").html(hcNo);
		$(parent.document).find("#hcNum1").html(hcNum);
		$(parent.document).find("#hcId1").val(hcId);
		//设置最大转卡金额
		$(parent.document).find("#zkNum").attr("max",hcNum);
			
		}
		parent.closeModal();
	}

	function cleanUp(){
		$("input[name='hyName']").val("");
		$("input[name='cardName']").val("");
	}
	
	
</script>