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
				<input type="hidden" name="goodsId" value="${goods.goodsId}">
				<input type="hidden" name="goodsState" value="${goods.goodsState}">
				<div class="container" >
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">商品名称:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsName" value="${goods.goodsName }" placeholder="请输入商品名称" />
						</div>
						<label class="control-label col-sm-2 col-md-2">商品编号:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsNo" value="${goods.goodsNo }" placeholder="请输入商品编号" />
						</div>	
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">商品均价:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsJiage" value="${goods.goodsJiage }" placeholder="请输入商品均价" />
						</div>
						<label class="control-label col-sm-2 col-md-2">商品面价:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsMianjia" value="${goods.goodsMianjia }" placeholder="请输入商品面价" />
						</div>	
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">库存上限:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsMax" value="${goods.goodsMax }" placeholder="请输入库存上限" />
						</div>
						<label class="control-label col-sm-2 col-md-2">库存下限:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsMin" value="${goods.goodsMin }" placeholder="请输入库存下限" />
						</div>	
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">商品品牌:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="cspId">
								<option value="">===请选择===</option>
								<c:forEach items="${spppList }" var="sppp" >
									<option value="${sppp.cspId }" ${goods.cspId==sppp.cspId?"selected":"" }>${sppp.cspName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="control-label col-sm-2 col-md-2">商品类型:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="cslId">
								<option value="">===请选择===</option>
								<c:forEach items="${splxList }" var="splx" >
									<option value="${splx.cslId }" ${goods.cslId==splx.cslId?"selected":"" }>${splx.cslName}</option>
								</c:forEach>
							</select>
						</div>	
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">供应商:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="qyId">
								<option value="">===请选择===</option>
								<c:forEach items="${qiyeList }" var="qiye" >
									<option value="${qiye.qyId }" ${goods.qyId==qiye.qyId?"selected":"" }>${qiye.qyName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="control-label col-sm-2 col-md-2">商品单位:</label>
						<div class="col-md-4 col-sm-4">
							<select class="form-control" name="csdId">
								<option value="">===请选择===</option>
								<c:forEach items="${spdwList }" var="spdw" >
									<option value="${spdw.csdId }" ${goods.csdId==spdw.csdId?"selected":"" }>${spdw.csdName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">商品条形码:</label>
						<div class="col-md-4 col-sm-4">
							<input class="form-control" name="goodsMa" value="${goods.goodsMa }" placeholder="请输入商品条形码" />
						</div>
					</div>
					<div class="form-group" >
						<label class="control-label col-sm-2 col-md-2">商品产地:</label>
						<div class="col-md-6 col-sm-6">
							<div class="input-group">
								<select class="form-control" name="caShengId"  onchange="getCityByShengId(this.value)">
									<option value="">===请选择===</option>
									<c:forEach items="${shengList }" var="sheng" >
										<option value="${sheng.caId }" ${goods.caShengId==sheng.caId?"selected":"" }>${sheng.caName}</option>
									</c:forEach>
								</select>
								<div class="input-group-addon">
									省
								</div>
								<select class="form-control" name="caShiId">
									<option value="">===请选择===</option>
									<c:forEach items="${shiList }" var="shi" >
										<option value="${shi.caId }" ${goods.caShiId==shi.caId?"selected":"" } class="ops">${shi.caName}</option>
									</c:forEach>
								</select>
								<div class="input-group-addon">
									市
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 col-md-2">具体地址:</label>
						<div class="col-md-6 col-sm-6">
							<textarea class="form-control" cols="3" name="goodsChandi" placeholder="请输入具体地址">${goods.goodsChandi }</textarea>
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
		$("form[name='infoForm']").attr("action","<%=ctx%>/goods/save.action");
		$("form").submit();
	}
	
	function goBack(){
		history.go(-1);
	}
	function getCityByShengId(id){
		var url ="<%=request.getContextPath()%>/goods/queryShiList.action";
		var data ={"id":id};
		$.post(url ,data,function(msg){
			console.log(msg);
			if (msg.length>0) {
				$(".ops").remove();
				for (var i = 0; i < msg.length; i++) {
 					$("select[name='caShiId']").append("<option class='ops' value="+msg[i].caId+">"+msg[i].caName+"</option>");
				}
			}
		},"json");
	}
	
</script>