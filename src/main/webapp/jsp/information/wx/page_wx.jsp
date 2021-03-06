﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body style="background:linear-gradient(white,#ebebeb,white);">
		
		<div class="container">
			<hr>
			<form class="form-horizontal text-center" name="infoForm" action="javascript:doSub()" method="post">
	
				<div class="container">
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">维修类型:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="cwlId" >
								<option value="">===请选择===</option>
							 	<c:forEach items="${wxlxList }" var="wxlx" >
									<option value="${wxlx.cwlId }" ${wx.cwlId==wxlx.cwlId?"selected":"" }>${wxlx.cwlName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="control-label col-sm-2 col-md-2">报修人员:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="ppId" >
								<option value="">===请选择===</option>
								<c:forEach items="${personList }" var="per" >
									<option value="${per.ppId }" ${wx.ppId==per.ppId?"selected":"" }>${per.ppName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">保修部门:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="deptId" >
								<option value="">===请选择===</option>
								<c:forEach items="${deptList }" var="dept" >
									<option value="${dept.deptId }" ${wx.deptId==dept.deptId?"selected":"" }>${dept.deptName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="control-label col-sm-2 col-md-2">维修状态:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="wxjlState" >
								<option value="">===请选择===</option>
								<option value="未开始" ${wx.wxjlState=="未开始"?"selected":""}>未开始</option>
								<option value="维修中" ${wx.wxjlState=="维修中"?"selected":""}>维修中</option>
								<option value="维修结束" ${wx.wxjlState=="维修结束"?"selected":""}>维修结束</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">维修名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="wxjlName" value="" placeholder="请输入维修名称">
						</div>
						<label class="control-label col-sm-2 col-md-2">维修时长:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="wxjlLen" value="" placeholder="请输入维修时长">
						</div>
					</div>
					<div class="form-group">
						<label for="dtp_input1"  class="control-label col-sm-2 col-md-2">保修时间:</label>
                		<div class="col-md-4 col-sm-4" >
                			<div class="input-group">
		                    	<input class="form-control" id="mydate"  name="wxjlTime" type="text" value="" readonly placeholder="点击选择日期">
		               			<span class="input-group-addon">
		               				<span class="glyphicon glyphicon-calendar"></span>
		               			</span>
		               		</div>
		                </div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">维修描述:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" name="wxjlInfo" rows="3" placeholder="请输入维修描述" ></textarea>
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
		   <div class="modal-dialog">
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

	$("#mydate").datetimepicker({
	    minView: 'month',
	    format:'yyyy-mm-dd',
	    weekStart: 1,
	    todayBtn: 1,
	    autoclose: 1,
	    todayHighlight: 1,
	    startView: 2,
	    forceParse: 0,
	    showMeridian: 1,
	    language: 'zh-CN'
	});

	
	function doSub(){
		$("#myModal").modal('show');
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/wx/save.action");
		$("form").submit();
	}
	
	function clearTime(id1,id2){
		$("#"+id1).val("");
		$("#"+id2).val("");
	}
	
	function goBack(){
		history.go(-1);
	}
</script>