<#include "/WEB-INF/ftl/macro-head.ftl">
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
		<#include "/WEB-INF/ftl/header.ftl">
		<div class="row">
			<div class="span2">
				<#include "/WEB-INF/ftl/admin/side.ftl">
			</div>
			<div class="span10">
				<section class="data-table-grid">
					<table class="table table-condensed table-bordered table-striped table-hover">
	              <thead>
	                <tr>
	                  <th colspan="4">
							  <div class="btn-group">
							  	<a class="btn btn-link btn-small">新增</a>
							  	<a class="btn btn-link btn-small">修改</a>
							  	<a class="btn btn-link btn-small">删除</a>
							  </div>
	                  </th>
	                </tr>
	                <tr>
	                  <th>#</th>
	                  <th>First Name</th>
	                  <th>Last Name</th>
	                  <th>Username</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<#list paging.rows as row>
	                <tr>
	                  <td>${row.id }</td>
	                  <td>${row.email }</td>
	                  <td>${row.name }</td>
	                  <td>
							  	<a class="">修改</a>
							  	<a class="">删除</a>
						  </td>
	                </tr>
	                </#list>
	              </tbody>
	              <tfoot>
	                <tr>
	                  <td colspan="4">
			            	<div class="pagination pagination-right">
			            		<ul>
			            			<li><a href="#">首页</a></li>
			            			<li class="prev disabled"><a href="#">«</a></li>
			            			<li class="active"><a href="#">1</a></li>
			            			<li><a href="#">2</a></li>
			            			<li><a href="#">3</a></li>
			            			<li><a href="#">4</a></li>
			            			<li class="next"><a href="#">»</a></li>
			            			<li><a href="#">末页</a></li>
			            		</ul>
			            	</div>
            			</td>
	                </tr>
	              </tfoot>
	            </table>
				</section>
			</div>
		</div>
		<#include "/WEB-INF/ftl/footer.ftl">
	</div>
<script type="text/javascript">
$("#nav-user").addClass("active");
</script>
</body>
</html>