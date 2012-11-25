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
							<form action="${contextPath}/admin/article" method="post">
							    <label class="control-label" for="title">标题</label>
							      <input type="text" name="title" placeholder="文章标题" value='${(article.title)!""}' class="span9">
							      <span class="help-block"></span>
							    <label class="control-label" for="content">内容</label>
							    	<textarea name="content" placeholder="你想说的东西" rows="20" class="span9">${(article.content)!""}</textarea>
							      <span class="help-block"></span>
							    <label class="control-label" for="captcha">标签</label>
							      <input type="text" name="captcha" placeholder="随便" class="span9">
							      <span class="help-block"></span>
							      <button type="submit" class="btn btn-primary">发布</button>
							</form>
				</section>
			</div>
		</div>
		<#include "footer.ftl">
	</div>
<script type="text/javascript">
$("#nav-article").addClass("active");
</script>
</body>
</html>