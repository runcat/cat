ALTER TABLE `app_config`   
  ADD COLUMN `duoshuo_key` VARCHAR(20) NULL  COMMENT '多说评论域名' AFTER `rhythm_version`;
UPDATE app_config SET VERSION='1.3';