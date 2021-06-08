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
  `id` varchar(255) NOT NULL,
  `contact_description` varchar(255) DEFAULT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_mobile` varchar(255) DEFAULT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_status` int DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `contact_details` */

insert  into `contact_details`(`id`,`contact_description`,`contact_email`,`contact_mobile`,`contact_name`,`contact_status`,`create_date`) values 
('4028ab6179e62f510179e62f7ed80000','Like to register for a program','Pradeep@gmail.com','9980835293','Pradeep Mascarenhas',1,'2021-06-07 11:15:42.488000'),
('4028ab6179e62f510179e630a6620001','Like to register for a program','Pradeep','9980835293d','Pradeep Mascarenhas',1,'2021-06-07 11:16:58.589000'),
('4028ab6179e632aa0179e6335b8e0000','Like to register for a program','Pradeewp','99808352933','Pradeep Mascarenhas',1,'2021-06-07 11:19:56.008000'),
('4028ab6179e632aa0179e633bfc90001','Like to register for a program','Pradeetp','99808352931','Pradeep Mascarenhas',1,'2021-06-07 11:20:21.677000'),
('4028ab6179e64ad50179e64ba2690000','Like to register for a program','Pradeetpw','','Pradeep Mascarenhas',1,'2021-06-07 11:46:26.978000'),
('4028ab6179e659880179e66573c30000','Like to register for a program','Ramesh.Pai@Yahoo.com','8877887788','Ramesh Pai',1,'2021-06-07 12:14:38.333000');

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
  `ID` varchar(255) NOT NULL,
  `USER_NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL,
  `FAILED_LOGIN_ATTEMPT` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
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
