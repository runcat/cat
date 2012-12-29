<section>
	<div class="page-header">
		<h5>管理后台</h5>
		<p>
		<@shiro.hasPermission name="oper">
		<a href="${contextPath}/admin/dev/resetData">reset</a>
		</@shiro.hasPermission>
		</p>
	</div>
</section>