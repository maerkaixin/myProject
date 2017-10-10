<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
			<form class="form-horizontal text-center" action="<%=ctx%>/hybk/queryHybkForBk.action?pageNo=1" method="post">
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
						<td>会员名称</td>
						<td>卡类型名称</td>
						<td>卡号</td>
						<td>售卡时间</td>
						<td>余额</td>
						<td>卡状态</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list }" var="hybk" varStatus="i">
					<tr onmouseover="yiru(this)" onmouseout="yichu(this)" ondblclick="xz('${hybk.hcId }','${hybk.hcNum }','${hybk.cardName }','${hybk.hcNo }','${hybk.hyName }')">
						<td>${i.count+page.start}</td>
						<td>${hybk.hyName}</td>
						<td>${hybk.cardName}</td>
						<td>${hybk.hcNo}</td>
						<td><fmt:formatDate value="${hybk.hcTime}"/></td>
						<td>${hybk.hcNum}</td>
						<td>${hybk.hcState=="A"?"可用":"不可用"}</td>
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
		<div class="container text-center">
			<page:page pageName="pageInfo" uri="/hybk/queryHybkForBk.action"></page:page>
		</div>
	</body>
	
</html>
<script type="text/javascript">
	
	
		
	
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
	
	function yiru(tr){
		yuan=$(tr).css("background-color");
		$(tr).css("background-color","lightblue");
	}
	
	function yichu(tr){
		$(tr).css("background-color",yuan);
	}
	
	function xz(id,num,cardName,no,name){
			parent.document.getElementsByName("hcId")[0].value=id;
			parent.document.getElementById("hyName").innerText=name;
			parent.document.getElementById("cardName").innerText=cardName;
			parent.document.getElementById("hcNo").innerText=no;
			parent.document.getElementById("hcNum").innerText=num;
			parent.document.getElementsByName("bkOldNo")[0].value=no;
			parent.$("#myModal").modal("hide");
	}
	function del(){
	//抓取 name是delForm 的 from 表单  中 属性是checked 的input标签 的 值
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