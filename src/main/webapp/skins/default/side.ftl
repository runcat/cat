<#--
        <div class="carousel slide">
        	<div class="carousel-inner">
        		<div class="active item">
        			<img alt="" src="holder.js/188x80">
        			<div class="carousel-caption">
                 <h6>First Thumbnail label</h6>
                 <p>ddddd.</p>
               </div>
        		</div>
        		<div class="active item">
        			<img alt="" src="holder.js/188x80">
        			<div class="carousel-caption">
                 <h6>222222</h6>
                 <p>ddddd.</p>
               </div>
        		</div>
        		<div class="active item">
        			<img alt="" src="holder.js/188x80">
        			<div class="carousel-caption">
                 <h6>3333333</h6>
                 <p>ddddd.</p>
               </div>
        		</div>
        	</div>
        	<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        	<a class="carousel-control right" href="#myCarousel" data-slide="next">&lsaquo;</a>
        </div>
        -->
        <#if cfg.boardSource!=null>
        <div class="alert alert-info">
          ${cfg.boardSource }
        </div>
        </#if>
        <div class="well well-side">
	        <ul class="nav nav-list">
	        	<li class="nav-header"><h5>浏览最多文章</h5></li>
	        	<#list mostViewArticles as row>
	        	<li><a href="${contextPath}/articles/${row.id }">${row.title }</a></li>
	        	</#list>
	        	<li class="nav-header"><h5>评论最多文章</h5></li>
	        	<#list mostReplyArticles as row>
	        	<li><a href="${contextPath}/articles/${row.id }">${row.title }</a></li>
	        	</#list>
	        	<li class="nav-header"><h5>最新发布文章</h5></li>
	        	<#list recentArticles as row>
	        	<li><a href="${contextPath}/articles/${row.id }">${row.title }</a></li>
	        	</#list>
	        	<#--
	        	<li class="nav-header">带图</li>
	        	<li>
					<div class="media">
						<a class="pull-left thumbnail">
							<img src="holder.js/35x35" alt="">
						</a>
						<div class="media-body">
							<h6 class="media-heading muted"><a href="#">w文章标题文章标题</a></h6>
			            <div>some to show</div>
						</div>
					</div>
	        	</li>
	        	-->
	        	<li class="nav-header">本页二维码</li>
	        	<li>
			        <div id="qrcode" class="thumbnail">
			        </div>
	        	</li>
	        </ul>
        </div>
        <#if (cfg.duoshuoKey)!""=="">
        <div class="well well-side">
	        <ul class="nav nav-list ds-recent-comments">
	        	<li class="nav-header">最新评论</li>
	        </ul>
        </div>
        </#if>
        <div class="well well-side">
	        <ul class="nav nav-list">
	        	<li class="nav-header">鸣谢</li>
	        	<li>
					<div class="media">
						<a class="thumbnail">
							<img src="http://static.oschina.net/uploads/space/2012/1212/162844_dIZn_179699.gif" alt="">
						</a>
					</div>
	        	</li>
	        	<li>
					<div class="media">
						<a class="thumbnail">
							<img src="http://www.cloudfoundry.cn/images/logo_header_cloudfoundry.png" alt="">
						</a>
					</div>
	        	</li>
	        	<li>
					<div class="media">
						<a class="thumbnail">
							<img src="http://www.oschina.net/img/logo.gif" alt="">
						</a>
					</div>
	        	</li>
	        	<#--
	        	<li>
	        		<ul class="nav nav-pills">
	        			<li class="active">
	        				<a href="#h1" data-toggle="tab">111</a>
	        			</li>
	        			<li class="">
	        				<a href="#h2" data-toggle="tab">222</a>
	        			</li>
	        			<li class="">
	        				<a href="#h3" data-toggle="tab">333</a>
	        			</li>
	        		</ul>
					<div class="tab-content">
	              <div class="tab-pane fade active in" id="h1">
	                <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
	              </div>
	              <div class="tab-pane fade" id="h2">
	                <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
	              </div>
	              <div class="tab-pane fade" id="h3">
	                <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
	              </div>
	            </div>
	        	</li>
	        	-->
	        </ul>
        </div>
<script>if (typeof DUOSHUO !== 'undefined')
        DUOSHUO.RecentComments('.ds-recent-visitors');</script>