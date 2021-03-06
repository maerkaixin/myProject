<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>储物柜信息</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
	
		<div class="container">
			<hr />
			<form class="form-horizontal text-center" action="<%=request.getContextPath()%>/cwg/query.action?" method="post">
				<div class="container ">
					<div class="form-group">
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
						<div class=" col-lg-6 col-md-6 col-sm-8 col-xs-8" >
							<div class="col-md-6 col-sm-6">
								<input class="form-control btn-primary" type="button" onclick="addpage()" value="增加" />
							</div>
							<div class="col-md-6 col-sm-6">
								<input class="form-control btn-danger" type="button" onclick="del()" value="删除" />
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
					</div>
				</div>
			</form>
		</div>
		<form action="<%=request.getContextPath() %>/cwg/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>储物柜信息</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>储物柜编号</td>
						<td>储物柜状态</td>
						<td>储物柜价格</td>
						
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list }" var="cwg" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>
						<c:if test="${cwg.cwgState=='A'}">
							<input type="checkbox" name="ids" value="${cwg.cwgId}">
						</c:if>
						</td>
						<td>${cwg.cwgNo}</td>
						<td>
							<c:choose>
								<c:when test="${cwg.cwgState=='A'}">可用</c:when>
								<c:when test="${cwg.cwgState=='U'}">已被使用</c:when>
								<c:otherwise>不可用</c:otherwise>
							</c:choose>
						</td>
						<td>${cwg.cwgJiage}</td>
						<td>
							<a href="javascript:editpage('${cwg.cwgId }')">修改</a>&nbsp;&nbsp;
							<c:if test="${cwg.cwgState=='P'}">
							<a href="javascript:huifupage('${cwg.cwgId }')">恢复</a>&nbsp;&nbsp;
							</c:if>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		</form>
		
		<!-- 模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
		   aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header" style="background-color: rgba(0,0,0,0.1)">
		            <button type="button" class="close" data-dismiss="modal" 
		               aria-hidden="true">×
		            </button>
		            <h4 class="modal-title" id="myModalLabel">
		              	
		            </h4>
		         </div>
		         <div class="modal-body text-center" id="modalBody">
		           	
		         </div>
		         <div class="modal-footer" id="modalFooter2">
		            
		         </div>
		      </div>
		   </div>
		</div>
		<%-- 分页start --%>
		<div class="container text-center" >
			<page:page pageName="pageInfo" uri="/cwg/query.action"></page:page>
		</div>
		<%-- 分页end --%>
	</body>
	
</html>
<script type="text/javascript">
	function addpage(){
		window.location.href = "<%=request.getContextPath()%>/cwg/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=request.getContextPath()%>/cwg/page.action?id="+id;
	}
	function huifupage(id){
		window.location.href = "<%=request.getContextPath()%>/cwg/huifu.action?id="+id;
	}
	
	//全选
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
	
	function del(){
		var checked = $("form[name='delForm'] :input:checked");
		if(checked.length==0){
			$("#myModalLabel").html("无法提交");
			$("#modalBody").html("请选择要删除数据!");
			$("#modalFooter2").html("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
			$("#myModal").modal('show');
		}else{
			$("#myModalLabel").html("确认提交");
			$("#modalBody").html("是否确认提交?");
			$("#modalFooter2").html("<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='tijiao()'>提交</button><button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
			$("#myModal").modal('show');
		}
		
	}
	
	function tijiao(){
		$("form[name='delForm']").submit();
	}
	
	
</script>