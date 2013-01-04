ALTER TABLE `app_config`   
  ADD COLUMN `rhythm_key` VARCHAR(100) NULL  COMMENT 'rhythm同步key' AFTER `sign2`;
ALTER TABLE `app_config`   
  ADD COLUMN `rhythm_version` VARCHAR(20) NULL  COMMENT 'rhythm同步版本' AFTER `rhythm_key`;
UPDATE app_config SET VERSION='1.2';