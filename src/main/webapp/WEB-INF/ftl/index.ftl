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
				<#include "content.ftl">
			</div>
			<div class="span3">
				<#include "side.ftl">
			</div>
		</div>
		<#include "footer.ftl">
	</div>
</body>
</html>