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
			<br>
			<div class="span8 offset2">
	      	<legend>用户注册</legend>
	      	<div class="page-header">
	      		<br>
	      		<h5>验证邮件已发送到${u.email}，您需要点击邮件中的链接来完成注册</h5>
	      		<br>
		      	<a id="enter_email" class="btn btn-primary" target="_blank" href="#">立即进入邮箱</a>
	      		<br>
	      	</div>
	      	<div class="row">
	      		<h6>没有收到确认邮件，怎么办？</h6>
	      		<p>1.看看是否在邮箱的回收站中、垃圾邮件中</p>
	      		<p>2.确认没有收到，点此<a href="#">重发一封</a></p>
	      		<p>3.也可以试试更换邮箱地址，点击这里<a href="#">更换邮箱</a></p>
	      	</div>
			</div>
		</div>
		<#include "footer.ftl">
	</div>
<script type="text/javascript">
var email = "${u.email}";
if (email) {
	$("#enter_email").attr("href",email.substring(email.indexOf("@"), email.length));
}
</script>
</body>
</html>