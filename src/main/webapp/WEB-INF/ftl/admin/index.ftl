<#include "admin/macro-head.ftl">
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
				<#include "admin/content.ftl">
			</div>
		</div>
		<#include "admin/footer.ftl">
	</div>
</body>
</html>