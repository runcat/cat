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
	<#include "admin/header.ftl">
	<div class="row">
		<div class="span3">
			<#include "admin/side.ftl">
		</div>
		<div class="span9">
			<section>
				<h4>皮肤</h4>
            <ul class="thumbnails skin" style="text-align: center;">
              <#list cfg.skins as skinName>
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
            <input type="button" class="btn" value="重新加载可用皮肤" style="display: none;">
			</section>
		</div>
	</div>
	<#include "admin/footer.ftl">
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
		url:"${contextPath}/admin/settings/webSkin.json"
		,type:"post"
		,data:{"skin":$this.attr("title")}
		,dataType:"json"
		,success:function(data) {
			if (data.result) {
				$this.addClass("select");
			} else {
				alert(data.message);
			}
		}
		,error:function(jqXHR, textStatus, errorThrown) {
			alert(textStatus+jqXHR.responseText);
		}
	});
});
$("section input").click(function() {
	
});
</script>
</body>
</html>