<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${appTitle}">
<meta name="keywords" content="${metaKeywords}"/>
<meta name="description" content=""/>
</@head>
<style type="text/css">
a.thumbnail.select {
    background-color: #ACCDFD;
}
</style>
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
				<legend>皮肤</legend>
            <ul class="thumbnails skin" style="text-align: center;">
              <#list skins as skinName>
              <li>
                <a class="thumbnail" title="${skinName}">
                  <img alt="${skinName}" src="${contextPath}/skins/${skinName}/preview.png">
                  <span class="muted">${skinName}</span>
                </a>
              </li>
              </#list>
              <li>
                <a class="thumbnail">
                  <img alt="280x160" src="holder.js/280x160">
                  <span class="muted">更多皮肤等待您的加入</span>
                </a>
              </li>
            </ul>
            <input type="button" class="btn" value="重新加载可用皮肤">
			</section>
		</div>
	</div>
	<#include "footer.ftl">
</div>
<script type="text/javascript" src="${contextPath}/js/form/jquery.form.js"></script>
<script type="text/javascript">
$("#nav-settings-webSkin").addClass("active");
$('a[title="${cfg.skin}"]').addClass("select");
$('a[title]').click(function() {
	var $this = $(this);
	if ($this.attr("title") == "${cfg.skin}") {
		return;
	}
	$.ajax({
		url:""
		,type:""
		,data:""
		,dataType:""
		,success:function() {
			
		}
		,error:function() {
			
		}
	});
});
$("section input").click(function() {
	
});
</script>
</body>
</html>