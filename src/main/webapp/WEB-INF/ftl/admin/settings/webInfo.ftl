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
				<h4>网站信息</h4>
				<form id="webInfo-form" class="form-horizontal" action="${contextPath}/admin/settings/webInfo.json" method="post">
					<div class="control-group">
						<label class="control-label" for="webTitle">网站标题：</label>
						<div class="controls">
						<input type="text" id="webTitle" name="webTitle" value='${cfg.webTitle }'>
						<span id="msg-webTitle" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="subTitle">子标题：</label>
						<div class="controls">
						<input type="text" id="subTitle" name="subTitle" value='${cfg.subTitle }'>
						<span id="msg-subTitle" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="hostUrl">网站网址：</label>
						<div class="controls">
						<input type="text" id="hostUrl" name="hostUrl" value='${cfg.hostUrl }'>
						<span id="msg-hostUrl" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="metaKeywords">Meta Keywords：</label>
						<div class="controls">
						<input type="text" id="metaKeywords" name="metaKeywords" value='${cfg.metaKeywords }'>
						<span id="msg-metaKeywords" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="metaDescription">Meta Description：</label>
						<div class="controls">
						<textarea id="metaDescription" name="metaDescription" rows="4">${cfg.metaDescription }</textarea>
						<span id="msg-metaDescription" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="boardSource">公告：</label>
						<div class="controls">
						<textarea id="boardSource" name="boardSource" rows="5">${cfg.boardSource }</textarea>
						<span id="msg-boardSource" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="hiddenSource">底部隐藏内容：</label>
						<div class="controls">
						<textarea id="hiddenSource" name="hiddenSource" rows="5">${cfg.hiddenSource }</textarea>
						<span id="msg-hiddenSource" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
						<button type="submit" class="btn btn-primary">更改</button>
						<div class="alert alert-info line-alert help-inline" style="display: none;">
				      	<!-- 
				      	<button type="button" class="close" data-dismiss="alert">×</button>
				      	 -->
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
$("#nav-settings-webInfo").addClass("active");
$('#webInfo-form').ajaxForm({
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
					.change(function(){
						$(this).tooltip("destroy").unbind();
						$(this).parent().parent().removeClass("error");
					})
					.parent().parent().addClass("error");
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
		$("#msg-submit").html(textStatus+jqXHR.responseText).parent().show();
	}
});
</script>
</body>
</html>