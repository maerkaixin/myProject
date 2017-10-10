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
			<h4>当前位置：添加转卡记录</h4>
		</label>
		<div class="container">
			<hr>
			<form class="form-horizontal text-center" name="infoForm" action="javascript:doSub()" method="post">
				
				<input type="hidden" name="zkOldId" id="hcId1">
				<input type="hidden" name="zkNewId" id="hcId2">
				
				<div class="container">
					<div class="form-group">
						<div class="col-sm-6">
							<button type="button" class="btn btn-warning anniu" onclick="selectHYK(0)">选择转出卡</button>
						</div>
						<div class="col-sm-6">
							<div class="form-group text-left">
								<label class="control-label col-sm-3">会员名称 : </label>
								<label class="control-label" id="hyName1">请先选择要转出的卡</label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">卡类型名称 : </label>
								<label class="control-label" id="cardName1"></label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">卡号 : </label>
								<label class="control-label" id="hcNo1"></label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">余额 : </label>
								<label class="control-label" id="hcNum1"></label>
							</div>
						</div>
					</div>
					<hr/>
					<div class="form-group">
						<div class="col-sm-6">
							<button type="button" class="btn btn-warning anniu" onclick="selectHYK(1)">选择转入卡</button>
						</div>
						<div class="col-sm-6">
							<div class="form-group text-left">
								<label class="control-label col-sm-3">会员名称 : </label>
								<label class="control-label" id="hyName2">请先选择要转入的卡</label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">卡类型名称 : </label>
								<label class="control-label" id="cardName2"></label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">卡号 : </label>
								<label class="control-label" id="hcNo2"></label>
							</div>
							<div class="form-group text-left">
								<label class="control-label col-sm-3">余额 : </label>
								<label class="control-label" id="hcNum2"></label>
							</div>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">转出金额:</label>
						<div class="col-md-10 col-sm-10">
							<input class="form-control" name="zkNum" id="zkNum"  placeholder="填写转出金额" requored="true" min="1" step="1" type="number"  />
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
	function selectHYK(bj){
		//alert('选择会员卡');
		$("#myModalLabel").html("查询会员卡");
		$("#modalBody").html("<iframe src='${pageContext.request.contextPath}/hybk/queryHybkForZk.action?bj="+bj+"' width='100%' height='470px' style='border:0;'></iframe>");
		$("#modalFooter2").html("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
		$("#myModal").modal('show');
	}
	
	function doSub(){
		//必须选择一个会员卡
		if($("input[name='zkOldId']").val()==""){
			bootbox.alert("请先选择要转出的卡");
			reutrn;
		}
		if($("input[name='zkNewId']").val()==""){
			bootbox.alert("请先选择要转入的卡");
			reutrn;
		}
		bootbox.confirm("确认提交吗?",function(r){
			if (r) {
				tijiao();
			}
		});
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/zk/addsave.action");
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