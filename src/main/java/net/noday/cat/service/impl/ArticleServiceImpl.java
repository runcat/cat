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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.noday.cat.dao.ArticleDao;
import net.noday.cat.event.ArticleSaveEvent;
import net.noday.cat.model.Article;
import net.noday.cat.service.ArticleService;
import net.noday.cat.service.TagService;
import net.noday.core.model.App;
import net.noday.core.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * cat ArticleService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-25
 * @since 
 */
@Service
public class ArticleServiceImpl implements ApplicationEventPublisherAware, ArticleService {

	@Autowired private ArticleDao dao;
	@Autowired private TagService tagService;
	@Resource private Map<String, Object> appCache;
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#get(long)
	 */
	@Override
	public Article get(long id) {
		return dao.get(id);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#show(long)
	 */
	@Override
	public Article show(long id) {
		dao.updateViewCount(id);
		return dao.get(id);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#save(net.noday.cat.model.Article)
	 */
	@Override
	public long save(Article a) {
		long aid = dao.save(a);
		String tagStr = a.getTags();
		tagService.save(aid, tagStr);
		a.setId(aid);
		if (a.isPub2Rhythm()) {
			publisher.publishEvent(new ArticleSaveEvent(this, a));
		}
		return aid;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#update(net.noday.cat.model.Article)
	 */
	@Override
	public void update(Article a) {
		dao.update(a);
		tagService.update(a.getId(), a.getTags());
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		dao.delete(id);
		tagService.deleteRefByArticleId(id);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#updateTopable(java.lang.Long, boolean)
	 */
	@Override
	public void updateTopable(Long id, boolean topable) {
		dao.updateTopable(id, topable);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#listPage(int)
	 */
	@Override
	public Page<Article> listPage(int index) {
		Page<Article> page = new Page<Article>(index, getCfgs().getListArticles()>0?getCfgs().getListArticles():Page.DEFAULTSIZE);
		page.setRowCount(dao.findCount());
		page.setRows(dao.findByPage(page.getPageIndex(), page.getSize()));
		return page;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#listPage4Tag(int, java.lang.String)
	 */
	@Override
	public Page<Article> listPage4Tag(int index, String tagName) {
		Page<Article> page = new Page<Article>(index, Page.DEFAULTSIZE);
		page.setRowCount(dao.findCount4Tag(tagName));
		page.setRows(dao.findByPage4Tag(page.getPageIndex(), page.getSize(), tagName));
		return page;
	}
	

	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#findMostView(int)
	 */
	@Override
	public List<Article> findMostView(int amount) {
		return dao.findMostView(amount);
	}
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#findRecent(int)
	 */
	@Override
	public List<Article> findRecent(int amount) {
		return dao.findRecent(amount);
	}
	/* (non-Javadoc)
	 * @see net.noday.cat.service.impl.ArticleService#findMostReply(int)
	 */
	@Override
	public List<Article> findMostReply(int amount) {
		return dao.findMostReply(amount);
	}
	
	protected App getCfgs() {
		return (App) appCache.get("cfg");
	}

	private ApplicationEventPublisher publisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
}
