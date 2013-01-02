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
				<h4>导航管理</h4>
				<div class="data-table-grid">
					<table class="table table-condensed table-bordered table-striped table-hover">
		              <thead>
		                <tr>
		                  <th colspan="5">
								  <div class="btn-group">
								  	<a href="${contextPath}/admin/navs/create" class="btn btn-link btn-small">新增</a>
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
	              	<#list navs as row>
	                <tr>
	                  <td></td>
	                  <td>${row.name }</td>
	                  <td>${row.url }</td>
	                  <td>${row.rank }</td>
	                  <td>
					  	<a title="编辑" class="icon-edit" href="${contextPath}/admin/navs/${row.id }/edit" rel="tooltip"></a>
					  	<a title="删除" data-id="${row.id }" class="delete icon-remove" href="javascript:void(0)" rel="tooltip"></a>
					  </td>
	                </tr>
	                </#list>
	              </tbody>
	            </table>
				</div>
			</div>
		</div>
		<#include "admin/footer.ftl">
	</div>
<script type="text/javascript">
$("#nav-nav-list").addClass("active");
$(".delete").click(function() {
	var rowId = $(this).attr("data-id");
	if (confirm("真的不想要了吗？")) {
		$.ajax({
			url:"${contextPath}/admin/navs/"+rowId+".json"
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
</script>
</body>
</html>