<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
				<input type="hidden" name="xcfsId" value="${xcfs.xcfsId}">
				<input type="hidden" name="xcfsInDate" value="<fmt:formatDate value="${xcfs.xcfsInDate}" pattern="yyyy-MM-dd"/>">
				<div class="container">
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">宣传方式名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="xcfsName" value="${xcfs.xcfsName}" placeholder="请输入宣传方式名称" />
						</div>
						<label class="control-label col-sm-2 col-md-2">宣传方式价格:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="xcfsJiage" value="${xcfs.xcfsJiage}" placeholder="请输入宣传方式价格" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">联系人:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="xcfsLxr" value="${xcfs.xcfsLxr}" placeholder="请输入联系人" />
						</div>
						<label class="control-label col-sm-2 col-md-2">联系电话:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="xcfsPhone" value="${xcfs.xcfsPhone}" placeholder="请输入联系电话" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">宣传方式说明:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" name="xcfsInfo" rows="3" placeholder="请输入宣传方式说明" >${xcfs.xcfsInfo}</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">宣传效果:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" name="xcfsXiaoguo" rows="3" placeholder="请输入宣传效果" >${xcfs.xcfsXiaoguo}</textarea>
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
	
	
	function doSub(){
		$("#myModal").modal('show');
	}
	
	function tijiao(){
		$("form[name='infoForm']").attr("action","<%=ctx%>/xcfs/save.action");
		$("form").submit();
	}
	
	function goBack(){
		history.go(-1);
	}
</script>