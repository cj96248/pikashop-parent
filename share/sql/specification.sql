/*Table structure for table `tb_specification` */

DROP TABLE IF EXISTS `tb_specification`;

CREATE TABLE `tb_specification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spec_name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `tb_specification` */

insert  into `tb_specification`(`id`,`spec_name`) values (26,'尺码');
insert  into `tb_specification`(`id`,`spec_name`) values (27,'网络');
insert  into `tb_specification`(`id`,`spec_name`) values (28,'手机屏幕尺寸');
insert  into `tb_specification`(`id`,`spec_name`) values (32,'机身内存');
insert  into `tb_specification`(`id`,`spec_name`) values (33,'电视屏幕尺寸');

/*Table structure for table `tb_specification_option` */

DROP TABLE IF EXISTS `tb_specification_option`;

CREATE TABLE `tb_specification_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规格项ID',
  `option_name` varchar(200) DEFAULT NULL COMMENT '规格项名称',
  `spec_id` bigint(30) DEFAULT NULL COMMENT '规格ID',
  `orders` int(11) DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

/*Data for the table `tb_specification_option` */

insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (91,'165',26,1);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (92,'170',26,2);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (93,'175',26,3);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (97,'180',26,4);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (98,'移动3G',27,1);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (99,'移动4G',27,2);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (100,'联通3G',27,3);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (101,'联通4G',27,4);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (108,'4.5寸',28,1);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (109,'5寸',28,2);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (110,'5.5寸',28,3);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (111,'6寸',28,4);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (112,'电信3G',27,5);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (113,'电信4G',27,6);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (114,'移动2G',27,7);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (115,'联通2G',27,8);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (116,'电信2G',27,9);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (117,'双卡',27,10);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (118,'16G',32,1);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (119,'32G',32,2);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (120,'64G',32,3);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (121,'128G',32,4);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (122,'40英寸',33,1);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (123,'41英寸',33,2);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (124,'42英寸',33,3);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (125,'43英寸',33,4);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (126,'44英寸',33,5);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (127,'45英寸',33,6);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (128,'48英寸',33,7);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (129,'50英寸',33,8);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (130,'51英寸',33,9);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (131,'52英寸',33,10);
insert  into `tb_specification_option`(`id`,`option_name`,`spec_id`,`orders`) values (132,'53英寸',33,11);
