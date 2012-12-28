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

import net.noday.cat.model.Link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * cat LinkDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-28
 * @since 
 */
@Repository
public class LinkDao {

	@Autowired private JdbcTemplate jdbc;
	@Autowired private NamedParameterJdbcTemplate namedJdbc;
	
	public long save(Link l) {
		String sql = "insert into link(name,url,description,category_id)" +
				" values(:name,:url,:description,:categoryId)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJdbc.update(sql, new BeanPropertySqlParameterSource(l), keyHolder);
        return keyHolder.getKey().longValue();
	}
	
	public void update(Link l) {
		String sql = "update link set name=?,url=?,description=? where id=?";
		jdbc.update(sql, l.getName(), l.getUrl(), l.getDescription(), l.getId());
	}
	
	public Link get(Long id) {
		String sql = "select * from link a where a.id=?";
		Link a = jdbc.queryForObject(sql, new BeanPropertyRowMapper<Link>(Link.class), id);
		return a;
	}
	
	public void delete(Long id) {
		String sql = "delete from link where id=?";
		jdbc.update(sql, id);
	}
	
	public List<Link> findByPage(int index, int size) {
		String sql = "select * from link a order by rank desc limit ?,?";
		List<Link> list = jdbc.query(sql, new BeanPropertyRowMapper<Link>(Link.class), (index-1)*size, size);
		return list;
	}
	
	public int findCount() {
		String sql = "select count(a.id) from link a";
		int count = jdbc.queryForInt(sql);
		return count;
	}
	
}
