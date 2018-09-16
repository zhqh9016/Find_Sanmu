DROP TABLE IF EXISTS `hioms_user`;
CREATE TABLE `hioms_user` (
  `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '用户唯一标识',
  `login_name` varchar(32) DEFAULT NULL COMMENT '登录名',
  `pass_word` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `telephone` varchar(32) DEFAULT NULL COMMENT '手机',
  `phone` varchar(32) DEFAULT NULL COMMENT '座机',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `group_id` varchar(64) DEFAULT NULL COMMENT '所属组织',
  `group_name` varchar(64) DEFAULT NULL COMMENT '所属组织名称',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `valid` int(11) DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;