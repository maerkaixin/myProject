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
			<form name="queryForm" class="form-horizontal text-center" action="<%=ctx%>/goods/query.action?pageNo=1" method="post">
				<div class="container">
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">商品名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" type="text" name="goodsName" value="${page.goodsName}" placeholder="请输入会员名称" />
						</div>
						<label class="control-label col-sm-2 col-md-2">商品编号:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsNo" value="${page.goodsNo}" placeholder="请输入会员代号" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">商品条形码:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsMa" value="${page.goodsMa}" placeholder="请输入会员电话" />
						</div>
						<label class="control-label col-sm-2 col-md-2">供应商信息:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="qyId">
								<option value="">===请选择===</option>
								<c:forEach items="${qiyeList }" var="qiye" >
									<option value="${qiye.qyId }" ${page.qyId==qiye.qyId?"selected":"" }>${qiye.qyName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">商品品牌:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="cspId">
								<option value="">===请选择===</option>
								<c:forEach items="${spppList }" var="sppp" >
									<option value="${sppp.cspId }" ${page.cspId==sppp.cspId?"selected":"" }>${sppp.cspName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="control-label col-sm-2 col-md-2">商品类型:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="cslId">
								<option value="">===请选择===</option>
								<c:forEach items="${splxList }" var="splx" >
									<option value="${splx.cslId }" ${page.cslId==splx.cslId?"selected":"" }>${splx.cslName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-2 col-sm-2">价格:</label>
						<div class="col-md-4 col-sm-4">
							<div class="input-group">
								<input class="form-control" name="goodsMjFrom" value="${page.goodsMjFrom}" placeholder="请输入最低价格"/>
								<div class="input-group-addon">
									至
								</div>
								<input class="form-control" name="goodsMjTo" value="${page.goodsMjTo}" placeholder="请输入最高价格"/>
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
		<form action="<%=ctx %>/goods/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>商品信息列表</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>商品名称</td>
						<td>商品编号</td>
						<td>商品类型</td>
						<td>商品面价</td>
						<td>商品品牌</td>
						<td>供应商</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list }" var="t" varStatus="i">
					<tr >
						<td>${i.count+page.start }</td>
						<td><input type="checkbox" name="ids" value="${t.goodsId}"></td>
						<td>${t.goodsName }</td>
						<td>${t.goodsNo }</td>
						<td>${t.cslName }</td>
						<td>${t.goodsMianjia }</td>
						<td>${t.cspName }</td>
						<td>${t.qyName }</td>
						<td>
							<a href="javascript:editpage('${t.goodsId}')">修改</a>&nbsp;&nbsp;
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		<div align="center">
			<page:page pageName="pageInfo" uri="/goods/query.action"></page:page>
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
		window.location.href = "<%=ctx%>/goods/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/goods/page.action?id="+id;
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