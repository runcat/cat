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

import javax.validation.Valid;

import net.noday.cat.model.Article;
import net.noday.cat.service.ArticleService;
import net.noday.core.web.GeneralController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * cat ArticleController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
@Controller @RequestMapping("/admin/articles")
public class ArticleManager extends GeneralController<Article> {

//	private static final Logger log = Logger.getLogger(ArticleManager.class);
	
	@Autowired private ArticleService service;
	
	@Override
	public String create() {
		return "admin/article/add";
	}
	
	@Override
	public String save(@Valid Article article, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(result.getFieldErrors());
		} else {
			article.setAuthorId(getUser().getId());
			long id = service.save(article);
			responseData(m, id);
		}
		return "admin/article/add-success";
	}

	@Override
	public String delete(@PathVariable("id") long id, Model m) {
		service.delete(id);
		responseResult(m, true);
		return "";
	}
	
	@Override
	public String edit(@PathVariable("id") long id, Model model) {
		model.addAttribute(service.get(id));
		return "admin/article/add";
	}
	
	@Override
	public String modify(@PathVariable("id") long id, @Valid Article article, BindingResult result, Model m) {
		service.update(article);
		responseData(m, id);
		return "admin/article/add-success";
	}
	
	@Override
	public String list(@PathVariable("index") int index, Model model) {
		model.addAttribute(service.listPage(index));
		return "admin/article/list";
	}
	
	@RequestMapping(value = "tops", method = RequestMethod.POST)
	public Model topable(@RequestParam("id") Long id, @RequestParam("topable") boolean topable, Model m) {
		service.updateTopable(id, topable);
		responseResult(m, true);
		return m;
	}
	
}
