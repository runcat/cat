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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.noday.cat.model.Category;

/**
 * cat CategoryDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-24
 * @since 
 */
@Repository
public class CategoryDao {

	@Autowired private JdbcTemplate jdbc;
	@Autowired private NamedParameterJdbcTemplate namedJdbc;
	
	public void save(Category ca) {
		String sql = "";
	}
}
