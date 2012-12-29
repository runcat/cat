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

import net.noday.cat.model.Nav;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * cat NavDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-29
 * @since 
 */
@Repository
public class NavDao {

	@Autowired private JdbcTemplate jdbc;
	@Autowired private NamedParameterJdbcTemplate namedJdbc;
	
	public long save(Nav obj) {
		String sql = "insert into nav(name,url,rank,pid)" +
				" values(:name,:url,:rank,:pid)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJdbc.update(sql, new BeanPropertySqlParameterSource(obj), keyHolder);
        return keyHolder.getKey().longValue();
	}
	
	public void update(Nav obj) {
		String sql = "update nav set name=?,url=?,rank=?,pid=? where id=?";
		jdbc.update(sql, obj.getName(), obj.getUrl(), obj.getRank(), obj.getPid(), obj.getId());
	}
	
	public Nav get(Long id) {
		String sql = "select * from nav a where a.id=?";
		Nav a = jdbc.queryForObject(sql, new BeanPropertyRowMapper<Nav>(Nav.class), id);
		return a;
	}
	
	public void delete(Long id) {
		String sql = "delete from nav where id=?";
		jdbc.update(sql, id);
		// TODO 同时删除下级
	}
	
	public List<Nav> findAll() {
		String sql = "select * from nav a order by a.pid,a.rank";
		List<Nav> list = jdbc.query(sql, new BeanPropertyRowMapper<Nav>(Nav.class));
		return list;
	}
	
	public List<Nav> findByPid(Long pid) {
		String sql = "select * from nav a where a.pid=? order by a.pid,a.rank";
		List<Nav> list = jdbc.query(sql, new BeanPropertyRowMapper<Nav>(Nav.class), pid);
		return list;
	}
	
//	public List<Nav> findByPage(int index, int size) {
//		String sql = "select * from nav a order by rank desc limit ?,?";
//		List<Nav> list = jdbc.query(sql, new BeanPropertyRowMapper<Nav>(Nav.class), (index-1)*size, size);
//		return list;
//	}
//	
//	public int findCount() {
//		String sql = "select count(a.id) from nav a";
//		int count = jdbc.queryForInt(sql);
//		return count;
//	}
}
