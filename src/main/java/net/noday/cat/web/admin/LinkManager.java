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

import net.noday.cat.model.Link;
import net.noday.cat.service.LinkService;
import net.noday.core.web.GeneralController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * cat LinkManager
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-28
 * @since 
 */
@Controller @RequestMapping("/admin/links")
public class LinkManager extends GeneralController<Link> {

//	private static final Logger log = Logger.getLogger(LinkManager.class);
	
	@Autowired private LinkService service;

	@Override
	public String create() {
		return "admin/link/add";
	}

	@Override
	public String save(@Valid Link obj, BindingResult result, Model m) {
		if (result.hasErrors()) {
			responseValidError(m, result);
		} else {
			long id = service.save(obj);
			responseData(m, id);
		}
		return "admin/link/add-success";
	}

	@Override
	public String delete(@PathVariable("id") long id, Model m) {
		service.delete(id);
		responseResult(m, true);
		return "admin/link/add-success";
	}

	@Override
	public String edit(@PathVariable("id") long id, Model m) {
		m.addAttribute(service.get(id));
		return "admin/link/add";
	}

	@Override
	public String modify(@PathVariable("id") long id, @Valid Link obj, BindingResult result, Model m) {
		if (result.hasErrors()) {
			responseValidError(m, result);
		} else {
			service.update(obj);
			responseData(m, id);
		}
		return "admin/link/add-success";
	}

	@Override
	public String list(@PathVariable("index") int index, Model m) {
		m.addAttribute(service.listPage(index));
		return "admin/link/list";
	}
	
}
