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
			<section>
				<h4>社会化参数</h4>
				<form id="signs-form" class="form-horizontal" action="${contextPath}/admin/settings/socialSetting.json" method="post">
					<div class="control-group">
						<label class="control-label" for="rhythmKey">B3log Key：</label>
						<div class="controls">
						<input type="text" name="rhythmKey" value="${cfg.rhythmKey }" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="rhythmVersion">B3log Version：</label>
						<div class="controls">
						<input type="text" name="rhythmVersion" value="${cfg.rhythmVersion }" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
						<button type="submit" class="btn btn-primary">更改</button>
						<div class="alert alert-info line-alert help-inline" style="display: none;">
							<span id="msg-submit" class="">
							</span>
				      </div>
						</div>
					</div>
				</form>
			</section>
		</div>
	</div>
	<#include "admin/footer.ftl">
</div>
<script type="text/javascript" src="${contextPath}/js/form/jquery.form.js"></script>
<script type="text/javascript">
$("#nav-settings-socialSetting").addClass("active");
$('#signs-form').ajaxForm({
	//dataType:"json",
	beforeSerialize:function($form, options) {
	},
	beforeSubmit:function(formData, jqForm, options) {
	},
	success:function(data) {
		if (data && data.fieldErrorList) {
			$(".control-group").removeClass("error");
			for ( var i = 0; i < data.fieldErrorList.length; i++) {
				var error = data.fieldErrorList[i];
				$("[name='"+error.field+"']")
					.tooltip({title:error.defaultMessage,placement:"left"})
					.tooltip('show')
					.keypress(function(){
						$(this).tooltip("destroy").unbind();
						$(this).parent().removeClass("error");
					})
					.parent().addClass("error");
				//$("#msg-"+error.field).html(error.defaultMessage).parent().addClass("error");
			}
		} else if (data) {
			if (data.result) {
				// TODO alert有问题，默认点关闭后删除了，下次保存就显示不出来，需要处理一下
				$("#msg-submit").html("更新成功").parent().show();
			} else {
				$("#msg-submit").html(data.message).parent().show();
			}
		}
	},
	error:function(jqXHR, textStatus, errorThrown) {
		$("#msg-submit").html(textStatus+jqXHR.status).parent().show();
	}
});
</script>
</body>
</html>