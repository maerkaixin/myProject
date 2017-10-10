<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			.quan{
				border:1px solid blue;
				border-radius:5px;
				padding:5px;
				height: 200px;
			}
			.anniu{
				width : 100px;
				height: 100px;
				border-radius:50px;
			}
		</style>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		<label class="control-label label-default col-xs-12 " style="margin-bottom: 30px;">
			<h4>当前位置：添加退卡记录</h4>
		</label>
		<div class="container">
			<hr>
			<form class="form-horizontal text-center" name="infoForm" action="javascript:doSub()" method="post">
				
				<input type="hidden" name="hcId" id="hcId" value="${tk.hcId }">
				<input type="hidden" name="tkId"  value="${tk.tkId }">
				
				<div class="container">
					<div class="form-group">
						<div class="col-sm-6">
							<button type="button" class="btn btn-warning anniu" onclick="selectHYK()">选择会员卡</button>
						</div>
						<div class="col-sm-6">
							<div class="form-group text-left">
								<label class="control-label col-sm-3">会员名称 : </label>
								<label class="control-label" id="hyName">${tk.hyName}</label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">卡类型名称 : </label>
								<label class="control-label" id="cardName">${tk.cardName}</label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">卡号 : </label>
								<label class="control-label" id="hcNo">${tk.hcNo}</label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">余额 : </label>
								<label class="control-label" id="hcNum">${tk.hcNum}</label>
							</div>
						</div>
					</div>
					<hr/>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">退卡原因:</label>
						<div class="col-md-10 col-sm-10">
							<textarea class="form-control" name="tkInfo" rows="3" placeholder="填写退卡原因" retuired="true">${tk.tkInfo }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
						<div class=" col-lg-6 col-md-6 col-sm-8 col-xs-8" >
							<div class="col-md-6 col-sm-6">
								<input class="form-control btn-primary" type="submit" value="提交" />
							</div>
							<div class="col-md-6 col-sm-6">
								<input class="form-control btn-primary" type="button" onclick="goBack()" value="返回" />
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
							
						</div>
					</div>
				</div>
			</form>
		</div>
		
		<!-- 模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
		   aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog modal-lg">
		      <div class="modal-content">
		         <div class="modal-header" style="background-color: rgba(0,0,0,0.1)">
		            <button type="button" class="close" data-dismiss="modal" 
		               aria-hidden="true">×
		            </button>
		            <h4 class="modal-title" id="myModalLabel">
		              	确认提交
		            </h4>
		         </div>
		         <div class="modal-body text-center" id="modalBody">
		           	是否确认提交?
		         </div>
		         <div class="modal-footer" id="modalFooter2">
		            <button type='button' class='btn btn-primary' data-dismiss='modal' onclick='tijiao()'>提交</button>
		            <button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>
		         </div>
		      </div>
		   </div>
		</div>
	</body>
</html>
<script type="text/javascript">
	function selectHYK(){
		//alert('选择会员卡');
		$("#myModalLabel").html("查询会员卡");
		$("#modalBody").html("<iframe src='${pageContext.request.contextPath}/hybk/queryHybkForTk.action' width='100%' height='470px' style='border:0;'></iframe>");
		$("#modalFooter2").html("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
		$("#myModal").modal('show');
	}
	
	function doSub(){
		bootbox.confirm("确定退卡吗?",function(r){
			if (r) {
				tijiao();
			}
		});
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/tk/editsave.action");
		$("form").submit();
	}
	
	function goBack(){
		history.go(-1);
	}
	function closeModal(){
		$("#myModal").modal('hide');
	}
	function xuanzeChongzhiJine(s){
		$("input[name='czNum']").val(s);
	}
</script>