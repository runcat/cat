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
				<h4>网站参数</h4>
				<form id="webSetting-form" class="form-horizontal" action="${contextPath}/admin/settings/webSetting.json" method="post">
					<div class="control-group">
						<label class="control-label" for="listArticles">分页文章数：</label>
						<div class="controls">
						<input type="text" id="listArticles" name="listArticles" value='${cfg.listArticles }'>
						<span id="msg-listArticles" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="recentArticles">最新文章数：</label>
						<div class="controls">
						<input type="text" id="recentArticles" name="recentArticles" value='${cfg.recentArticles }'>
						<span id="msg-recentArticles" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="mostViewArticles">浏览最多文章数：</label>
						<div class="controls">
						<input type="text" id="mostViewArticles" name="mostViewArticles" value='${cfg.mostViewArticles }'>
						<span id="msg-mostViewArticles" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="mostReplyArticles">回复最多文章数：</label>
						<div class="controls">
						<input type="text" id="mostReplyArticles" name="mostReplyArticles" value='${cfg.mostReplyArticles }'>
						<span id="msg-mostReplyArticles" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="recentComments">最新评论数：</label>
						<div class="controls">
						<input type="text" id="recentComments" name="recentComments" value='${cfg.recentComments }'>
						<span id="msg-recentComments" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="mostUsedTags">使用最多标签数：</label>
						<div class="controls">
						<input type="text" id="mostUsedTags" name="mostUsedTags" value='${cfg.mostUsedTags }'>
						<span id="msg-mostUsedTags" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="registable">开放注册：</label>
						<div class="controls">
						<input type="checkbox" id="registable" name="registable" ${cfg.registable?string("checked","") } value='1'>
						<span id="msg-registable" class="help-inline"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="commentable">开放评论：</label>
						<div class="controls">
						<input type="checkbox" id="commentable" name="commentable" ${cfg.commentable?string("checked","") } value='1'>
						<span id="msg-commentable" class="help-inline"></span>
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
$("#nav-settings-webSetting").addClass("active");
$('#webSetting-form').ajaxForm({
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