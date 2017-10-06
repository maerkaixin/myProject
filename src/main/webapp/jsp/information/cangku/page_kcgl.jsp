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
			<form class="form-horizontal text-center" name="infoForm" action="javascript:doSub()" method="post">
				<input   type="hidden" name="ckId" value="${ck.ckId }" />
				<div class="container">
				<div class="form-group">
					<label class="control-label col-sm-2 col-md-2">仓库名称:</label>
               		<div class="col-md-4 col-sm-4">
						<input class="form-control" name="ckName" value="${ck.ckName }"  placeholder="请输入仓库名称" />
					</div>
					<label class="control-label col-sm-2 col-md-2">仓库代号:</label>
               		<div class="col-md-4 col-sm-4">
						<input class="form-control" name="ckNo" value="${ck.ckNo }"  placeholder="请输入仓库代号" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-md-2">所属部门:</label>
					<div class="col-md-4 col-sm-4">
						<select class="form-control" name="deptId" onchange="queryPerList(this.value)">
							<option value="">===请选择===</option>
							<c:forEach items="${deptList }" var="dept">
							<option value="${dept.deptId }" ${dept.deptId==ck.deptId?"selected":"" }>${dept.deptName }</option>
							</c:forEach>
						</select>
					</div>
					<label class="control-label col-sm-2 col-md-2">库管:</label>
					<div class="col-md-4 col-sm-4">
						<select class="form-control" name="ppId" id=ppId >
							<option value="">===请选择===</option>
							<c:forEach items="${perList }" var="per">
							<option value="${per.ppId }" ${per.ppId==ck.ppId?"selected":"" }>${per.ppName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 col-md-2">仓库地址:</label>
					<div class="col-md-6 col-sm-6">
						<textarea class="form-control" name="ckAdds" rows="3" placeholder="请输入仓库地址" >${ck.ckAdds }</textarea>
					</div>
				</div>	
				<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
				
				</div>
				<div class=" col-lg-6 col-md-6 col-sm-8 col-xs-8" >
					<div class="col-md-6 col-sm-6">
						<input class="form-control btn-primary" id="tj"  type="submit" value="提交" onclick="tiJiao()"/>
					</div>
					<div class="col-md-6 col-sm-6">
						<input class="form-control btn-primary" type="button" onclick="goBack()" value="返回" />
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-2 col-xs-2">
				
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
	
	function tj(){
		
	}
	
	function doSub(){
		$("#myModal").modal('show');
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/ck/save.action");
		$("form").submit();
	}
	
	function clearTime(id1,id2){
		$("#"+id1).val("");
		$("#"+id2).val("");
	}
	function queryPerList (id){
		var url= "<%=request.getContextPath()%>/person/queryPersonByDeptId.action";
		var data={"id":id};
		
		$.get(url,data,function(r){
			console.log(r);
			if (r.success) {
				var array = r.obj;
				var options =[];
				for (var i = 0; i < array.length; i++) {
					options.push("<option value="+array[i].ppId +" >"+array[i].ppName+"</option>");
				}
				$("#ppId").html(options.join(""));
			}
		},"json");
		
		
	}
	
	
	function goBack(){
		history.go(-1);
	}
	
	
</script>