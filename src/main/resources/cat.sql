/*
SQLyog v10.2 
MySQL - 5.5.28-log : Database - cat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cat` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cat`;

/*Table structure for table `app_config` */

DROP TABLE IF EXISTS `app_config`;

CREATE TABLE `app_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(16) DEFAULT NULL,
  `web_title` varchar(20) DEFAULT NULL COMMENT '标题',
  `side_new_article_count` tinyint(2) DEFAULT '5' COMMENT '侧边栏最新文章数',
  `side_hot_article_count` tinyint(2) DEFAULT '5' COMMENT '侧边栏最热文章数',
  `side_new_comment_count` tinyint(2) DEFAULT '5' COMMENT '侧边栏最新评论数',
  `side_reply_article_count` tinyint(2) DEFAULT '5' COMMENT '侧边栏回复文章数',
  `side_tag_count` tinyint(2) DEFAULT '15' COMMENT '侧边栏tag数',
  `web_sub_title` varchar(100) DEFAULT NULL COMMENT '子标题',
  `web_host` varchar(50) DEFAULT NULL COMMENT '地址',
  `meta_keywords` varchar(100) DEFAULT NULL COMMENT 'meta keywords',
  `meta_description` varchar(200) DEFAULT NULL COMMENT 'meta description',
  `billboard` text COMMENT '公告',
  `bottom_hide` text COMMENT '底部隐藏-统计代码',
  `skin` varchar(20) DEFAULT 'default' COMMENT '皮肤',
  `registable` tinyint(1) DEFAULT '1' COMMENT '是否开放注册',
  `commentable` tinyint(1) DEFAULT '1' COMMENT '是否开放评论',
  `main_list_count` tinyint(2) DEFAULT '15' COMMENT '首页文章列表文章数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_config` */

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL COMMENT '标题',
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
  PRIMARY KEY (`id`),
  KEY `pk_article_user` (`author_id`),
  CONSTRAINT `pk_article_user` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`title`,`description`,`content`,`alias`,`author_id`,`cover`,`category_id`) values
('欢迎加入noday的网络世界','这是一段简介，简要介绍这篇文章的内容。不需要太长，说个大概就行。而这篇文章就是本系统的介绍，'
,'文章可设置封面图片、别名、url、分类和标签，封面可以用在列表和详细页；别名美化文章的访问链接；url会访问文章的默认访问地址；文章必须且只能选择一个分类，但可以有多个标签。'
,'system-description',1,'',1);

/*Table structure for table `category` */

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

/*Data for the table `category` */
insert into `category`(`id`,`name`,`alias`,`type`,`description`) value 
(1,'默认文章分类','article-category',1,'文章默认分类'),
(2,'默认友链分类','link-category',2,'链接默认分类');

/*Table structure for table `link` */

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '链接名称',
  `url` varchar(100) DEFAULT NULL COMMENT '链接地址',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `category_id` int(11) DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `link` */
insert into `link`(`id`,`name`,`url`,`description`,`category_id`) value 
(1,'noday','http://www.noday.net','作者的博客',2);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `code` varchar(18) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`code`,`status`) values (1,'超管','admin',2);

/*Table structure for table `tag` */

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '标签',
  `ref_count` int(11) DEFAULT '0' COMMENT '使用数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tag` */

/*Table structure for table `tag_ref` */

DROP TABLE IF EXISTS `tag_ref`;

CREATE TABLE `tag_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '类型1文章',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tag_ref` */

/*Table structure for table `user` */

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`password`,`name`,`sex`,`organization`,`visits`,`downloads`,`regist_time`,`regist_ip`,`last_time`,`last_ip`,`status`,`salt`,`role`) values (1,'admin@noday.net','K50paAp6XRU6xMt5VmmQvEVfe33hfgxHDRx1gYYxNTU=',NULL,NULL,NULL,0,0,'2012-11-05 12:28:07','127.0.0.1',NULL,NULL,1,'0VSG15LOUN4=','admin');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
