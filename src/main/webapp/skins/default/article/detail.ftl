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
						<blockquote class="media-heading muted"><h3>${article.title }</h3></blockquote>
		            <ul class="inline small">
		            	<li><i class="icon-time"></i><a>${article.createTime }</a></li>
		            	<li><i class="icon-user"></i><a>noday</a></li>
		            	<li><a><i class="icon-eye-open"></i>${article.viewCount}</a></li>
		            	<li><a><i class="icon-comment"></i>0</a></li>
		            </ul>
		            <div>${article.content}</div>
						<ul class="inline small">
							<li><i class="icon-tags"></i><a>tag</a></li>
						</ul>
					</div>
					<div class="ds-thread" data-thread-key="${article.id }" data-title="${article.title }" 
						data-category="${article.categoryId }" data-author-key="${article.authorId }"></div>
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