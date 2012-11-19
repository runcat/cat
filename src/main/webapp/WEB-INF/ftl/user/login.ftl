<#include "/WEB-INF/ftl/macro-head.ftl">
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
		<#include "/WEB-INF/ftl/header.ftl">
		<div class="row">
			<br>
	      <div class="span8 offset2">
				<form class="form-horizontal" action="${contextPath}/user_login.action" method="post">
					<legend>用户登录</legend>
				  <div class="control-group">
				    <label class="control-label" for="username">邮箱</label>
				    <div class="controls">
				      <input type="text" name="username" placeholder="注册时的邮箱" value="${username}">
				      <span class="help-inline">${shiroLoginFailure}</span>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="password">密码</label>
				    <div class="controls">
				      <input type="password" name="password" placeholder="注册时的密码">
				      <span class="help-inline"></span>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="captcha">验证码</label>
				    <div class="controls">
				      <input type="text" name="captcha" class="span1" placeholder="随便">
				      <img src="${contextPath}/captcha_image.action" class="img-rounded" style="width:60px;height:30px;padding:0 15px;" />
				      <a href="#">换一张吧!</a>
				      <span class="help-inline"></span>
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				      <label class="checkbox">
				        <input type="checkbox" name="rememberMe"> 下次自动登录
				      </label>
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				      <button type="submit" class="btn btn-primary">登录</button>
				      &nbsp;<a href="#">忘记密码？</a>
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				      <h4>没有帐号?去<a href="${contextPath}/user_regPage.action">注册</a></h4>
				    </div>
				  </div>
				</form>
	      </div><!--/span-->
		</div>
		<#include "/WEB-INF/ftl/footer.ftl">
	</div>
<script type="text/javascript">
$(".form-horizontal input").tooltip();
</script>
</body>
</html>