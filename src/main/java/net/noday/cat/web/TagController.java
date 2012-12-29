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
package net.noday.cat.web;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.noday.cat.service.ArticleService;
import net.noday.cat.service.TagService;
import net.noday.core.web.BaseController;

/**
 * cat TagController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-25
 * @since 
 */
@Controller @RequestMapping("/tags")
public class TagController extends BaseController {

	@Autowired private TagService service;
	@Autowired private ArticleService articleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model m) {
		m.addAttribute("tags", service.findAll());
		return "tags";
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String show(@PathVariable("name") String name, Model m) {
		return show(name, 1, m);
	}
	
	@RequestMapping(value = "/{name}/{index}", method = RequestMethod.GET)
	public String show(@PathVariable("name") String name, @PathVariable("index") int index, Model m) {
		try {
			name = new String(name.getBytes("iso8859-1"), "utf-8");
			m.addAttribute("tagName", name);
			m.addAttribute(articleService.listPage4Tag(index, name));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "tag-articles";
	}
}
