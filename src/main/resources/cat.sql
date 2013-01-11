DROP TABLE IF EXISTS `app_config`;

CREATE TABLE `app_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(16) DEFAULT NULL,
  `web_title` varchar(20) DEFAULT NULL COMMENT '标题',
  `sub_title` varchar(100) DEFAULT NULL COMMENT '子标题',
  `host_url` varchar(50) DEFAULT NULL COMMENT '地址',
  `meta_keywords` varchar(100) DEFAULT NULL COMMENT 'meta keywords',
  `meta_description` varchar(200) DEFAULT NULL COMMENT 'meta description',
  `board_source` text COMMENT '公告',
  `hidden_source` text COMMENT '底部隐藏-统计代码',
  `skin` varchar(20) DEFAULT 'default' COMMENT '皮肤',
  `recent_articles` tinyint(2) DEFAULT '5' COMMENT '侧边栏最新文章数',
  `most_view_articles` tinyint(2) DEFAULT '5' COMMENT '侧边栏浏览最多文章数',
  `most_reply_articles` tinyint(2) DEFAULT '5' COMMENT '侧边栏回复最多文章数',
  `recent_comments` tinyint(2) DEFAULT '5' COMMENT '侧边栏最新评论数',
  `most_used_tags` tinyint(2) DEFAULT '15' COMMENT '侧边栏tag数',
  `list_articles` tinyint(2) DEFAULT '15' COMMENT '首页文章列表文章数',
  `list_style` tinyint(2) DEFAULT '1' COMMENT '首页文章列表样式',
  `registable` tinyint(1) DEFAULT '1' COMMENT '是否开放注册',
  `commentable` tinyint(1) DEFAULT '1' COMMENT '是否开放评论',
  `sign1` TEXT NULL  COMMENT '签名档1',
  `sign2` TEXT NULL  COMMENT '签名档2',
  `rhythm_key` VARCHAR(100) NULL  COMMENT 'rhythm同步key',
  `rhythm_version` VARCHAR(20) NULL  COMMENT 'rhythm同步版本',
  `duoshuo_key` VARCHAR(20) NULL  COMMENT '多说评论域名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `app_config`(`id`,`version`,`web_title`,`sub_title`,`host_url`,`meta_keywords`,`meta_description`,`board_source`,`hidden_source`,`skin`,`recent_articles`,`most_view_articles`,`most_reply_articles`,`recent_comments`,`most_used_tags`,`list_articles`,`registable`,`commentable`) values (1,'1.3','蓄势待发','come on',NULL,NULL,NULL,NULL,NULL,'default',5,5,5,5,15,15,0,1);

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL COMMENT '标题',
  `description` text COMMENT '摘要',
  `content` text COMMENT '内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `alias` varchar(100) DEFAULT NULL COMMENT '别名',
  `url` varchar(100) DEFAULT NULL COMMENT '链接',
  `view_count` int(11) NOT NULL DEFAULT '0' COMMENT '访问数',
  `comment_count` INT(11) DEFAULT 0  NOT NULL  COMMENT '评论数',
  `author_id` int(11) DEFAULT NULL COMMENT '编辑',
  `cover` varchar(100) DEFAULT NULL COMMENT '封面',
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `tags` TINYTEXT NULL  COMMENT '标签',
  `topable` TINYINT(0) NOT NULL DEFAULT 0 COMMENT '置顶',
  `sign_name` VARCHAR(5) NULL  COMMENT '签名档',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `article`(`id`,`title`,`description`,`content`,`alias`,`author_id`,`cover`,`category_id`) values
(1,'欢迎加入noday的网络世界','这是一段简介，简要介绍这篇文章的内容。不需要太长，说个大概就行。而这篇文章就是本系统的介绍，'
,'文章可设置封面图片、别名、url、分类和标签，封面可以用在列表和详细页；别名美化文章的访问链接；url会访问文章的默认访问地址；文章必须且只能选择一个分类，但可以有多个标签。'
,'system-description',1,'',1);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '分类名称',
  `alias` varchar(20) DEFAULT NULL COMMENT '别名',
  `type` tinyint(1) NOT NULL COMMENT '分类类别',
  `url` varchar(100) DEFAULT NULL COMMENT '链接',
  `rank` int(11) NOT NULL DEFAULT '0' COMMENT '次序',
  `description` varchar(100) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `category`(`id`,`name`,`alias`,`type`,`description`) value 
(1,'默认文章分类','article-category',1,'文章默认分类'),
(2,'默认友链分类','link-category',2,'链接默认分类');

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '链接名称',
  `url` varchar(100) DEFAULT NULL COMMENT '链接地址',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `category_id` int(11) DEFAULT NULL COMMENT '分类',
  `rank` TINYINT DEFAULT 0  NOT NULL  COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `link`(`id`,`name`,`url`,`description`,`category_id`) value 
(1,'noday','http://www.noday.net','作者的博客',2);

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `code` varchar(18) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `role`(`id`,`name`,`code`,`status`) values (1,'超管','admin',2);

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '标签',
  `ref_count` int(11) DEFAULT '1' COMMENT '使用数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tag_ref`;

CREATE TABLE `tag_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '类型1文章',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `password` varchar(44) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` enum('male','female') DEFAULT NULL,
  `organization` varchar(100) DEFAULT NULL,
  `visits` int(11) NOT NULL DEFAULT '0',
  `downloads` int(11) NOT NULL DEFAULT '0',
  `regist_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `regist_ip` varchar(32) NOT NULL,
  `last_time` timestamp NULL DEFAULT NULL,
  `last_ip` varchar(32) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `salt` varchar(16) NOT NULL,
  `role` tinytext NOT NULL,
  `duoshuo_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `user`(`id`,`email`,`password`,`name`,`sex`,`organization`,`visits`,`downloads`,`regist_time`,`regist_ip`,`last_time`,`last_ip`,`status`,`salt`,`role`) values (1,'admin@noday.net','K50paAp6XRU6xMt5VmmQvEVfe33hfgxHDRx1gYYxNTU=','noday',NULL,NULL,0,0,'2012-11-05 12:28:07','127.0.0.1',NULL,NULL,1,'0VSG15LOUN4=','admin');

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `user_role`(`user_id`,`role_id`) values (1,1);

CREATE TABLE `nav`(  
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL COMMENT '名称',
  `url` VARCHAR(200) NOT NULL COMMENT '链接地址',
  `rank` TINYINT NOT NULL DEFAULT 0 COMMENT '排序',
  `pid` INT(11) COMMENT '上级id',
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8;

ALTER TABLE `article`  
  ADD CONSTRAINT `pk_article_user` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`);
ALTER TABLE `article`  
  ADD CONSTRAINT `pk_article_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
ALTER TABLE `user_role`  
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `user_role`  
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
  
insert  into `user`(`id`,`email`,`password`,`name`,`sex`,`organization`,`visits`,`downloads`,`regist_time`,`regist_ip`,`last_time`,`last_ip`,`status`,`salt`,`role`,`duoshuo_id`) values (2,'test@noday.net','oQ47tb3jsc5O7FXgwh9c8ooA3wim1ordd7WufSDyL44=','admin',NULL,NULL,0,0,'2012-11-05 12:28:07','127.0.0.1',NULL,NULL,1,'IFzq+C4ZaU4=','admin',NULL);