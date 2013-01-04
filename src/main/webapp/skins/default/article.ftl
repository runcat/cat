<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${article.title } - ${cfg.webTitle}">
<meta name="keywords" content="${article.tags}"/>
<meta name="description" content="${article.tags}"/>
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
		            	<!-- 
		            	<li><a><i class="icon-comment"></i>0</a></li>
		            	 -->
		            </ul>
		            <div class="description">${article.content}</div>
		            <#if (article.signName)??&&article.signName!="">
		            <div class="alert alert-error">
		            ${cfg[article.signName]}
		            </div>
		            </#if>
						<ul class="inline small">
							<li>
								<i class="icon-tags"></i>
								<#if article.tags!=null>
								<#list article.tags?split(",") as articleTag>
								<span class="badge badge-tag tag">
								<a href="${contextPath}/tags/${articleTag?url('UTF-8')}">${articleTag}</a>
								</span>
								</#list>
								</#if>
							</li>
						</ul>
						<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare">
							<span class="bds_more">分享到：</span>
							<a class="bds_qzone">QQ空间</a>
							<a class="bds_tsina">新浪微博</a>
							<a class="bds_tqq">腾讯微博</a>
							<a class="bds_renren">人人网</a>
							<a class="bds_t163">网易微博</a>
							<a class="shareCount"></a>
						</div>
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
<!-- Baidu Button BEGIN -->
<script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=19727" ></script>
<script type="text/javascript" id="bdshell_js"></script>
<script type="text/javascript">
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
</script>
<!-- Baidu Button END -->
</body>
</html>