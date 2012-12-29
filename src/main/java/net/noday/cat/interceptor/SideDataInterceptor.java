/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.noday.cat.interceptor;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.noday.cat.service.ArticleService;
import net.noday.cat.service.LinkService;
import net.noday.cat.service.NavService;
import net.noday.cat.service.TagService;
import net.noday.core.model.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * cat SideDataInterceptor
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-29
 * @since 
 */
public class SideDataInterceptor extends HandlerInterceptorAdapter {


	@SuppressWarnings("unused")
	@Autowired private TagService tagService;
	@Autowired private ArticleService articleService;
	@Autowired private LinkService linkService;
	@Autowired private NavService navService;
	@Resource protected Map<String, Object> appCache;
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String path = request.getServletPath();
		if (modelAndView != null && !path.startsWith("/admin")) {
			modelAndView.addObject("mostViewArticles", articleService.findMostView(getCfgs().getMostViewArticles()));
			modelAndView.addObject("mostReplyArticles", articleService.findMostReply(getCfgs().getMostReplyArticles()));
			modelAndView.addObject("recentArticles", articleService.findRecent(getCfgs().getRecentArticles()));
			modelAndView.addObject("links", linkService.findAll());
			modelAndView.addObject("navs", navService.findAll());
		}
		super.postHandle(request, response, handler, modelAndView);
	}
	protected App getCfgs() {
		return (App) appCache.get("cfg");
	}
}
