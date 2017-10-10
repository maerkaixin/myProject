<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询补卡记录</title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		<div class="container">
			<hr />
			<form class="form-horizontal text-center" action="<%=ctx%>/bk/query.action?pageNo=1" method="post">
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
								<input class="form-control btn-danger" type="button" onclick="del()" value="删除" />
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
					</div>
				</div>
			</form>
		</div>
		<form action="<%=ctx %>/bk/delete.action" method="post" name="delForm">
		<div class="container ">
			<table class="table table-hover table-striped  text-center" >
				<caption class="text-center"><strong>会员补卡</strong></caption>
				<thead >
					<tr class="bg-primary">
						<td>序号</td>
						<td><a href="javascript:selectAll()"><font style="color: white;">全选</font></a></td>
						<td>会员名称</td>
						<td>卡类型名称</td>
						<td>补卡时间</td>
						<td>补卡卡号</td>
						<td>原卡号</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list }" var="t" varStatus="i">
					<tr>
						<td>${i.count+page.start}</td>
						<td><input type="checkbox" name="ids" value="${t.bkId}"></td>
						<td>${t.hyName}</td>
						<td>${t.cardName}</td>
						<td><fmt:formatDate value="${t.bkTime}"/></td>
						<td>${t.bkNo}</td>
						<td>${t.bkOldNo }</td>
						<td>
							<a href="javascript:editpage('${t.bkId }')">修改</a>&nbsp;&nbsp;
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
		              	标题
		            </h4>
		         </div>
		         <div class="modal-body text-center" id="modalBody">
		           	是否确认提交?
		         </div>
		         <div class="modal-footer" id="modalFooter2">
		            <button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>
		         </div>
		      </div>
		   </div>
		</div>
		<div class="container text-center">
			<page:page pageName="pageInfo" uri="/bk/query.action"></page:page>
		</div>
	</body>
	
</html>
<script type="text/javascript">
	function addpage(){
		window.location.href = "<%=ctx%>/bk/page.action";
	}
	
	function editpage(id){
		window.location.href = "<%=ctx%>/bk/page.action?id="+id;
	}
	
	function del(){
		if($("input[name='ids']:checked").length==0){
			$("#myModalLabel").html("无法提交!");
			$("#modalBody").html("请选择要删除的记录");
			$("#modalFooter2").html("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
			$("#myModal").modal('show');
		}else {
			$("#myModalLabel").html("确认");
			$("#modalBody").html("是否要删除选中数据?");
			$("#modalFooter2").html("<button type='button' class='btn btn-primary' onclick='tijiao()'>确定</button><button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
			$("#myModal").modal('show');
		}
	}
	
	function tijiao(){
		document.delForm.submit();
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
		$("input[name='hyName']").val("");
		$("input[name='cardName']").val("");
	}
	
</script>