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
			<h4>短网址</h4>
			<p>仅为调用api，方便使用</p>
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
		</div>
		<div class="span3">
			<#include "side.ftl">
		</div>
	</div>
	<#include "footer.ftl">
</div>
<script type="text/javascript" src="${contextPath}/js/form/jquery.form.js"></script>
<script type="text/javascript">
$('#dwz-form').ajaxForm({
	dataType:"json",
	beforeSerialize:function($form, options) {
		$(".btn-primary").attr("disabled", true);
	},
	beforeSubmit:function(formData, jqForm, options) {
	},
	success:function(data) {
		if (data) {
			if (data.result) {
				$("#msg-submit").toggleClass("alert-info").html("成功！短网址是：" + data.data).show();
			} else {
				$("#msg-submit").toggleClass("alert-info").html(data.message).show();
			}
		}
		$(".btn-primary").attr("disabled", false);
	},
	error:function(jqXHR, textStatus, errorThrown) {
		$("#msg-submit").toggleClass("alert-info").html(textStatus+jqXHR.responseText).show();
		$(".btn-primary").attr("disabled", false);
	}
});
</script>
</body>
</html>