<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询商品信息</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		
		<div class="container">
			<hr />
			<form name="queryForm" class="form-horizontal text-center" action="<%=ctx%>/hdjl/query.action?pageNo=1" method="post">
				<div class="container">
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">促销主题:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" type="text" name="hdjlTitle" value="${page.hdjlTitle}" placeholder="请输入促销主题" />
						</div>
						
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 col-sm-2">总预算:</label>
						<div class="col-md-4 col-sm-4">
							<div class="input-group">
								<input class="form-control" name="moneyFrom" value="${page.moneyFrom}" placeholder="请输入最低预算"/>
								<div class="input-group-addon">
									至
								</div>
								<input class="form-control" name="moneyTo" value="${page.moneyTo}" placeholder="请输入最高预算"/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">开始时间:</label>
						<div class="col-md-7 col-sm-7">
							<div class="input-group">
								<div class="input-group date form_date" data-date-format="yyyy-mm-dd" >
				                    <input class="form-control" id="showTime" name="timeFrom" value="<fmt:formatDate value="${page.timeFrom}" pattern="yyyy-MM-dd"/>" type="text"  readonly>
				                    <span class="input-group-addon"><span  onclick="clearTime(this)" class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								<div class="input-group-addon">
									至
								</div>
								<div class="input-group date form_date"  data-date-format="yyyy-mm-dd">
				                    <input class="form-control" name="timeTo" id="showTime1" value="<fmt:formatDate value="${page.timeTo}" pattern="yyyy-MM-dd"/>" type="text" readonly>
				                    <span class="input-group-addon"><span  onclick="clearTime(this)" class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
							</div>
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
		<form action="<%=ctx %>/hdjl/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>促销活动</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>促销主题</td>
						<td>开始时间</td>
						<td>长度（天）</td>
						<td>总预算</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.list }" var="hdjl" varStatus="i">
						<tr>
							<td>${i.count+page.start}</td>
							<td><input type="checkbox" name="ids" value="${hdjl.hdjlId}"></td>
							<td>${hdjl.hdjlTitle}</td>
							<td><fmt:formatDate value="${hdjl.hdjlStartDate}"/></td>
							<td>${hdjl.hdjlLen}</td>
							<td>${hdjl.hdjlTotal}</td>
							<td>
								<a href="javascript:editpage('${hdjl.hdjlId }')">修改</a>&nbsp;&nbsp;
								<a href="javascript:setjp('${hdjl.hdjlId }')">设置奖品</a>&nbsp;&nbsp;
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div align="center">
			<page:page pageName="page" uri="/hdjl/query.action"></page:page>
		</div>
	</body>
</html>
<script type="text/javascript">
	$('.form_date').datetimepicker({
		language:  'zh-CN',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
	});
	
	
	function addpage(){
		window.location.href = "<%=ctx%>/hdjl/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/hdjl/page.action?id="+id;
	}
	
	function setjp(id){
		window.location.href = "<%=ctx%>/hdjp/query.action?hdjlId="+id;
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
		$("form:first :text").val("");
		$("form:first select").val("");
	}
	
	</script>