<section>
	<div class="page-header">
		<h5>管理后台</h5>
		<p>
		欢迎使用cat的管理后台，你可以
		<a href="${contextPath}/admin/articles/create">发表新文章</a>
		、<a href="${contextPath}/admin/articles/p/1">管理已发表的文章</a>
		、<a href="${contextPath}/admin/navs/create">增加导航</a>
		、<a href="${contextPath}/admin/navs/p/1">管理导航</a>
		、<a href="${contextPath}/admin/links/create">增加友情链接</a>
		、<a href="${contextPath}/admin/links/p/1">管理友情链接</a>。
		</p>
		<p>
		此外你还可以
		<a href="${contextPath}/admin/settings/webInfo">设置网站的显示信息</a>
		、<a href="${contextPath}/admin/settings/webSetting">网站的配置</a>
		、<a href="${contextPath}/admin/settings/webSkin">网站的皮肤</a>
		以及文章后使用的<a href="${contextPath}/admin/settings/userSign">签名档</a>。
		</p>
		<p>
		另外cat还提供一些小工具，如
		<a href="${contextPath}/admin/tools/dwz">短网址</a>。
		</p>
		<p>
		更多丰富功能正在加紧开发中，相信你会满意。
		</p>
		<p>
		<@shiro.hasPermission name="oper">
		<h5>如果你有超级权限，那么你就可以重置所有内容数据</h5>
		<a href="${contextPath}/admin/dev/resetData">reset</a>
		${(result)!}
		</@shiro.hasPermission>
		</p>
	</div>
</section>