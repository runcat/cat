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
			<h4>短网址</h4>
			<div class="succ-toggle">
				<form id="dwz-form" action='${contextPath}/admin/tools/dwz.json' method="post">
					<div class="control-group">
					<label class="control-label" for="url">原网址</label>
					<input type="text" name="url" placeholder="很长很长的url" class="span9">
					<span id="msg-url" class="help-block"></span>
					</div>
					<div class="control-group">
					<label class="control-label" for="content">自定义(可选)</label>
					<div class="input-prepend">
						<span class="add-on">http://dwz.cn/</span>
					   <input type="text" name="alias" placeholder="字母、数字和破折号" class="span2">
					</div>
					<span id="msg-content" class="help-block"></span>
					</div>
					<button type="submit" class="btn btn-primary">生成</button>
					<div id="msg-submit" class="alert alert-info line-alert help-inline" style="display: none;">
				    </div>
				</form>
			</div>
			<div class="succ-toggle" style="display: none;">
			<h1>更新成功</h1>
			<p>
			<a id="show_article">查看</a>
			<a id="edit_article">继续编辑</a>
			</p>
			</div>
		</div>
	</div>
	<#include "admin/footer.ftl">
</div>
<script type="text/javascript" src="${contextPath}/js/form/jquery.form.js"></script>
<script type="text/javascript">
$("#nav-tools-dwz").addClass("active");
$('#dwz-form').ajaxForm({
	dataType:"json",
	beforeSerialize:function($form, options) {
	},
	beforeSubmit:function(formData, jqForm, options) {
	},
	success:function(data) {
		if (data) {
			if (data.result) {
				$("#msg-submit").html("成功！短网址是：" + data.data).show();
			} else {
				$("#msg-submit").html(data.message).show();
			}
		}
	},
	error:function(jqXHR, textStatus, errorThrown) {
		$("#msg-submit").html(textStatus+jqXHR.responseText).show();
	}
});
</script>
</body>
</html>