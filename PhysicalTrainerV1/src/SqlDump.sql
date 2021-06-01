/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.25 : Database - physical_trainer_01
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`physical_trainer_01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `physical_trainer_01`;

/*Table structure for table `contact_details` */

DROP TABLE IF EXISTS `contact_details`;

CREATE TABLE `contact_details` (
  `contact_id` int NOT NULL AUTO_INCREMENT,
  `contact_description` varchar(255) DEFAULT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_mobile` varchar(255) DEFAULT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_status` int DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `contact_details` */

insert  into `contact_details`(`contact_id`,`contact_description`,`contact_email`,`contact_mobile`,`contact_name`,`contact_status`,`create_date`) values 
(1,NULL,NULL,NULL,'Pradeep Mascarenhas',0,NULL),
(2,'Like to register for a program','Pradeep@gmail.com','9980835293','Pradeep Mascarenhas',2,'2017-11-01 00:00:00.000000'),
(3,'Like to register for a program','Pradeep@gmail.com','9980835293','Pradeep Mascarenhas',2,'2017-11-01 00:00:00.000000');

/*Table structure for table `media_details` */

DROP TABLE IF EXISTS `media_details`;

CREATE TABLE `media_details` (
  `MEDIA_ID` int NOT NULL AUTO_INCREMENT,
  `MEDIA_TYPE` int DEFAULT NULL,
  `USER_ID` int DEFAULT NULL,
  `MEDIA_PATH_URL` varchar(100) DEFAULT NULL,
  `MEDIA_VIEW_STATUS` int DEFAULT NULL,
  PRIMARY KEY (`MEDIA_ID`),
  KEY `MEDIA_DETAILS_FK2` (`MEDIA_TYPE`),
  KEY `MEDIA_DETAILS_FK1` (`USER_ID`),
  CONSTRAINT `MEDIA_DETAILS_FK1` FOREIGN KEY (`USER_ID`) REFERENCES `user_details` (`USER_ID`),
  CONSTRAINT `MEDIA_DETAILS_FK2` FOREIGN KEY (`MEDIA_TYPE`) REFERENCES `media_type_details` (`MEDIA_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `media_details` */

/*Table structure for table `media_type_details` */

DROP TABLE IF EXISTS `media_type_details`;

CREATE TABLE `media_type_details` (
  `MEDIA_TYPE_ID` int NOT NULL AUTO_INCREMENT,
  `MEDIA_TYPE_NAME` varchar(20) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MEDIA_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `media_type_details` */

/*Table structure for table `slot_details` */

DROP TABLE IF EXISTS `slot_details`;

CREATE TABLE `slot_details` (
  `SLOT_ID` int NOT NULL AUTO_INCREMENT,
  `FROM_SLOT_DATE` datetime DEFAULT NULL,
  `TO_SLOT_DATE` datetime DEFAULT NULL,
  `USER_ID` int DEFAULT NULL,
  `SLOT_STATUS` int DEFAULT NULL,
  PRIMARY KEY (`SLOT_ID`),
  KEY `SLOT_DETAILS_FK1` (`USER_ID`),
  CONSTRAINT `SLOT_DETAILS_FK1` FOREIGN KEY (`USER_ID`) REFERENCES `user_details` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `slot_details` */

/*Table structure for table `user_billing_details` */

DROP TABLE IF EXISTS `user_billing_details`;

CREATE TABLE `user_billing_details` (
  `BILL_ID` int NOT NULL,
  `USER_ID` int NOT NULL,
  `LAST_BILL_DATE` datetime DEFAULT NULL,
  `LAST_BILL_AMOUNT` double DEFAULT NULL,
  `NEXT_BILL_DATE` datetime DEFAULT NULL,
  `NEXT_BILL_AMOUNT` double DEFAULT NULL,
  `INVOICE_SENT_STATUS` int DEFAULT NULL,
  `MAIL_SENT_STATUS` int DEFAULT NULL,
  PRIMARY KEY (`BILL_ID`),
  KEY `user_billing_details_fk1` (`USER_ID`),
  CONSTRAINT `user_billing_details_fk1` FOREIGN KEY (`USER_ID`) REFERENCES `user_details` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_billing_details` */

/*Table structure for table `user_credentials` */

DROP TABLE IF EXISTS `user_credentials`;

CREATE TABLE `user_credentials` (
  `USER_ID` int NOT NULL,
  `USER_NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL,
  `FAILED_LOGIN_ATTEMPT` int DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_credentials` */

/*Table structure for table `user_details` */

DROP TABLE IF EXISTS `user_details`;

CREATE TABLE `user_details` (
  `USER_ID` int NOT NULL AUTO_INCREMENT,
  `FULL_NAME` varchar(50) NOT NULL,
  `PHONE_NUMBER` varchar(15) NOT NULL,
  `EMAIL_ID` varchar(30) DEFAULT NULL,
  `IS_ACTIVE` int DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `ACTIVATION_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_details` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
