		<div class="span9 articles">
			<!-- 
        <ul class="breadcrumb"> TODO 面包屑导航
          <li><a href="#">Home</a> <span class="divider">/</span></li>
          <li><a href="#">Library</a> <span class="divider">/</span></li>
          <li class="active">Data</li>
        </ul>
			 -->
		<#list page.rows as row>
		<#if row_index < 3>
        <div class="row-fluid">
          <div class="span3">
            <div class="thumbnail">
              <img src="holder.js/190x140" alt="">
            </div>
          </div>
          <div class="span9 article">
            <h4><a href="#">${row.title }</a></h4>
            <ul class="inline small">
            	<li><i class="icon-user"></i><a>admin</a></li>
            	<li><i class="icon-time"></i><a>${row.createTime }</a></li>
            	<li><a><i class="icon-comment"></i>100</a></li>
            </ul>
            <div>Donec id elit non mi porta gravida at eget metus. Fusce dapibus,Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </div>
				<ul class="inline small">
					<li><i class="icon-tags"></i><a>tag</a></li>
				</ul>
          </div>
        </div>
        <hr>
        <#elseif row_index < 9 >
        	<#if row_index%2==1 >
	        <div class="row-fluid">
	          <div class="span6">
	            <h4>${row.title }</h4>
	            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	            <ul class="inline small">
	            	<li><i class="icon-user"></i><a>admin</a></li>
	            	<li><a><i class="icon-comment"></i>100</a></li>
	            </ul>
	          </div><!--/span-->
	          <#if !row_has_next></div></#if>
	      <#else>
	          <div class="span6">
	            <h4>${row.title }</h4>
	            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	            <p><a class="btn" href="#">View details »</a></p>
	          </div><!--/span-->
	        </div><!--/row-->
        	</#if>
        <#else>
        <#if row_index%3==0>
        <div class="row-fluid">
          <div class="span4">
            <h4>${row.title }</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div><!--/span-->
          <#if !row_has_next></div></#if>
        <#elseif row_index%3==1>
          <div class="span4">
            <h4>${row.title }</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div><!--/span-->
          <#if !row_has_next></div></#if>
        <#else>
          <div class="span4">
            <h4>${row.title }</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div><!--/span-->
        </div><!--/row-->
        </#if>
        </#if>
        </#list>
        <!-- 
        <div class="hero-unit">
          <h1>Hello, world!</h1>
          <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
          <p><a class="btn btn-primary btn-large">Learn more »</a></p>
        </div>
        <div class="row-fluid">
          <div class="span6">
            <h4>Heading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <ul class="inline small">
            	<li><i class="icon-user"></i><a>admin</a></li>
            	<li><a><i class="icon-comment"></i>100</a></li>
            </ul>
          </div>
          <div class="span6">
            <h4>Heading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div>
        </div>
        <div class="row-fluid">
          <div class="span6">
            <h4>Heading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div>
          <div class="span6">
            <h4>Heading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div>
        </div>
        <div class="row-fluid">
          <div class="span4">
            <h4>Heading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div>
          <div class="span4">
            <h4>Heading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div>
          <div class="span4">
            <h4>Heading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details »</a></p>
          </div>
        </div>
         -->
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
       </div>