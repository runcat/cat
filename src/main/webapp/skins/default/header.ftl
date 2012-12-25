    <header class="jumbotron subhead" id="overview">
      <div class="row">
        <div class="span6">
          <h1>Noday.net</h1>
          <p>分享…</p>
        </div>
        <!-- 
        <div class="span3">
          <div class="well">
            <h3>Hello, world!</h3>
          </div>
        </div>
        <div class="span3">
            <h3>Hello, world!</h3>
        </div>
         -->
      </div>
      <div class="navbar" id="main-navbar">
        <div class="navbar-inner">
          <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#"></a>
            <div class="nav-collapse">
              <ul class="nav">
                <li class="active"><a href="${contextPath}/"><i class="icon-home"></i>Home</a></li>
                <li><a href="${contextPath}/tags">标签墙</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li class="nav-header">Nav header</li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
              </ul>
              <form class="navbar-search pull-left" action="">
                <input type="text" class="search-query span2" placeholder="Search">
              </form>
              <ul class="nav pull-right">
                <li>
                  <a href="#" rel="tooltip" data-original-title="first tooltip">tooltip</a>
                </li>
                <li class="divider-vertical"></li>
                <!--
                <li>
                  <a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=e88d137fe60a7358b97c1ab403830b1bdbc215456bb039d3" rel="tooltip" title="点击这里给我发消息" class="qq-link">
                    <img border="0" src="http://wpa.qq.com/imgd?IDKEY=e88d137fe60a7358b97c1ab403830b1bdbc215456bb039d3&amp;pic=41" alt="点击发QQ消息" >
                  </a>
                </li>
                -->
                <@shiro.guest>
                <#if cfg.registable>
                <li>
                  <a href="${contextPath}/regist">注册</a>
                </li>
                </#if>
                <li>
                  <a id="loginHref" href="${contextPath}/login">登录</a>
                </li>
                </@shiro.guest>
                <@shiro.user>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="label label-inverse">noday</span><span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="${contextPath}/admin">管理后台</a></li>
                    <li><a href="${contextPath}/logout">退出</a></li>
                    <li class="divider"></li>
                    <li><a href="#">清除本页缓存</a></li>
                    <li><a href="#">清除所有页面缓存</a></li>
                  </ul>
                </li>
                </@shiro.user>
              </ul>
            </div><!-- /.nav-collapse -->
          </div>
        </div><!-- /navbar-inner -->
      </div>
      <div class="alert alert-info line-alert">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>Warning!</strong> Best check yo self, you're not looking too good.
      </div>
    </header>