/*
 * Copyright 2013 the original author or authors.
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

import net.noday.cat.model.Article;
import net.noday.core.pagination.Page;

/**
 * cat ArticleService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-1
 * @since 
 */
public interface ArticleService {

	public abstract Article get(long id);

	/**
	 * 显示文章，会增加阅读量
	 * @param id
	 * @return
	 */
	public abstract Article show(long id);

	public abstract long save(Article a);

	public abstract void update(Article a);

	public abstract void delete(Long id);

	public abstract void updateTopable(Long id, boolean topable);

	public abstract Page<Article> listPage(int index);

	public abstract Page<Article> listPage4Tag(int index, String tagName);

	/**
	 * 浏览量最多
	 * @param amount
	 * @return
	 */
	public abstract List<Article> findMostView(int amount);

	/**
	 * 最新
	 * @param amount
	 * @return
	 */
	public abstract List<Article> findRecent(int amount);

	/**
	 * 回复最多
	 * @param amount
	 * @return
	 */
	public abstract List<Article> findMostReply(int amount);

}