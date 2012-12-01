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
				<form id="article-form" action="${contextPath}/admin/article.json" method="post">
					<label class="control-label" for="title">标题</label>
					<input type="text" name="title" placeholder="文章标题" value='${(article.title)!""}' class="span9">
					<span id="msg-title" class="help-block"></span>
					<label class="control-label" for="content">内容</label>
					<textarea name="content" placeholder="你想说的东西" rows="20" class="span9">${(article.content)!""}</textarea>
					<span id="msg-content" class="help-block"></span>
					<label class="control-label" for="captcha">标签</label>
					<input type="text" name="tag" placeholder="随便" class="span9">
					<span id="msg-tag" class="help-block"></span>
					<button type="submit" class="btn btn-primary">发布</button>
				</form>
			</section>
			<section>
				<div class="alert"></div>
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
		$(".alert").html("beforeSerialize");
	},
	beforeSubmit:function(formData, jqForm, options) {
		$(".alert").append("<br>beforeSubmit");
	},
	success:function(data) {
		if (data && data.fieldErrorList) {
			for ( var i = 0; i < data.fieldErrorList.length; i++) {
				var error = data.fieldErrorList[i];
				$("#msg-"+error.field).html(error.defaultMessage);
			}
		} else if (data) {

		}
	},
	error:function(jqXHR, textStatus, errorThrown) {
		$(".alert").append("<br>error:"+jqXHR.responseText);
	}
});
</script>
</body>
</html>