/*
SQLyog v10.2 
MySQL - 5.0.22-community-nt : Database - industrywords
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`industrywords` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `industrywords`;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `code` varchar(18) NOT NULL,
  `status` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`code`,`status`) values (1,'管理员','admin',2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `email` varchar(32) NOT NULL,
  `password` varchar(44) NOT NULL,
  `name` varchar(32) default NULL,
  `sex` enum('male','female') default NULL,
  `organization` varchar(100) default NULL,
  `visits` int(11) NOT NULL default '0',
  `downloads` int(11) NOT NULL default '0',
  `regist_time` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `regist_ip` varchar(32) NOT NULL,
  `last_time` timestamp NULL default NULL,
  `last_ip` varchar(32) default NULL,
  `status` tinyint(4) NOT NULL default '1',
  `salt` varchar(16) NOT NULL,
  `role` tinytext NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`password`,`name`,`sex`,`organization`,`visits`,`downloads`,`regist_time`,`regist_ip`,`last_time`,`last_ip`,`status`,`salt`,`role`) values (1,'admin@noday.com','K50paAp6XRU6xMt5VmmQvEVfe33hfgxHDRx1gYYxNTU=',NULL,NULL,NULL,0,0,'2012-11-05 12:28:07','127.0.0.1',NULL,NULL,1,'0VSG15LOUN4=','user');

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
