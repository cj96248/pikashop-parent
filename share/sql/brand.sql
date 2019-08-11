/*
SQLyog v10.2 
MySQL - 5.7 : Database - pikashop
*********************************************************************
*/
DROP TABLE IF EXISTS `tb_brand`;

CREATE TABLE `tb_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `logo` varchar(10) DEFAULT NULL COMMENT '品牌首字母',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `tb_brand` */

insert  into `tb_brand`(`id`,`name`,`logo`) values (1,'联想','Lenovo');
insert  into `tb_brand`(`id`,`name`,`logo`) values (2,'华为','Huawei');
insert  into `tb_brand`(`id`,`name`,`logo`) values (3,'三星','Samsung');
insert  into `tb_brand`(`id`,`name`,`logo`) values (4,'小米','XiaoMi');
insert  into `tb_brand`(`id`,`name`,`logo`) values (5,'OPPO','OPPO');
insert  into `tb_brand`(`id`,`name`,`logo`) values (6,'天语','KTouch');
insert  into `tb_brand`(`id`,`name`,`logo`) values (7,'中兴','ZTE');
insert  into `tb_brand`(`id`,`name`,`logo`) values (8,'魅族','Meizu');
insert  into `tb_brand`(`id`,`name`,`logo`) values (9,'苹果','Apple');
insert  into `tb_brand`(`id`,`name`,`logo`) values (10,'VIVO','VIVO');
insert  into `tb_brand`(`id`,`name`,`logo`) values (11,'诺基亚','Nokia');
insert  into `tb_brand`(`id`,`name`,`logo`) values (12,'锤子','Smartisan');
insert  into `tb_brand`(`id`,`name`,`logo`) values (13,'黑莓','BlackBerry');
insert  into `tb_brand`(`id`,`name`,`logo`) values (14,'海尔','Hair');
insert  into `tb_brand`(`id`,`name`,`logo`) values (15,'飞利浦','Fhilips');
insert  into `tb_brand`(`id`,`name`,`logo`) values (16,'一加','Oneplus');
insert  into `tb_brand`(`id`,`name`,`logo`) values (17,'海信','Hisense');
insert  into `tb_brand`(`id`,`name`,`logo`) values (18,'夏普','Sharp');
insert  into `tb_brand`(`id`,`name`,`logo`) values (19,'创维','Skyworth');
insert  into `tb_brand`(`id`,`name`,`logo`) values (20,'东芝','toshiba');
insert  into `tb_brand`(`id`,`name`,`logo`) values (21,'康佳','Konka');
insert  into `tb_brand`(`id`,`name`,`logo`) values (22,'酷派','Coolpad');
