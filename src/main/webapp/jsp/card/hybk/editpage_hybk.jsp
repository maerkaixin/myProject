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
		</style>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
	
		<div class="container">
			<hr>
			<form class="form-horizontal text-center" name="infoForm" action="javascript:doSub()" method="post">
				<input name="hcId" value="${hybk.hcId }" type="hidden">
				<input name="hyId" value="${hybk.hyId }" type="hidden">
				<input name="cardId" value="${hybk.cardId }" type="hidden">
				<div class="container">
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2"></label>
						<div class="col-md-4 col-sm-4">
							<input class="btn btn-success form-control" type="button" value="选择会员" onclick="selectHuiyuan()"/>
						</div>
						<label class="control-label col-sm-2 col-md-2"></label>
						<div class="col-md-4 col-sm-4">
							<input class="btn btn-success form-control" type="button" value="选择卡类型" onclick="selectCardtype()"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyName" value="${hybk.hyName }" placeholder="点击选择会员" readonly="readonly"/>
						</div>
						<label class="control-label col-sm-2 col-md-2">卡类型名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="cardName" value="${hybk.cardName }" placeholder="点击选择卡类型" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员代号:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyNo" value="${hybk.hyNo }" placeholder="" readonly="readonly"/>
						</div>
						<label class="control-label col-sm-2 col-md-2">卡内金额:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hcNum" value="${hybk.hcNum }" placeholder="" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group"></div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">卡号:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hcNo" value="${hybk.hcNo }" placeholder="输入卡号" required />
						</div>
						
					</div>
					<div class="form-group">
						
						<label class="control-label col-sm-2 col-md-2">密码:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" type="password" name="hcPass" value="${hybk.hcPass }" placeholder="输入卡密码"  required/>
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
				<hr/>
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
	function selectHuiyuan(){
		$(".modal-dialog").addClass("modal-lg");
		$("#myModalLabel").html("选择会员");
		$("#modalBody").html("<iframe src=\"<%=request.getContextPath()%>/huiyuan/getHuiyuan.action?pageNo=1\" width=\"100%\" height=\"380\" style=\"border:0\"></iframe>");
		$("#myModal").modal("show");
	}
	
	function selectCardtype(){
		$(".modal-dialog").addClass("modal-lg");
		$("#myModalLabel").html("选择卡类型");
		$("#modalBody").html("<iframe src=\"<%=request.getContextPath()%>/cardType/getCardType.action?pageNo=1\" width=\"100%\" height=\"380\" style=\"border:0\"></iframe>");
		$("#myModal").modal("show");
	}
	function doSub(){
		//$("#myModal").modal('show');
		if($("input[name='hyId']").val()==""){
			alert("请选择一个会员!");
			return;
		}
		if($("input[name='cardId']").val()==""){
			alert("请选择一个卡类型!");
			return;
		}
		if($("input[name='hcNo']").val()==""){
			alert("卡号不能为空");
			return;
		}
		if($("input[name='hcPass']").val()==""){
			alert("密码不能为空");
			return;
		}
		tijiao();
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/hybk/update.action");
		$("form").submit();
	}
	
	function goBack(){
		history.go(-1);
	}
	function closeModal(){
		$("#myModal").modal('hide');
	}
</script>