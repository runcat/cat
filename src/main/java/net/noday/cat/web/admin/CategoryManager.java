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

import net.noday.cat.model.Category;
import net.noday.cat.service.CategoryService;
import net.noday.core.web.GeneralController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * cat CategoryManager
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-24
 * @since 
 */
@Controller @RequestMapping("/admin/category")
public class CategoryManager extends GeneralController<Category> {

//	private static final Logger log = Logger.getLogger(CategoryManager.class);
	
	@Autowired private CategoryService service;

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#create()
	 */
	@Override
	public String create() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#save(java.lang.Object, org.springframework.validation.BindingResult, org.springframework.ui.Model)
	 */
	@Override
	public String save(Category obj, BindingResult result, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#delete(long, org.springframework.ui.Model)
	 */
	@Override
	public String delete(long id, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#edit(long, org.springframework.ui.Model)
	 */
	@Override
	public String edit(long id, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#modify(long, java.lang.Object, org.springframework.validation.BindingResult, org.springframework.ui.Model)
	 */
	@Override
	public String modify(long id, Category obj, BindingResult result, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#list(int, org.springframework.ui.Model)
	 */
	@Override
	public String list(int index, Model m) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
