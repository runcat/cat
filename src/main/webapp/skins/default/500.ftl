<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${cfg.webTitle}">
<meta name="keywords" content="${cfg.metaKeywords}"/>
<meta name="description" content="${cfg.metaDescription}"/>
</@head>
</head>
<body>
	<div class="container body-container">
		<#include "header.ftl">
		<div class="row">
			<div class="span12">
				<h1>出错了</h1>
				<p>${msg}</p>
			</div>
		</div>
		<#include "footer.ftl">
	</div>
</body>
</html>