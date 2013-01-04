ALTER TABLE `app_config`   
  ADD COLUMN `sign1` TEXT NULL  COMMENT '签名档1' AFTER `commentable`,
  ADD COLUMN `sign2` TEXT NULL  COMMENT '签名档2' AFTER `sign1`;
ALTER TABLE `article`   
  ADD COLUMN `sign_name` VARCHAR(5) NULL  COMMENT '签名档' AFTER `topable`;
UPDATE app_config SET VERSION='1.1';