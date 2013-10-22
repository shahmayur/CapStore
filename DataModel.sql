/*
SQLyog Enterprise - MySQL GUI v8.2 
MySQL - 5.0.45-community-nt : Database - capstoremymodule
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`capstoremymodule` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `capstoremymodule`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` varchar(255) NOT NULL,
  `category_name` varchar(255) default NULL,
  PRIMARY KEY  (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`category_id`,`category_name`) values ('1','Electronics'),('2','Books');

/*Table structure for table `media` */

DROP TABLE IF EXISTS `media`;

CREATE TABLE `media` (
  `media_id` varchar(255) NOT NULL,
  `media_path` varchar(255) default NULL,
  `media_type` varchar(255) default NULL,
  `product_id` varchar(255) default NULL,
  PRIMARY KEY  (`media_id`),
  KEY `FK46C7FC4ECE16BAD` (`product_id`),
  CONSTRAINT `FK46C7FC4ECE16BAD` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `media` */

insert  into `media`(`media_id`,`media_path`,`media_type`,`product_id`) values ('1','/Albums/Nokia Lumia 720','IMAGE','1'),('2','/Albums/Nokia Lumia 920','IMAGE','2'),('3','/Albums/XBOX','IMAGE','3'),('4','/Albums/PlayStation 4','IMAGE','4'),('5','/Albums/The Alchemist','IMAGE','5');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` varchar(255) NOT NULL,
  `merchant_id` varchar(255) default NULL,
  `product_brand` varchar(255) default NULL,
  `product_cost` float default NULL,
  `product_creationdate` date default NULL,
  `product_name` varchar(255) default NULL,
  `product_solddate` date default NULL,
  `product_tag` varchar(255) default NULL,
  `category_id` varchar(255) default NULL,
  PRIMARY KEY  (`product_id`),
  KEY `FK50C664CFA2AF1F07` (`category_id`),
  CONSTRAINT `FK50C664CFA2AF1F07` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`product_id`,`merchant_id`,`product_brand`,`product_cost`,`product_creationdate`,`product_name`,`product_solddate`,`product_tag`,`category_id`) values ('1','1','NOKIA',20000,'2013-10-10','NOKIA 720',NULL,'mobile,phone,cellphone,smartphone','1'),('2','1','NOKIA',25000,'2013-10-10','NOKIA 920',NULL,'mobile,phone,cellphone,smartphone','1'),('3','1','SONY',25000,'2013-10-10','PlayStation 4',NULL,'console,playstation,PS4,gaming','1'),('4','1','MICROSOFT',25000,'2013-10-10','XBOX',NULL,'console,playstation,PS4,gaming','1'),('5','1','Tata-McGraw',25000,'2013-10-10','The Alchemist',NULL,'book,novel,Alchemist,Paul Coelho','2');

/*Table structure for table `productdescription` */

DROP TABLE IF EXISTS `productdescription`;

CREATE TABLE `productdescription` (
  `desc_id` varchar(255) NOT NULL,
  `attribute_name` varchar(255) default NULL,
  `attribute_value` varchar(255) default NULL,
  `product_id` varchar(255) default NULL,
  PRIMARY KEY  (`desc_id`),
  KEY `FKCDED57CDECE16BAD` (`product_id`),
  CONSTRAINT `FKCDED57CDECE16BAD` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `productdescription` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
