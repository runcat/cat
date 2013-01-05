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
	<#include "admin/header.ftl">
	<div class="row">
		<div class="span3">
			<#include "admin/side.ftl">
		</div>
		<div class="span9">
			<h4>二维码</h4>
			<div class="succ-toggle">
				<form id="dwz-form" action='${contextPath}/admin/tools/dwz.json' method="post">
					<div class="control-group">
					<label class="control-label" for="url">内容</label>
					<input type="text" name="url" placeholder="url、名字…" class="span9">
					<span id="msg-url" class="help-block"></span>
					</div>
					<div class="control-group">
					<label class="control-label" for="content">自定义(可选)</label>
					<div class="input-prepend">
						<div id="qrcode"></div>
						<div id="qrcode"></div>
					</div>
					<span id="msg-content" class="help-block"></span>
					</div>
					<button type="button" class="btn btn-primary">生成</button>
					<div id="msg-submit" class="alert alert-info line-alert help-inline" style="display: none;">
				    </div>
				</form>
			</div>
		</div>
	</div>
	<#include "admin/footer.ftl">
</div>
<script src="${contextPath}/js/jquery.qrcode.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#qrcode').qrcode({width: 188,height: 188,text: window.location.href});
	$("#qrcode").append('<img src="'+$("#qrcode").find("canvas")[0].toDataURL()+'">')
});
$("#nav-tools-dwz").addClass("active");
</script>
</body>
</html>