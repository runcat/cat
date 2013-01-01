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
package net.noday.cat.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import net.noday.cat.dao.CategoryDao;
import net.noday.cat.service.CategoryService;
import net.noday.core.model.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cat CategoryService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-24
 * @since 
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired private CategoryDao dao;
	@Resource private Map<String, Object> appCache;
	
	
	protected App getCfgs() {
		return (App) appCache.get("cfg");
	}
}
