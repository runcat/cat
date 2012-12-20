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

import net.noday.core.model.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * cat SettingsDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-20
 * @since 
 */
@Repository
public class SettingsDao {

	@Autowired private JdbcTemplate jdbc;
	@Autowired private NamedParameterJdbcTemplate namedJdbc;
	private static final String sql1 = "UPDATE app_config a SET a.web_title=?,a.sub_title=?,a.host_url=?" +
			",a.meta_keywords=?,a.meta_description=?,a.board_source=?,a.hidden_source=?";

	public void updateWebInfo(App app) {
		jdbc.update(sql1, app.getWebTitle(), app.getSubTitle(), app.getHostUrl(), app.getMetaKeywords()
				, app.getMetaDescription(), app.getBoardSource(), app.getHiddenSource());
	}
	
	public void updateWebSetting(App app) {
		String sql = "";
		namedJdbc.update(sql, new BeanPropertySqlParameterSource(app));
	}
	
	public void updateWebSkin(App app) {
		
	}
	
	public void updateUserSign(App app) {
		
	}
}
