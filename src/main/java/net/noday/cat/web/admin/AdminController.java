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
package net.noday.cat.web.admin;

import net.noday.cat.model.Article;
import net.noday.cat.service.ArticleService;
import net.noday.core.dao.AppDao;
import net.noday.core.web.BaseController;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * cat AdminController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
@Controller @RequestMapping("/admin")
public class AdminController extends BaseController {
	
//	private static final Logger log = Logger.getLogger(AdminController.class);
	
	@Autowired private ArticleService service;
	@Autowired private AppDao appDao;

	@RequestMapping(method = RequestMethod.GET)
	public String main() {
		return "admin/index";
	}
	
	@RequestMapping("dev/gen/article/{count}")
	public String genArticles(@PathVariable("count") int count) {
		for (int i = 0; i < count; i++) {
			Article a = new Article();
			a.setTitle("生产的文章" + i);
			a.setDescription("生成的文章摘要，摘要用于描述文章主题，生产编号：" + i);
			a.setContent("生成的文章内容，内容是文章的具体体现，通常使用大量的文字、图片，并有较好的排版。<br><br><br><br><br><br><br><br><br><br><br><br><br>生产编号：" + i);
			a.setAlias("gen-article-for-dev-" + i);
			a.setAuthorId(1l);
			a.setCover("");
			a.setCategoryId(1l);
			service.save(a);
		}
		return "redirect:/";
	}
	
	@RequestMapping("skins")
	public String reloadSkins(Model m) {
		
		return null;
	}
	
	@RequestMapping("dev/resetData") @RequiresPermissions("oper")
	public String resetData(Model m) {
		appDao.resetData();
		responseResult(m, true);
		return "admin/index";
	}
}
