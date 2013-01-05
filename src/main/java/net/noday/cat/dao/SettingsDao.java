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

import net.noday.core.model.AppRhythmSetting;
import net.noday.core.model.AppUserSign;
import net.noday.core.model.AppWebInfo;
import net.noday.core.model.AppWebSetting;

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
	private static final String sql2 = "UPDATE app_config a SET a.list_articles=:listArticles" +
			",a.recent_articles=:recentArticles,a.most_view_articles=:mostViewArticles" +
			",a.most_reply_articles=:mostReplyArticles,a.recent_comments=:recentComments" +
			",a.most_used_tags=:mostUsedTags,a.registable=:registable,a.commentable=:commentable";
	private static final String sql3 = "UPDATE app_config a SET a.skin=?";
	private static final String sql4 = "UPDATE app_config a SET a.sign1=?,a.sign2=?";
	private static final String sql5 = "UPDATE app_config a SET a.rhythm_key=?,a.rhythm_version=?";
	private static final String sql6 = "UPDATE app_config a SET a.duoshuo_key=?";

	public void updateWebInfo(AppWebInfo app) {
		jdbc.update(sql1, app.getWebTitle(), app.getSubTitle(), app.getHostUrl(), app.getMetaKeywords()
				, app.getMetaDescription(), app.getBoardSource(), app.getHiddenSource());
	}
	
	public void updateWebSetting(AppWebSetting app) {
		namedJdbc.update(sql2, new BeanPropertySqlParameterSource(app));
	}
	
	public void updateWebSkin(String skinName) {
		jdbc.update(sql3, skinName);
	}
	
	public void updateUserSign(AppUserSign sign) {
		jdbc.update(sql4, sign.getSign1(), sign.getSign2());
	}
	
	public void modifySocialSetting(AppRhythmSetting obj) {
		jdbc.update(sql5, obj.getRhythmKey(), obj.getRhythmVersion());
	}
	
	public void modifySocialSetting(String obj) {
		jdbc.update(sql6, obj);
	}
}
