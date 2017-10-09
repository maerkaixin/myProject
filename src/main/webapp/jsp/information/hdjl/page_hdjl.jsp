<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
			<form class="form-horizontal text-center" style="position:relative;"  name="infoForm" action="javascript:doSub()" method="post" enctype="multipart/form-data">
				<input name="hdjlId" value="${hdjl.hdjlId }" type="hidden"> 
				<div class="container" >
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">活动主题:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hdjlTitle" value="${hdjl.hdjlTitle }" placeholder="请输入活动主题" />
						</div>
						<label class="control-label col-sm-2 col-md-2">时长:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hdjlLen" value="${hdjl.hdjlLen }" placeholder="请输入时长" />
						</div>	
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">活动开始时间:</label>
						<div class="col-md-4 col-sm-4">
							<div class="input-group date form_date" data-date-format="yyyy-mm-dd" >
			                    <input class="form-control" id="showTime1"  type="text" name="hdjlStartDate" value="<fmt:formatDate value="${hdjl.hdjlStartDate }"/>" readonly>
			                    <span class="input-group-addon"><span  onclick="clearTime(this)" class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
						</div>
						<label class="control-label col-sm-2 col-md-2">活动结束时间:</label>
						<div class="col-md-4 col-sm-4">
							<div class="input-group date form_date" data-date-format="yyyy-mm-dd" >
			                    <input class="form-control" id="showTime1"  type="text" name="hdjlEndDate" value="<fmt:formatDate value="${hdjl.hdjlEndDate }"/>" readonly>
			                    <span class="input-group-addon"><span  onclick="clearTime(this)" class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
						</div>	
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">总预算:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hdjlTotal" value="${hdjl.hdjlTotal }" placeholder="请输入总预算" />
						</div>
							
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">举办地点:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" cols="3" name="hdjlAdds" placeholder="请输入举办地点">${hdjl.hdjlAdds }</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">描述:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" cols="3" name="hdjlInfo" placeholder="请输入描述">${hdjl.hdjlInfo }</textarea>
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
		              	
		            </h4>
		         </div>
		         <div class="modal-body text-center" id="modalBody">
		           	
		         </div>
		         <div class="modal-footer" id="modalFooter2">
		            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
	
	function clearTime(id1,id2){
		$("#"+id1).val("");
		$("#"+id2).val("");
	}
	
	function doSub(){
		$("#myModalLabel").html("确认提交");
		$("#modalBody").html("是否确定提交?");
		$("#modalFooter2").html("<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='tijiao()'>提交</button><button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
		$("#myModal").modal('show');
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/hdjl/save.action");
		$("form").submit();
	}
	
	function goBack(){
		history.go(-1);
	}
</script>