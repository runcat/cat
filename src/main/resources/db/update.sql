ALTER TABLE `user`   
  ADD COLUMN `duoshuo_id` VARCHAR(32) NULL  COMMENT '多说用户id,用于多说登录' AFTER `role`;
ALTER TABLE `app_config`   
  ADD COLUMN `list_style` TINYINT(2) DEFAULT 1  NULL  COMMENT '文章列表样式' AFTER `list_articles`;
ALTER TABLE `article`   
  ADD COLUMN `topable` TINYINT(0) NOT NULL DEFAULT 0 COMMENT '置顶' AFTER `tags`;

