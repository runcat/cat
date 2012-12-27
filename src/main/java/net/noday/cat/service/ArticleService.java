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

import java.util.List;

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
	@Autowired private TagService tagService;
//	@Resource private Map<String, Object> appCache;
	
	public Article get(long id) {
		return dao.get(id);
	}
	
	/**
	 * 显示文章，会增加阅读量
	 * @param id
	 * @return
	 */
	public Article show(long id) {
		dao.updateViewCount(id);
		return dao.get(id);
	}
	
	public long save(Article article) {
		long aid = dao.save(article);
		String tagStr = article.getTags();
		tagService.save(aid, tagStr);
		return aid;
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	public void updateTopable(Long id, boolean topable) {
		dao.updateTopable(id, topable);
	}
	
	public Page<Article> listPage(int index) {
		Page<Article> page = new Page<Article>(index, Page.DEFAULTSIZE);
		page.setRowCount(dao.findCount());
		page.setRows(dao.findByPage(page.getPageIndex(), page.getSize()));
		return page;
	}
	
	public Page<Article> listPage4Tag(int index, String tagName) {
		Page<Article> page = new Page<Article>(index, Page.DEFAULTSIZE);
		page.setRowCount(dao.findCount4Tag(tagName));
		page.setRows(dao.findByPage4Tag(page.getPageIndex(), page.getSize(), tagName));
		return page;
	}
	

	/**
	 * 浏览量最多
	 * @param amount
	 * @return
	 */
	public List<Article> findMostView(int amount) {
		return dao.findMostView(amount);
	}
	/**
	 * 最新
	 * @param amount
	 * @return
	 */
	public List<Article> findRecent(int amount) {
		return dao.findRecent(amount);
	}
	/**
	 * 回复最多
	 * @param amount
	 * @return
	 */
	public List<Article> findMostReply(int amount) {
		return dao.findMostReply(amount);
	}
}
