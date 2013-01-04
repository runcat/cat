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
				<form class="form-horizontal" action="${contextPath}/regist" method="post">
					<legend>用户注册</legend>
				  <div class="control-group">
				    <label class="control-label" for="inputEmail">邮箱</label>
				    <div class="controls">
				      <input type="text" name="u.email" id="inputEmail" placeholder="网站登录帐号" rel="tooltip" data-placement="right" data-title="您常用的邮箱,通过验证后可用于登录和找回密码" data-trigger="focus">
				      <span class="help-inline"></span>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="inputPassword">密码</label>
				    <div class="controls">
				      <input type="password" name="u.plainPassword" id="inputPassword" placeholder="网站登录密码" rel="tooltip" data-placement="right" data-title="密码长度6-14位，字母区分大小写" data-trigger="focus">
				      <span class="help-inline"></span>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="inputRePassword">确认密码</label>
				    <div class="controls">
				      <input type="password" id="inputRePassword" placeholder="再次输入登录密码">
				      <span class="help-inline"></span>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="gender">性别</label>
				    <div class="controls">
				    	<select name="u.gender">
				    		<option value="male">男</option>
				    		<!-- 
				    		<s:select name="person.gender" listKey="name()"
				    		list="@cn.com.sina.blog.minssh.example.Gender@values()"/>
				    		 -->
				    	</select>
				      <span class="help-inline"></span>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="inputCaptcha">验证码</label>
				    <div class="controls">
				      <input type="password" id="inputCaptcha" class="span1">
				      <img src="img/favicon.ico" class="img-rounded" style="width:60px;height:30px;padding:0 15px;" />
				      <a href="#">换一张吧!</a>
				      <span class="help-inline">怎么也要输入4个字符</span>
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				      <label class="checkbox">
				        <input type="checkbox"> 我已阅读并接受 <a href="#">用户协议</a>
				      </label>
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				    <@shiro.hasPermission name="oper">
				      <button type="submit" class="btn btn-large btn-primary span2">注  册</button>
				    </@shiro.hasPermission>
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				      <h4>已注册?去<a href="${contextPath}/login">登录</a></h4>
				    </div>
				  </div>
				</form>
			</div>
		</div>
		<#include "footer.ftl">
	</div>
<script type="text/javascript">
$(".form-horizontal input").tooltip();
</script>
</body>
</html>