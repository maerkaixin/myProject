<%@page import="com.turing.huiyuan.page.HyglHuiyuanPage"%> 
<%@page import="com.turing.huiyuan.entity.HyglHuiyuan"%>
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
			<form class="form-horizontal text-center" style="position:relative;"  name="infoForm" action="javascript:doSub()" method="post" enctype="multipart/form-data">
				<input type="hidden" name="hyId" value="${hy.hyId }">
				<input type="hidden" name="hyPic" value="${hy.hyPic }">
				<div class="container " >
					<div class="form-group" style="position:absolute;right: 0px;top: 30px">
							<img id="image" src="${hy.hyPic }" width="130" height="150">
						<input type="file" name="pic" onchange="yuLan(this,'image','preview')" >
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">会员名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyName" value="${hy.hyName }" placeholder="请输入会员名称" />
						</div>	
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员代号:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyNo" value="${hy.hyNo }" placeholder="请输入会员代号" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员性别:</label>
						<div class="col-md-4 col-sm-4">
							<div class="col-md-6 col-sm-6">
								<input type="radio"   class="col-md-1 col-sm-1"  name="hySex"  value="1" ${hy.hySex=='1'?'checked':'' }/><span class="col-md-1 col-sm-1">男</span>&nbsp;&nbsp;
							</div>
							<div class="col-md-6 col-sm-6">
								<input type="radio"  class="col-md-1 col-sm-1"  name="hySex"  value="0" ${hy.hySex=='0'?'checked':'' }/><span class="col-md-1 col-sm-1">女</span>
							</div>	
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员年龄:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyAge" value="${hy.hyAge }" placeholder="请输入会员年龄" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员生日:</label>
						<div class="col-md-4 col-sm-4">
							<div class="input-group date form_date" data-date-format="yyyy-mm-dd" >
			                    <input class="form-control" id="showTime1"  type="text" name="hyBirth" value="<fmt:formatDate value="${hy.hyBirth }"/>" readonly>
			                    <span class="input-group-addon"><span  onclick="clearTime(this)" class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员身份证号:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyShenfenzheng" value="${hy.hyShenfenzheng }" placeholder="请输入会员身份证号" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">工作单位:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyGongzhuodanwei" value="${hy.hyGongzhuodanwei }" placeholder="请输入会员工作单位" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员职业:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyZhiye" value="${hy.hyZhiye }" placeholder="请输入会员职业" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员婚否:</label>
						<div class="col-md-4 col-sm-4">
							<div class="col-md-6 col-sm-6">
								<input type="radio"  class="col-md-1 col-sm-1"  name="hyHunyinqingkuang"  value="1" ${hy.hyHunyinqingkuang=='1'?'checked':''} /><span class="col-md-6 col-sm-6">已婚</span>&nbsp;&nbsp;
							</div>
							<div class="col-md-6 col-sm-6">
								<input type="radio"  class="col-md-1 col-sm-1"  name="hyHunyinqingkuang"  value="0" ${hy.hyHunyinqingkuang=='0'?'checked':''} /><span class="col-md-6 col-sm-6">未婚</span>
							</div>	
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员身高:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyShengao" value="${hy.hyShengao }" placeholder="请输入会员身高" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员体重:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyTizhong" value="${hy.hyTizhong }" placeholder="请输入会员体重" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">会员血型:</label>
						<div class="col-md-4 col-sm-4">
							<select name="hyXuexing" class="form-control">
								<option value="">===请选择===</option>
								<option value="A"  ${hy.hyXuexing=='A'?'selected':'' }>A型</option>
								<option value="B"  ${hy.hyXuexing=='B'?'selected':'' }>B型</option>
								<option value="O"  ${hy.hyXuexing=='O'?'selected':'' }>O型</option>
								<option value="AB"  ${hy.hyXuexing=='AB'?'selected':'' }>AB型</option>
								<option value="Other"  ${hy.hyXuexing=='Other'?'selected':'' }>其他</option>
							</select>
						</div>	
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">会员邮编:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyYoubian" value="${hy.hyYoubian }" placeholder="请输入会员邮编" />
						</div>				
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">会员电话:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyPhone" value="${hy.hyPhone }" placeholder="请输入会员电话" />
						</div>				
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">会员电子邮件:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="hyEmail" value="${hy.hyEmail }" placeholder="请输入会员电子邮件" />
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">入会方式:</label>
						<div class="col-md-4 col-sm-4">
							<select name="crfId" class="form-control">
								<option value="">===请选择===</option>
								<c:forEach items="${rhfsList}" var="rhfs">
								<option value="${rhfs.crfId}"${rhfs.crfId==hy.crfId?"selected":"" }>${rhfs.crfName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">备注:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" name="hyInfo" rows="3" placeholder="请输备注" >${hy.hyInfo }</textarea>
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
		            <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
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
	
	function clearTime(span){
		var div = span.parentNode.parentNode;
		div.children[0].value="";
	}
	
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
		$("form[name='infoForm']").attr("action","<%=ctx%>/huiyuan/edit.action");
		$("form").submit();
	}
	
	function goBack(){
		//history.go(-1);
		window.location.href = "<%=ctx%>/huiyuan/query.action";
	}
</script>