
/*Table structure for table `tb_seller` */

DROP TABLE IF EXISTS `tb_seller`;

CREATE TABLE `tb_seller` (
  `seller_id` varchar(100) NOT NULL COMMENT '用户ID',
  `name` varchar(80) DEFAULT NULL COMMENT '公司名',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '店铺名称',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `email` varchar(40) DEFAULT NULL COMMENT 'EMAIL',
  `mobile` varchar(11) DEFAULT NULL COMMENT '公司手机',
  `telephone` varchar(50) DEFAULT NULL COMMENT '公司电话',
  `status` varchar(1) DEFAULT '0' COMMENT '状态',
  `address_detail` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `linkman_name` varchar(50) DEFAULT NULL COMMENT '联系人姓名',
  `linkman_qq` varchar(13) DEFAULT NULL COMMENT '联系人QQ',
  `linkman_mobile` varchar(11) DEFAULT NULL COMMENT '联系人电话',
  `linkman_email` varchar(40) DEFAULT NULL COMMENT '联系人EMAIL',
  `license_number` varchar(20) DEFAULT NULL COMMENT '营业执照号',
  `tax_number` varchar(20) DEFAULT NULL COMMENT '税务登记证号',
  `org_number` varchar(20) DEFAULT NULL COMMENT '组织机构代码',
  `address` bigint(20) DEFAULT NULL COMMENT '公司地址',
  `logo_pic` varchar(100) DEFAULT NULL COMMENT '公司LOGO图',
  `brief` varchar(2000) DEFAULT NULL COMMENT '简介',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `legal_person` varchar(40) DEFAULT NULL COMMENT '法定代表人',
  `legal_person_card_id` varchar(25) DEFAULT NULL COMMENT '法定代表人身份证',
  `bank_user` varchar(50) DEFAULT NULL COMMENT '开户行账号名称',
  `bank_name` varchar(100) DEFAULT NULL COMMENT '开户行',
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_seller` */

insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('baidu','百度公司','百度商店','123456',NULL,NULL,'4004004400','1','西二旗小胡同','李彦宏','123456','1390000111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('huawei','华为公司','华为旗舰店','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,'010-0101010','1','西直门',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('itcast','传智播客集团','传智播客','123456',NULL,NULL,'010-88888888','1','北京市昌平区建材城西路金燕龙办公楼',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('itheima','黑马程序员','黑马程序员','123456',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('qiandu','千度公司','千度商店','$2a$10$uXL58WhPW/Nl.fScwezXN.BOm6xbM8TzkTxDYz55NqM5fkWjBvjpy',NULL,NULL,'8008008800','1','西三旗','李倩渡','1231234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('yijia','宜家公司','宜家','$2a$10$48L/s1R4aD1StL.sZF6u1uHGOllesyDkHK8KzWbAIGZplfwKsdwlC',NULL,NULL,'4004004400','1','西直门大街',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
