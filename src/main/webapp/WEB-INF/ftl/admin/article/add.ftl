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
			<h4>文章发布</h4>
			<div class="succ-toggle">
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
					<label class="control-label" for="tags">标签</label>
					<input type="text" name="tags" placeholder="随便" class="span9" value="${(article.tags)!}">
					<span id="msg-tag" class="help-block"></span>
					</div>
					<div class="control-group">
					<label class="control-label" for="signName">签名档</label>
					<select name="signName">
						<option></option>
						<#--freemarker标签真蛋疼,写到html标签里编辑器报错-->
						<#if ((article.signName)!"")=="sign1">
						<option value="sign1" selected>签名档1</option>
						<#else>
						<option value="sign1">签名档1</option>
						</#if>
						<#if ((article.signName)!"")=="sign2">
						<option value="sign2" selected>签名档2</option>
						<#else>
						<option value="sign2">签名档2</option>
						</#if>
					</select>
					<span id="msg-signName" class="help-block"></span>
					</div>
					<div class="control-group">
					<button type="submit" class="btn btn-primary pull-right">发布</button>
					<#if !(article.id)??>
					<label>
						<input type="checkbox" value="1" name="pub2Rhythm">
						同步到
						<a href="http://symphony.b3log.org/" target="_blank">社区</a>
						<abbr title="同步社区需要1.在设置-网站信息中正确设置“网站地址”。2.发布文章人email和社区注册的email一致。3.同步key与社区中一致。4.同步version设置为b3log的版本。" class="initialism"><i class="icon-question-sign"></i></abbr>
					</label>
					</#if>
					</div>
					<div id="msg-submit" class="alert alert-info line-alert help-inline" style="display: none;">
				   </div>
				</form>
			</div>
			<div class="succ-toggle" style="display: none;">
			<h1>更新成功</h1>
			<p>
			<a id="show_article">查看</a>
			<a href="${contextPath}/admin/articles/create">继续添加</a>
			<a id="edit_article">继续编辑</a>
			</p>
			</div>
		</div>
	</div>
	<#include "admin/footer.ftl">
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