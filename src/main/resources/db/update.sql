ALTER TABLE `user`   
  ADD COLUMN `duoshuo_id` VARCHAR(32) NULL  COMMENT '多说用户id,用于多说登录' AFTER `role`;