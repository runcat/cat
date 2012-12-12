<#include "skins/${skin}/macro-head.ftl">
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
		<#include "skins/${skin}/header.ftl">
		<div class="row">
			<#include "skins/${skin}/content.ftl">
			<div class="span3">
				<#include "skins/${skin}/side.ftl">
			</div>
		</div>
		<#include "skins/${skin}/footer.ftl">
	</div>
</body>
</html>