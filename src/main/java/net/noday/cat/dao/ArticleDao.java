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
package net.noday.cat.dao;

import java.util.List;

import net.noday.cat.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * cat ArticleDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-25
 * @since 
 */
@Repository
public class ArticleDao {

	@Autowired private JdbcTemplate jdbc;
	@Autowired private NamedParameterJdbcTemplate namedJdbc;
	
	public long save(Article article) {
		String sql = "insert into article(title,description,content,primary_link) values(:title,:description,:content,:primaryLink)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJdbc.update(sql, new BeanPropertySqlParameterSource(article), keyHolder);
        return keyHolder.getKey().longValue();
	}
	
	public Article get(long id) {
		String sql = "select * from article a where a.id=?";
		Article a = jdbc.queryForObject(sql, new BeanPropertyRowMapper<Article>(Article.class), id);
		return a;
	}
	
	public List<Article> findByPage(int index, int size) {
		String sql = "select * from article a limit ?,?";
		List<Article> list = jdbc.query(sql, new BeanPropertyRowMapper<Article>(Article.class), (index-1)*size, size);
		return list;
	}
	
	public int findCount() {
		String sql = "select count(a.id) from article a";
		int count = jdbc.queryForInt(sql);
		return count;
	}
}
