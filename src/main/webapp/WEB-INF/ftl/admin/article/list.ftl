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
		<#include "header.ftl">
		<div class="row">
			<div class="span3">
				<#include "admin/side.ftl">
			</div>
			<div class="span9">
				<section class="data-table-grid">
					<legend>文章管理</legend>
					<table class="table table-condensed table-bordered table-striped table-hover">
		              <thead>
		                <tr>
		                  <th colspan="5">
								  <div class="btn-group">
								  	<a class="btn btn-link btn-small">新增</a>
								  	<a class="btn btn-link btn-small">修改</a>
								  	<a class="btn btn-link btn-small">删除</a>
								  </div>
		                  </th>
		                </tr>
		                <tr>
		                  <th>#</th>
		                  <th>标题</th>
		                  <th>访问</th>
		                  <th>时间</th>
		                  <th>操作</th>
		                </tr>
		              </thead>
	              <tbody>
	              	<#list page.rows as row>
	                <tr>
	                  <td></td>
	                  <td>${row.title }</td>
	                  <td>${row.viewCount }</td>
	                  <td>${row.createTime }</td>
	                  <td>
							  	<a class="">修改</a>
							  	<a class="">删除</a>
						  </td>
	                </tr>
	                </#list>
	              </tbody>
	              <tfoot>
	                <tr>
	                  <td colspan="5">
			            	<div class="pagination pagination-small pagination-right">
			            		<ul>
			            			<li><a href="${contextPath}/admin/article/p/1">首页</a></li>
			            			<#if 1 == page.pageIndex>
			            				<li class="disabled"><a>«</a></li>
			            			<#else>
			            				<li><a href="${contextPath}/admin/article/p/${page.pageIndex - 1}">«</a></li>
			            			</#if>
			            			<#list page.pageBegin..page.pageEnd as i>
			            			<#if i == page.pageIndex>
			            				<!-- <li class="active"><a>${i}</a></li> -->
			            				<li class="active"><a><input type="text" value="${i}"></a></li>
			            			<#else>
				            			<li><a href="${contextPath}/admin/article/p/${i}">${i}</a></li>
				            		</#if>
			            			</#list>
			            			<#if page.pageCount == page.pageIndex>
			            				<li class="disabled"><a>»</a></li>
			            			<#else>
			            				<li><a href="${contextPath}/admin/article/p/${page.pageIndex + 1}">»</a></li>
			            			</#if>
			            			<li><a href="${contextPath}/admin/article/p/${page.pageCount}">末页[${page.pageCount}]</a></li>
			            		</ul>
			            	</div>
            			</td>
	                </tr>
	              </tfoot>
	            </table>
				</section>
			</div>
		</div>
		<#include "footer.ftl">
	</div>
<script type="text/javascript">
$("#nav-article-list").addClass("active");
</script>
</body>
</html>