/*Table structure for table `tb_type_template` */

DROP TABLE IF EXISTS `tb_type_template`;

CREATE TABLE `tb_type_template` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL COMMENT '模板名称',
  `spec_ids` varchar(1000) DEFAULT NULL COMMENT '关联规格',
  `brand_ids` varchar(1000) DEFAULT NULL COMMENT '关联品牌',
  `custom_attribute_items` varchar(2000) DEFAULT NULL COMMENT '自定义属性',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `tb_type_template` */

insert  into `tb_type_template`(`id`,`name`,`spec_ids`,`brand_ids`,`custom_attribute_items`) values (35,'手机','[{\"id\":27,\"text\":\"网络\"},{\"id\":32,\"text\":\"机身内存\"}]','[{\"id\":1,\"text\":\"联想\"},{\"id\":3,\"text\":\"三星\"},{\"id\":2,\"text\":\"华为\"},{\"id\":5,\"text\":\"OPPO\"},{\"id\":4,\"text\":\"小米\"},{\"id\":9,\"text\":\"苹果\"},{\"id\":8,\"text\":\"魅族\"},{\"id\":6,\"text\":\"360\"},{\"id\":10,\"text\":\"VIVO\"},{\"id\":11,\"text\":\"诺基亚\"},{\"id\":12,\"text\":\"锤子\"}]','[{\"text\":\"内存大小\"},{\"text\":\"颜色\"}]');
insert  into `tb_type_template`(`id`,`name`,`spec_ids`,`brand_ids`,`custom_attribute_items`) values (37,'电视','[{\"id\":33,\"text\":\"电视屏幕尺寸\"}]','[{\"id\":16,\"text\":\"TCL\"},{\"id\":13,\"text\":\"长虹\"},{\"id\":14,\"text\":\"海尔\"},{\"id\":19,\"text\":\"创维\"},{\"id\":21,\"text\":\"康佳\"},{\"id\":18,\"text\":\"夏普\"},{\"id\":17,\"text\":\"海信\"},{\"id\":20,\"text\":\"东芝\"},{\"id\":15,\"text\":\"飞利浦\"},{\"id\":22,\"text\":\"LG\"}]','[]');
