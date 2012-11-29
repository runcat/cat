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
package net.noday.cat.service;

import net.noday.cat.dao.ArticleDao;
import net.noday.cat.model.Article;
import net.noday.core.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cat ArticleService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-25
 * @since 
 */
@Service
public class ArticleService {

	@Autowired private ArticleDao dao;
	
	public long save(Article article) {
		return dao.save(article);
	}
	
	public Page<Article> listPage(int index) {
		Page<Article> page = new Page<Article>(index, Page.DEFAULTSIZE);
		page.setRowCount(dao.findCount());
		page.setRows(dao.findByPage(page.getPageIndex(), page.getSize()));
		return page;
	}
}
