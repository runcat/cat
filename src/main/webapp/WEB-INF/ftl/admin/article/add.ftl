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
				<legend>文章发布</legend>
			<section class="succ-toggle">
				<form id="article-form" action='${contextPath}/admin/articles<#if (article.id)??>/${article.id}</#if>.json' method="post">
					<div class="control-group">
					<label class="control-label" for="title">标题</label>
					<input type="text" name="title" placeholder="文章标题" value='${(article.title)!}' class="span9">
					<span id="msg-title" class="help-block"></span>
					</div>
					<div class="control-group">
					<label class="control-label" for="content">内容</label>
					<textarea id="aeditor" name="content" placeholder="你想说的东西" rows="20" class="span9">${(article.content)!}</textarea>
					<span id="msg-content" class="help-block"></span>
					</div>
					<div class="control-group">
					<textarea name="description" placeholder="文章简要描述" rows="3" class="span9">${(article.description)!}</textarea>
					<span id="msg-description" class="help-block"></span>
					</div>
					<div class="control-group">
					<label class="control-label" for="captcha">标签</label>
					<input type="text" name="tags" placeholder="随便" class="span9" value="${(article.tags)!}">
					<span id="msg-tag" class="help-block"></span>
					</div>
					<button type="submit" class="btn btn-primary">发布</button>
					<div id="msg-submit" class="alert alert-info line-alert help-inline" style="display: none;">
				    </div>
				</form>
			</section>
			<section class="succ-toggle" style="display: none;">
			<h1>更新成功</h1>
			<p>
			<a id="show_article">查看</a>
			<a href="${contextPath}/admin/articles/create">继续添加</a>
			<a id="edit_article">继续编辑</a>
			</p>
			</section>
		</div>
	</div>
	<#include "footer.ftl">
</div>
<script type="text/javascript" src="${contextPath}/js/form/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8" src="${contextPath}/js/kindeditor/kindeditor.js"></script>
<script type="text/javascript" charset="utf-8" src="${contextPath}/js/kindeditor/lang/zh_CN.js"></script>
<!-- <script type="text/javascript" src="${contextPath}/js/admin.article.add.js"></script> -->
<script type="text/javascript">
$("#nav-article-new").addClass("active");
var editor;
KindEditor.ready(function(K) {
        editor = K.create('#aeditor', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			allowFlashUpload: false,
			items : [
				'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'image', 'flash', 'link','code','|','clearhtml','quickformat','source','about']
		});
});
$('#article-form').ajaxForm({
	dataType:"json",
	beforeSerialize:function($form, options) {
	},
	beforeSubmit:function(formData, jqForm, options) {
		formData[1].value = editor.html();
	},
	success:function(data) {
		if (data && data.fieldErrorList) {
			$(".control-group").removeClass("error");
			for ( var i = 0; i < data.fieldErrorList.length; i++) {
				var error = data.fieldErrorList[i];
				if (error.field=="content") {
					$("#msg-submit").html("文章内容"+error.defaultMessage).show();
					/*$('[for="content"]').next().find(".ke-edit")
						.tooltip({title:error.defaultMessage,placement:"left"})
						.tooltip('show')
						.find("iframe").find("html").keypress(function(){//监听不到键盘事件
							$(this).tooltip("destroy").unbind();
							$(this).parent().removeClass("error");
						});
					$('[for="content"]').parent().addClass("error");*/
				} else {
					$('[name="'+error.field+'"]')
						.tooltip({title:error.defaultMessage,placement:"left"})
						.tooltip('show')
						.keypress(function(){
							$(this).tooltip("destroy").unbind();
							$(this).parent().removeClass("error");
						})
						.parent().addClass("error");
				}
				//$("#msg-"+error.field).html(error.defaultMessage).parent().addClass("error");
			}
		} else if (data) {
			if (data.result) {
				$("#msg-submit").html("更新成功").show();
				$("#show_article").attr("href", "${contextPath}/articles/"+data.data);
				$("#edit_article").attr("href", "${contextPath}/admin/articles/"+data.data+"/edit");
				$(".succ-toggle").toggle();
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