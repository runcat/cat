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

import net.noday.cat.service.CategoryService;
import net.noday.core.web.BaseController;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * cat CategoryController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-24
 * @since 
 */
@Controller @RequestMapping("/admin/category")
public class CategoryManager extends BaseController {

	private static final Logger log = Logger.getLogger(CategoryManager.class);
	
	@Autowired private CategoryService service;
	
}
