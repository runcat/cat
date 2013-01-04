<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${cfg.webTitle}">
<meta name="keywords" content="${cfg.metaKeywords}"/>
<meta name="description" content="${cfg.metaDescription}"/>
</@head>
</head>
<body>
	<div class="page">
		<div class="nav-bar">
		    <div class="nav-bar-inner padding10">
		        <span class="pull-menu"></span>
		
		        <a href="/"><span class="element brand">
		            <img class="place-left" src="images/logo32.png" style="height: 20px">
		            Metro UI CSS <small>0.15.8.11</small>
		        </span></a>
		
		        <div class="divider"></div>
		
		        <ul class="menu">
		            <li><a href="/">Home</a></li>
		            <li data-role="dropdown">
		                <a href="#">Scaffolding</a>
		                <ul class="dropdown-menu" style="overflow: hidden; ">
		                    <li><a href="global.php">Global styles</a></li>
		                    <li><a href="layout.php">Layouts and templates</a></li>
		                    <li><a href="grid.php">Grid system</a></li>
		                    <li class="divider"></li>
		                    <li><a href="responsive.php">Responsive design</a>
		                    </li>
		                </ul>
		            </li>
		            <li data-role="dropdown"><a href="#">Base CSS</a>
		                <ul class="dropdown-menu" style="overflow: hidden; ">
		                    <li><a href="typography.php">Typography</a></li>
		                    <li><a href="tables.php">Tables</a></li>
		                    <li><a href="forms.php">Forms</a></li>
		                    <li><a href="buttons.php">Buttons</a></li>
		                    <li><a href="images.php">Images</a></li>
		                    <li class="divider"></li>
		                    <li><a href="icons.php">Icons</a></li>
		                </ul>
		            </li>
		            <li data-role="dropdown"><a href="#">Components</a>
		                <ul class="dropdown-menu" style="overflow: hidden; ">
		                    <li><a href="tiles.php">Tiles</a></li>
		                    <li><a href="menus.php">Menu and Navigation</a></li>
		                    <li><a href="sidebar.php">Sidebar</a></li>
		                    <li><a href="pagecontrol.php">Page control</a></li>
		                    <li><a href="accordion.php">Accordion</a></li>
		                    <li><a href="buttons-set.php">Buttons set</a></li>
		                    <li><a href="rating.php">Rating</a></li>
		                    <li><a href="progress.php">Progress bars</a></li>
		                    <li><a href="carousel.php">Carousel</a></li>
		                    <li><a href="listview.php">List view</a></li>
		                    <li><a href="slider.php">Slider</a></li>
		                    <li class="divider"></li>
		                    <li><a href="notices.php">Notices and Replies</a></li>
		                    <li class="divider"></li>
		                    <li><a href="cards.php">Bonus - Deck of Cards</a></li>
		                </ul>
		            </li>
		
		            <li><a href="https://github.com/olton/Metro-UI-CSS">Source</a></li>
		        </ul>
		
		    </div>
		</div>
	</div>
	<div class="page">
		<div class="page-region">
			<div class="page-region-content">
				<div class="grid">
					<div class="row">
						<div class="span8">
							<ul class="listview image article">
                        <li>
                            <div class="icon">
                                <img src="images/myface.jpg">
                            </div>
                            <div class="data">
                                <h4>This is a my face</h4>
                                <p>
                                    Hi! My name is Sergey Pimenov and i'm author of Metro UI CSS from Kiev, Ukraine.
                                </p>
                                <a href="mailto:sergey@pimenov.com.ua">sergey@pimenov.com.ua</a>


                            </div>
                        </li>
                        <li class="bg-color-red fg-color-white">
                            <div class="icon">
                                <img src="images/1.jpg">
                            </div>
                            <div class="data">
                                <h4 class="fg-color-white">Bear</h4>
                                <p>
                                    Bears are mammals of the family Ursidae. Bears are classified as caniforms, or doglike carnivorans, with the pinnipeds being their closest living relatives.
                                </p>
                            </div>
                        </li>
                        <li class="selected">
                            <div class="icon">
                                <img src="images/myface.jpg">
                            </div>
                            <div class="data">
                                <h4>This is a my face</h4>
                                <div class="static-rating small">
                                    <div class="rating-value" style="width: 100%"></div>
                                </div>
                                <p>
                                    Hi! My name is Sergey Pimenov and i'm author of Metro UI CSS from Kiev, Ukraine.
                                </p>
                                <a href="mailto:sergey@pimenov.com.ua">sergey@pimenov.com.ua</a>
                            </div>
                        </li>
                    </ul>
						</div>
						<div class="span4 bg-color-red">
						1111111111111111111
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="page">
        <div class="nav-bar">
            <div class="nav-bar-inner padding10">
                <span class="element">
                    2012, Metro UI CSS © by <a class="fg-color-white" href="mailto:sergey@pimenov.com.ua">Sergey Pimenov</a>
                </span>
            </div>
        </div>
    </div>
<script type="text/javascript">
</script>
</body>
</html>