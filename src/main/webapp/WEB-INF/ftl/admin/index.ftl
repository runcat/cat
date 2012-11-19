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
			<div class="span3">
				<#include "/WEB-INF/ftl/admin/side.ftl">
			</div>
			<div class="span9">
				<#include "/WEB-INF/ftl/admin/content.ftl">
			</div>
		</div>
		<#include "/WEB-INF/ftl/footer.ftl">
	</div>
</body>
</html>