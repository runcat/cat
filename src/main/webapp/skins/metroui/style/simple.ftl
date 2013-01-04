			<!-- 
        <ul class="breadcrumb"> TODO 面包屑导航
          <li><a href="#">Home</a> <span class="divider">/</span></li>
          <li><a href="#">Library</a> <span class="divider">/</span></li>
          <li class="active">Data</li>
        </ul>
			 -->
		<#if 0 != page.rows?size>
		<#list page.rows as row>
		<div class="media article">
			<div class="media-body">
				<h4 class="media-heading muted"><a href="${contextPath}/articles/${row.id }">${row.title }</a></h4>
            <ul class="inline small">
            	<li><i class="icon-time"></i><a>${row.createTime }</a></li>
            	<li><i class="icon-user"></i><a>noday</a></li>
            	<li><a><i class="icon-eye-open"></i>${row.viewCount}</a></li>
            	<li><a><i class="icon-comment"></i>0</a></li>
            </ul>
            <div class="description">${row.description}</div>
				<ul class="inline small">
					<li>
						<i class="icon-tags"></i>
						<#if row.tags!=null>
						<#list row.tags?split(",") as articleTag>
						<span class="badge badge-tag tag">
						<a href="${contextPath}/tags/${articleTag?url('UTF-8')}">${articleTag}</a>
						</span>
						</#list>
						</#if>
					</li>
				</ul>
			</div>
		</div>
      </#list>
        <div class="row">
        	<div class="pagination pagination-small pagination-centered">
        		<ul>
        			<li><a href="${contextPath}">首页</a></li>
        			<#if 1 == page.pageIndex>
        				<li class="disabled"><a>«</a></li>
        			<#else>
        				<li><a href="${contextPath}/p/${page.pageIndex - 1}">«</a></li>
        			</#if>
        			<#list page.pageBegin..page.pageEnd as i>
        			<#if i == page.pageIndex>
        				<!-- TODO 
        				<li class="active"><a><input type="text" value="${i}"></a></li>
        				 -->
        				<li class="active"><a>${i}</a></li>
        			<#else>
         			<li><a href="${contextPath}/p/${i}">${i}</a></li>
         		</#if>
        			</#list>
        			<#if page.pageCount == page.pageIndex>
        				<li class="disabled"><a>»</a></li>
        			<#else>
        				<li><a href="${contextPath}/p/${page.pageIndex + 1}">»</a></li>
        			</#if>
        			<li><a href="${contextPath}/p/${page.pageCount}">末页[${page.pageCount}]</a></li>
        		</ul>
        	</div>
        </div>
      </#if>
