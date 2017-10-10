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
		<div class="container">
			<hr>
			<form class="form-horizontal text-center" name="infoForm" action="javascript:doSub()" method="post">
				<input type="hidden" name="hcId" value="${bk.hcId }">
				<input type="hidden" name="bkId" value="${bk.bkId }">
				<input type="hidden" name="bkOldNo" value="${bk.bkOldNo }">
				<div class="container">
					<div class="form-group">
						<div class="col-sm-6">
							<button type="button" class="btn btn-warning anniu" onclick="selectHYK()">选择会员卡</button>
						</div>
						<div class="col-sm-6">
							<div class="form-group text-left">
								<label class="control-label">会员名称 : <span  id="hyName">${bk.hyName }</span></label>
							</div>
							<div class="form-group text-left">
								<label class="control-label">卡类型名称 : <span id="cardName">${bk.cardName }</span></label>
							</div>
							<div class="form-group text-left">
								<label class="control-label">卡号 : <span id="hcNo">${bk.hcNo }</span></label>
							</div>
							<div class="form-group text-left">
								<label class="control-label">余额 : <span id="hcNum">${bk.hcNum }</span></label>
							</div>
						</div>
					</div>
					<hr/>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">新卡号:</label>
						<div class="col-md-10 col-sm-10">
							<input class="form-control" name="bkNo" value="${bk.bkNo }" placeholder="填写新卡号" required="true"/>
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
		         <div class="modal-footer" id="modalFooter">
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
		$("#myModalLabel").html("选择会员卡");
		$("#modalBody").html("<iframe src=\"<%=request.getContextPath()%>/hybk/queryHybkForBk.action?pageNo=1&hcState=A\" width=\"100%\" height=\"380\" style=\"border:0\"></iframe>");
		$("#modalFooter").html("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
		$("#myModal").modal('show');
	}
	
	function doSub(){
		bootbox.confirm("确认提交吗?",function(r){
			if (r) {
				tijiao();
			}
		});
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/bk/save.action");
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