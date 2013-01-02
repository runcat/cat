<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${appTitle}">
<meta name="keywords" content="${metaKeywords}"/>
<meta name="description" content=""/>
</@head>
</head>
<body>
	<div class="container body-container">
		<#include "admin/header.ftl">
		<div class="row">
			<div class="span3">
				<#include "admin/side.ftl">
			</div>
			<div class="span9">
				<h4>友链管理</h4>
				<div class="data-table-grid">
					<table class="table table-condensed table-bordered table-striped table-hover">
		              <thead>
		                <tr>
		                  <th colspan="5">
								  <div class="btn-group">
								  	<a href="${contextPath}/admin/links/create" class="btn btn-link btn-small">新增</a>
								  </div>
		                  </th>
		                </tr>
		                <tr>
		                  <th>#</th>
		                  <th>名称</th>
		                  <th>地址</th>
		                  <th>排序号</th>
		                  <th style="width: 40px;">操作</th>
		                </tr>
		              </thead>
	              <tbody>
	              	<#list page.rows as row>
	                <tr>
	                  <td></td>
	                  <td>${row.name }</td>
	                  <td>${row.url }</td>
	                  <td>${row.rank }</td>
	                  <td>
	               <!-- 
					  	<a title="顶部" data-id="${row.id }" class="icon-chevron-up" href="javascript:void(0)" rel="tooltip"></a>
	               <a title="上移" data-id="${row.id }" class="icon-arrow-up" href="javascript:void(0)" rel="tooltip"></a>
					  	<a title="下移" data-id="${row.id }" class="icon-arrow-down" href="javascript:void(0)" rel="tooltip"></a>
					  	<a title="底部" data-id="${row.id }" class="icon-chevron-down" href="javascript:void(0)" rel="tooltip"></a>
	                -->
					  	<a title="编辑" class="icon-edit" href="${contextPath}/admin/links/${row.id }/edit" rel="tooltip"></a>
					  	<a title="删除" data-id="${row.id }" class="delete icon-remove" href="javascript:void(0)" rel="tooltip"></a>
					  </td>
	                </tr>
	                </#list>
	              </tbody>
	              <tfoot>
	                <tr>
	                  <td colspan="5">
			            	<div class="pagination pagination-small pagination-right">
			            		<ul>
			            			<li><a href="${contextPath}/admin/links/p/1">首页</a></li>
			            			<#if 1 == page.pageIndex>
			            				<li class="disabled"><a>«</a></li>
			            			<#else>
			            				<li><a href="${contextPath}/admin/links/p/${page.pageIndex - 1}">«</a></li>
			            			</#if>
			            			<#list page.pageBegin..page.pageEnd as i>
			            			<#if i == page.pageIndex>
			            				<!-- TODO 
			            				<li class="active"><a><input type="text" value="${i}"></a></li>
			            				 -->
			            				<li class="active"><a>${i}</a></li>
			            			<#else>
				            			<li><a href="${contextPath}/admin/links/p/${i}">${i}</a></li>
				            		</#if>
			            			</#list>
			            			<#if page.pageCount == page.pageIndex>
			            				<li class="disabled"><a>»</a></li>
			            			<#else>
			            				<li><a href="${contextPath}/admin/links/p/${page.pageIndex + 1}">»</a></li>
			            			</#if>
			            			<li><a href="${contextPath}/admin/links/p/${page.pageCount}">末页[${page.pageCount}]</a></li>
			            		</ul>
			            	</div>
            			</td>
	                </tr>
	              </tfoot>
	            </table>
				</div>
			</div>
		</div>
		<#include "admin/footer.ftl">
	</div>
<script type="text/javascript">
$("#nav-link-list").addClass("active");
$(".delete").click(function() {
	var rowId = $(this).attr("data-id");
	if (confirm("真的不想要了吗？")) {
		$.ajax({
			url:"${contextPath}/admin/links/"+rowId+".json"
			,type:"DELETE"
			,dataType:"json"
			,error:function(xhr, status, error){}
			,success:function(data) {
				if (data.result) {
					alert("删除成功");
					window.location.reload();
				} else {
					alert(data.message);
				}
			}
		});
	}
});
$(".66666").click(function() {
	var rowId = $(this).attr("data-id");
	if (confirm("置顶?")) {
		topable(true, rowId);
	}
});
$(".77777").click(function() {
	var rowId = $(this).attr("data-id");
	if (confirm("取消置顶吗?")) {
		topable(false, rowId);
	}
});
function topable(topable, rowId) {
	$.ajax({
		url:"${contextPath}/admin/links/tops.json"
		,type:"POST"
		,dataType:"json"
		,data:{"topable":topable,"id":rowId}
		,error:function(xhr, status, error){}
		,success:function(data) {
			if (data.result) {
				alert("操作成功");
				window.location.reload();
			} else {
				alert(data.message);
			}
		}
	});
}
</script>
</body>
</html>