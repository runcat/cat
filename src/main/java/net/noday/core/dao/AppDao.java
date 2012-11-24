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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * cat AppDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
@Repository
public class AppDao {
	
	@Autowired private JdbcTemplate jdbc;
	
	public void initMysql() {
		try {
			jdbc.queryForObject("select a.version from app_config a limit 1", String.class);
		} catch (BadSqlGrammarException e) {
			jdbc.execute("CREATE TABLE `app_config`(`id` int(11) NOT NULL auto_increment,`version` VARCHAR(16),PRIMARY KEY (`id`)) ENGINE=INNODB CHARSET=utf8");
			jdbc.execute("CREATE TABLE `role` (`id` int(11) NOT NULL auto_increment,`name` varchar(30) NOT NULL,`code` varchar(18) NOT NULL,`status` tinyint(1) NOT NULL default '0',PRIMARY KEY  (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8");
			jdbc.execute("insert  into `role`(`id`,`name`,`code`,`status`) values (1,'管理员','admin',2)");
			jdbc.execute("CREATE TABLE `user` (`id` int(11) NOT NULL auto_increment,`email` varchar(32) NOT NULL,`password` varchar(44) NOT NULL,`name` varchar(32) default NULL,`sex` enum('male','female') default NULL,`organization` varchar(100) default NULL,`visits` int(11) NOT NULL default '0',`downloads` int(11) NOT NULL default '0',`regist_time` timestamp NOT NULL default CURRENT_TIMESTAMP,`regist_ip` varchar(32) NOT NULL,`last_time` timestamp NULL default NULL,`last_ip` varchar(32) default NULL,`status` tinyint(4) NOT NULL default '1',`salt` varchar(16) NOT NULL,`role` tinytext NOT NULL,PRIMARY KEY  (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8");
			jdbc.execute("insert  into `user`(`id`,`email`,`password`,`name`,`sex`,`organization`,`visits`,`downloads`,`regist_time`,`regist_ip`,`last_time`,`last_ip`,`status`,`salt`,`role`) values (1,'admin@noday.com','K50paAp6XRU6xMt5VmmQvEVfe33hfgxHDRx1gYYxNTU=',NULL,NULL,NULL,0,0,'2012-11-05 12:28:07','127.0.0.1',NULL,NULL,1,'0VSG15LOUN4=','user')");
			jdbc.execute("CREATE TABLE `user_role` (`user_id` int(11) NOT NULL,`role_id` int(11) NOT NULL,KEY `user_id` (`user_id`),KEY `role_id` (`role_id`),CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8");
			jdbc.execute("insert  into `user_role`(`user_id`,`role_id`) values (1,1)");
		} catch (DataAccessException e) {
			
		}
		
	}
}
