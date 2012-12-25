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
				<div class="media article well">
					<div class="media-body">
						<blockquote class="media-heading muted"><h3>标签墙</h3></blockquote>
		            <ul class="inline small">
		            </ul>
		            <div>
		            <#list tags as tag>
		            <span class="label label-warning"><a href="${contextPath}/tags/${tag.name}">${tag.name}</a>[${tag.refCount}]</span>
		            </#list>
		            </div>
						<ul class="inline small">
						</ul>
					</div>
					<div class="ds-thread" data-thread-key="tags" data-title="标签墙"></div>
				</div>
			</div>
			<div class="span3">
				<#include "side.ftl">
			</div>
		</div>
		<#include "footer.ftl">
	</div>
</body>
</html>