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
		<div class="span3">
			<#include "admin/side.ftl">
		</div>
		<div class="span9">
			<section>
				<legend>文章发布</legend>
				<form id="article-form" action="${contextPath}/admin/article/${article.id}" method="put">
					<div class="control-group">
					<label class="control-label" for="title">标题</label>
					<input type="text" name="title" placeholder="文章标题" value='${(article.title)!""}' class="span9">
					<span id="msg-title" class="help-block"></span>
					</div>
					<div class="control-group">
					<label class="control-label" for="content">内容</label>
					<textarea name="content" placeholder="你想说的东西" rows="20" class="span9">${(article.content)!""}</textarea>
					<span id="msg-content" class="help-block"></span>
					</div>
					<div class="control-group">
					<label class="control-label" for="captcha">标签</label>
					<input type="text" name="tag" placeholder="随便" class="span9">
					<span id="msg-tag" class="help-block"></span>
					</div>
					<button type="submit" class="btn btn-primary">发布</button><span id="msg-submit" class="help-inline"></span>
				</form>
			</section>
		</div>
	</div>
	<#include "footer.ftl">
</div>
<script type="text/javascript" src="${contextPath}/js/form/jquery.form.js"></script>
<!-- <script type="text/javascript" src="${contextPath}/js/admin.article.add.js"></script> -->
<script type="text/javascript">
$("#nav-article-new").addClass("active");
$('#article-form').ajaxForm({
	dataType:"json",
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

		}
	},
	error:function(jqXHR, textStatus, errorThrown) {
		$("#msg-submit").html(textStatus+jqXHR.responseText);
	}
});
</script>
</body>
</html>