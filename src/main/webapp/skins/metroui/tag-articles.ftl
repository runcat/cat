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
			<div class="span9">
			<blockquote>
			  <p>标签：${tagName}</p>
			</blockquote>
			<#if 0 != page.rows?size>
			<#list page.rows as row>
			<div class="media article">
				<div class="media-body">
					<h4 class="media-heading muted"><a href="${contextPath}/articles/${row.id }">${row.title }</a></h4>
	            <ul class="inline small">
	            	<li><i class="icon-time"></i><a>${row.createTime }</a></li>
	            	<li><i class="icon-user"></i><a>noday</a></li>
	            	<li><a><i class="icon-eye-open"></i>${row.viewCount}</a></li>
	            	<li><a><i class="icon-comment"></i>0</a></li>
	            </ul>
	            <div class="description">${row.description}</div>
					<ul class="inline small">
						<li>
							<i class="icon-tags"></i>
							<#if row.tags!=null>
							<#list row.tags?split(",") as articleTag>
							<a href="${contextPath}/tags/${articleTag?url('UTF-8')}">${articleTag}</a><#if articleTag_has_next>, </#if>
							</#list>
							</#if>
						</li>
					</ul>
				</div>
			</div>
	      <hr>
	      </#list>
	        <div class="row">
	        	<div class="pagination pagination-small pagination-centered">
	        		<ul>
	        			<li><a href="${contextPath}/tags/${tagName}">首页</a></li>
	        			<#if 1 == page.pageIndex>
	        				<li class="disabled"><a>«</a></li>
	        			<#else>
	        				<li><a href="${contextPath}/tags/${tagName}/${page.pageIndex - 1}">«</a></li>
	        			</#if>
	        			<#list page.pageBegin..page.pageEnd as i>
	        			<#if i == page.pageIndex>
	        				<li class="active"><a>${i}</a></li>
	        			<#else>
	         			<li><a href="${contextPath}/tags/${tagName}/${i}">${i}</a></li>
	         		</#if>
	        			</#list>
	        			<#if page.pageCount == page.pageIndex>
	        				<li class="disabled"><a>»</a></li>
	        			<#else>
	        				<li><a href="${contextPath}/tags/${tagName}/${page.pageIndex + 1}">»</a></li>
	        			</#if>
	        			<li><a href="${contextPath}/tags/${tagName}/${page.pageCount}">末页[${page.pageCount}]</a></li>
	        		</ul>
	        	</div>
	        </div>
	      </#if>
			</div>
			<div class="span3">
				<#include "side.ftl">
			</div>
		</div>
		<#include "footer.ftl">
	</div>
<script type="text/javascript">
</script>
</body>
</html>