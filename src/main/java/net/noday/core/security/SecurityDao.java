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
package net.noday.core.security;

import java.util.List;

import net.noday.core.model.User;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * cat SecurityDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-24
 * @since 
 */
@Repository
public class SecurityDao {

	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public long save(User user) {
        String sql = "insert into user(email,password,regist_ip,salt,role) values(:email,:password,:registIp,:salt,:role)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user), keyHolder);
        return keyHolder.getKey().longValue();
	}
	
	public User findUserByLoginName(String email) {
		String sql = "select * from user u where u.email=? limit 1";
		User u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email);
		return u;
	}
	/**
	 * 多说id找用户
	 * @param userId
	 * @return
	 */
	public User findUserByDuoshuo(String userId) {
		String sql = "select * from user u where u.duoshuo_id=? limit 1";
		User u = safeQueryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userId);
		return u;
	}
	
	public List<User> findPage(User condition, int pIndex, int pSize) {
		StringBuffer sql = new StringBuffer("select * from user u where 1=1");
		SqlParameterSource ps = null;
		if (condition != null) {
			ps = new BeanPropertySqlParameterSource(condition);
			sql.append(toConditionSql(condition));
		}
		sql.append(" order by u.regist_time desc")
			.append(" limit ").append((pIndex - 1) * pSize)
			.append(",").append(pSize);
		List<User> list = namedJdbcTemplate.query(sql.toString(), ps, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}
	public int findCount(User condition) {
		StringBuffer sql = new StringBuffer("select count(u.id) from user u where 1=1");
		SqlParameterSource ps = null;
		if (condition != null) {
			ps = new BeanPropertySqlParameterSource(condition);
			sql.append(toConditionSql(condition));
		}
		return namedJdbcTemplate.queryForInt(sql.toString(), ps);
	}
	
	private String toConditionSql(User u) {
		StringBuffer s = new StringBuffer();
		if (StringUtils.isNotBlank(u.getEmail())) {
			s.append(" and u.email like %:email%");
		}
		if (StringUtils.isNotBlank(u.getName())) {
			s.append(" and u.name like %:name%");
		}
		if (u.getSex() != null) {
			s.append(" and u.sex like %:sex%");
		}
		return s.toString();
	}
	
	///---------------------
	private User safeQueryForObject(String sql, RowMapper<User> rowMapper, Object... args) {
		List<User> results = jdbcTemplate.query(sql, args, new RowMapperResultSetExtractor<User>(rowMapper, 1));
		int size = (results != null ? results.size() : 0);
		if (results.size() > 1) {
			throw new IncorrectResultSizeDataAccessException(1, size);
		}
		return results.iterator().next();
	}
}
