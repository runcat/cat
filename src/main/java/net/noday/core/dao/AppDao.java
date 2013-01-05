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
package net.noday.core.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.noday.core.exception.AppStartupException;
import net.noday.core.model.App;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

/**
 * cat AppDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
@Repository
public class AppDao {
	
	private static final Logger log = Logger.getLogger(AppDao.class);
	
	@Autowired private JdbcTemplate jdbc;
	
	public void initDB() {
		// TODO 也许要加上数据库类型判断
		executeSql("cat.sql");
	}
	public void updateDB(String version) {
		executeSql("db/update"+version+".sql");
//		throw new AppStartupException("更新数据库脚本还没有呐");
	}
	/**
	 * 执行sql脚本方法
	 * // TODO 应该将此方法提取出来并改变其中的异常类型
	 * @param sqlFilePath
	 */
	private void executeSql(String sqlFilePath) {
		if (sqlFilePath == null) {
			throw new AppStartupException("执行的sql路径["+sqlFilePath+"]不对啊");
		}
		try {
			log.info("加载脚本["+sqlFilePath+"]");
			Resource sqlRes = new ClassPathResource(sqlFilePath);
			EncodedResource encRes = new EncodedResource(sqlRes, "UTF-8");
			String sqls = null;
			sqls = FileCopyUtils.copyToString(encRes.getReader());
			String[] sqlArr = sqls.split(";");
			log.info("开始执行脚本");
			for (String sql : sqlArr) {
				log.info(sql);
				jdbc.execute(sql);
			}
			log.info("执行脚本完成");
		} catch (IOException e) {
			log.error("读取["+sqlFilePath+"]文件失败", e);
			throw new AppStartupException("读取["+sqlFilePath+"]文件失败", e);
		} catch (Exception e) {
			log.error("执行["+sqlFilePath+"]文件失败", e);
			throw new AppStartupException("执行["+sqlFilePath+"]文件失败", e);
		}
	}
	
	public App getAppConfig() {
		List<String> tables = jdbc.queryForList("show tables", String.class);
		Connection conn = DataSourceUtils.getConnection(jdbc.getDataSource());
		try {
			conn.setAutoCommit(false);
			if (tables == null || tables.size() == 0 || !tables.contains("app_config")) {
				initDB();
			} else {
				String version = jdbc.queryForObject("select a.version from app_config a limit 1", String.class);
				if (!"1.3".equalsIgnoreCase(version)) {
					updateDB("1_3");
				}
			}
			conn.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select * from app_config limit 1";
		App cfg = jdbc.queryForObject(sql, new BeanPropertyRowMapper<App>(App.class));
		if (cfg == null) {
			throw new AppStartupException("数据库中的配置没读到");
		}
		return cfg;
	}
	
	public void resetData() {
		executeSql("db/demo.sql");
	}
}
