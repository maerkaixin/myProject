<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<input type="hidden" name="gcId" value="${gcgl.gcId}">
				<div class="container">
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">工程类型:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="cglId" >
								<option value="">===请选择===</option>
								<c:forEach items="${gclxList }" var="gclx" >
									<option value="${gclx.cglId }" ${gcgl.cglId==gclx.cglId?"selected":"" }>${gclx.cglName}</option>
								</c:forEach>
								
							</select>
						</div>
						<label class="control-label col-sm-2 col-md-2">总费用:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="gcNum" value="${gcgl.gcNum }" placeholder="请输入总费用"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">负责人:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="ppId" >
								<option value="">===请选择===</option>
							<c:forEach items="${personList }" var="per" >
									<option value="${per.ppId }" ${gcgl.ppId==per.ppId?"selected":"" }>${per.ppName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="control-label col-sm-2 col-md-2">开始时间:</label>
						<div class="col-md-4 col-sm-4" >
		                    <div class="input-group date form_date" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
			                    <input class="form-control" id="showTime1"  name="gcStartDate" type="text" value='<fmt:formatDate value="${gcgl.gcStartDate }"/>' placeholder="请输入开始时间" readonly>
			                    <span class="input-group-addon"><span  onclick="clearTime('showTime1','dtp_input1')" class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
								
		                	</div>
		                </div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">部门:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="deptId" >
								<option value="">===请选择===</option>
								<c:forEach items="${deptList }" var="dept" >
									<option value="${dept.deptId }" ${gcgl.deptId==dept.deptId?"selected":"" }>${dept.deptName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="control-label col-sm-2 col-md-2">结束时间:</label>
                		<div class="col-md-4 col-sm-4" >
		                    <div class="input-group date form_date" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
			                    <input class="form-control" id="showTime2"  name="gcEndDate" type="text" value='<fmt:formatDate value="${gcgl.gcEndDate }"/>' placeholder="请输入结束时间" readonly>
			                    <span class="input-group-addon"><span  onclick="clearTime('showTime2','dtp_input2')" class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
								
		                	</div>
		                </div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">工程名称:</label>
                		<div class="col-md-4 col-sm-4">
							<input class="form-control" name="gcName" value="${gcgl.gcName }" placeholder="请输入工程名称" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">工程描述:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" name="gcInfo" rows="3"   placeholder="请输入工程描述" >${gcgl.gcInfo }</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">工程评估:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" name="gcPinggu" rows="3" placeholder="请输入工程评估" >${gcgl.gcPinggu }</textarea>
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
	
	function doSub(){
		$("#myModal").modal('show');
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/gcgl/save.action");
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