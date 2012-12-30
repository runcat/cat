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
			<div class="span9">
				<#if cfg.listStyle==1>
				<#include "style/simple.ftl">
				<#elseif cfg.listStyle==2>
				<#include "style/content.ftl">
				</#if>
			</div>
			<div class="span3">
				<#include "side.ftl">
			</div>
		</div>
		<#include "footer.ftl">
	</div>
<script type="text/javascript">
$("#home").addClass("active");
</script>
</body>
</html>