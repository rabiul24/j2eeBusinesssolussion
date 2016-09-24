CREATE DATABASE  IF NOT EXISTS `marketingmanagement` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `marketingmanagement`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: marketingmanagement
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `Address_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Vaillage` varchar(45) DEFAULT NULL,
  `Upazilla` varchar(45) DEFAULT NULL,
  `District` varchar(45) DEFAULT NULL,
  `Post_Code` varchar(45) DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Address_Id`),
  KEY `addEmp_idx` (`Emp_Id`),
  CONSTRAINT `addEmp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Bagura','Bagura Sadar','Rajshahi','90092',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `A_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Emp_Id` int(11) DEFAULT NULL,
  `Emp_Name` varchar(45) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `Present` int(11) DEFAULT NULL,
  `Absent` int(11) DEFAULT NULL,
  `Late` int(11) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`A_Id`),
  KEY `Attend_emp_idx` (`Emp_Id`),
  CONSTRAINT `Attend_emp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_ manager`
--

DROP TABLE IF EXISTS `b_ manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_ manager` (
  `BM_Id` int(11) NOT NULL AUTO_INCREMENT,
  `BM_Name` varchar(45) DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  `Loc_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`BM_Id`),
  KEY `EmpBm_idx` (`Emp_Id`),
  KEY `LocBm_idx` (`Loc_Id`),
  CONSTRAINT `EmpBm` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `LocBm` FOREIGN KEY (`Loc_Id`) REFERENCES `location` (`Loc_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_ manager`
--

LOCK TABLES `b_ manager` WRITE;
/*!40000 ALTER TABLE `b_ manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_ manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `Cat_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cat_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Cat_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctrl_access`
--

DROP TABLE IF EXISTS `ctrl_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctrl_access` (
  `Ctl_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Emp_Id` int(11) DEFAULT NULL,
  `Emp_Name` varchar(45) DEFAULT NULL,
  `User_Id` int(11) DEFAULT NULL,
  `User_Role` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Ctl_Id`),
  KEY `ctrlEmp_idx` (`Emp_Id`),
  KEY `ctrlUser_idx` (`User_Id`),
  CONSTRAINT `ctrlEmp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ctrlUser` FOREIGN KEY (`User_Id`) REFERENCES `login` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctrl_access`
--

LOCK TABLES `ctrl_access` WRITE;
/*!40000 ALTER TABLE `ctrl_access` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctrl_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `Cust_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cust_Name` varchar(45) DEFAULT NULL,
  `Location` varchar(45) DEFAULT NULL,
  `Shop_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Cust_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `D_Id` int(11) NOT NULL AUTO_INCREMENT,
  `D_Name` varchar(45) DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  `Supp_Id` int(11) DEFAULT NULL,
  `Loc_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`D_Id`),
  KEY `drvEmp_idx` (`Emp_Id`),
  KEY `drvLoc_idx` (`Loc_Id`),
  KEY `drvSupp_idx` (`Supp_Id`),
  CONSTRAINT `drvEmp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `drvLoc` FOREIGN KEY (`Loc_Id`) REFERENCES `location` (`Loc_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `drvSupp` FOREIGN KEY (`Supp_Id`) REFERENCES `supplier` (`Supp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `Emp_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Emp_Name` varchar(45) DEFAULT NULL,
  `Eamil` varchar(45) DEFAULT NULL,
  `Mobile` varchar(45) DEFAULT NULL,
  `Desgination` varchar(45) DEFAULT NULL,
  `Hire_Date` date DEFAULT NULL,
  PRIMARY KEY (`Emp_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Rabiul','rabu@gmail.com','01724486878','Manager','2014-02-01'),(2,'Din islam','din@gmail.com','0172458754612','Manager','2015-01-01'),(3,'Farid Ahmed','w3farid@gmail.com','01724486878','BM','2014-09-01');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `Loc_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Loc_Name` varchar(45) DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Loc_Id`),
  KEY `locEmp_idx` (`Emp_Id`),
  CONSTRAINT `locEmp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`User_Id`),
  KEY `LogEmp_idx` (`Emp_Id`),
  CONSTRAINT `LogEmp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `M_Id` int(11) NOT NULL AUTO_INCREMENT,
  `M_Name` varchar(45) DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`M_Id`),
  KEY `manEmp_idx` (`Emp_Id`),
  CONSTRAINT `manEmp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prices`
--

DROP TABLE IF EXISTS `prices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices` (
  `Prices_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Pro_Name` varchar(45) DEFAULT NULL,
  `Pur_Price` double DEFAULT NULL,
  `Sales_Price` double DEFAULT NULL,
  PRIMARY KEY (`Prices_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prices`
--

LOCK TABLES `prices` WRITE;
/*!40000 ALTER TABLE `prices` DISABLE KEYS */;
/*!40000 ALTER TABLE `prices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `Pro_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Pro_Name` varchar(45) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`Pro_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'A',18),(2,'B',0),(3,'C',0),(4,'D',0),(5,'E',0),(6,'F',0),(7,'G',0),(8,'H',0),(9,'I',0),(10,'J',0),(11,'K',0),(12,'L',0),(13,'M',0),(14,'N',0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchases` (
  `Pur_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Pro_Id` int(11) NOT NULL,
  `Pur_Name` varchar(45) NOT NULL,
  `SerialNo` varchar(45) NOT NULL,
  `Purchases_Date` date NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Total_Price` double NOT NULL,
  PRIMARY KEY (`Pur_Id`),
  UNIQUE KEY `SerialNo_UNIQUE` (`SerialNo`),
  KEY `Pro_ID_Emp_idx` (`Pro_Id`),
  CONSTRAINT `Pro_EM_Id_FK` FOREIGN KEY (`Pro_Id`) REFERENCES `product` (`Pro_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases`
--

LOCK TABLES `purchases` WRITE;
/*!40000 ALTER TABLE `purchases` DISABLE KEYS */;
INSERT INTO `purchases` VALUES (11,1,'A','54','2016-09-03',6,8,36),(12,2,'B','45','2016-09-03',4,564,2256),(13,1,'A','33433545','2016-09-04',324,3,972);
/*!40000 ALTER TABLE `purchases` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `marketingmanagement`.`purchases_BEFORE_INSERT` BEFORE INSERT ON `purchases` FOR EACH ROW
BEGIN
update product set stock=stock+new.Quantity where Pro_Id=new.Pro_Id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `marketingmanagement`.`purchases_AFTER_UPDATE` AFTER UPDATE ON `purchases` FOR EACH ROW
BEGIN
	update product set stock=stock+new.Quantity where Pro_Id=new.Pro_Id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ROLE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(10) DEFAULT NULL,
  `CODE` varchar(60) NOT NULL,
  `LABEL` varchar(100) NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  KEY `FK_USROLE` (`USER_ID`),
  CONSTRAINT `FK_USROLE` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `Salary_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Emp_Id` int(11) DEFAULT NULL,
  `Emp_Name` varchar(45) DEFAULT NULL,
  `Basic_Salary` double DEFAULT NULL,
  `Target` double DEFAULT NULL,
  `TaDa` double DEFAULT NULL,
  `Sr_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Salary_Id`),
  KEY `Emp_Salary_idx` (`Emp_Id`),
  KEY `Sr_Id_Salary_idx` (`Sr_Id`),
  CONSTRAINT `Emp_Salary` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Sr_Id_Salary` FOREIGN KEY (`Sr_Id`) REFERENCES `sr` (`Sr_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `Sales_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Pro_Id` int(11) DEFAULT NULL,
  `Pro_Name` varchar(45) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Total` double DEFAULT NULL,
  `Sell_Date` date DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Sales_Id`),
  KEY `Pro_FK_Pro_Id_idx` (`Pro_Id`),
  CONSTRAINT `Pro_FK_Pro_Id` FOREIGN KEY (`Pro_Id`) REFERENCES `product` (`Pro_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sr`
--

DROP TABLE IF EXISTS `sr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sr` (
  `Sr_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Sr_Name` varchar(45) DEFAULT NULL,
  `Loc_Id` int(11) DEFAULT NULL,
  `A_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Sr_Id`),
  KEY `srLoc_idx` (`Loc_Id`),
  KEY `Attendence_Sr_idx` (`A_Id`),
  CONSTRAINT `Attendence_Sr` FOREIGN KEY (`A_Id`) REFERENCES `attendance` (`A_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `srLoc` FOREIGN KEY (`Loc_Id`) REFERENCES `location` (`Loc_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sr`
--

LOCK TABLES `sr` WRITE;
/*!40000 ALTER TABLE `sr` DISABLE KEYS */;
/*!40000 ALTER TABLE `sr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppervisor`
--

DROP TABLE IF EXISTS `suppervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppervisor` (
  `Sup_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Sup_Name` varchar(45) DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  `M_Id` int(11) DEFAULT NULL,
  `Loc_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Sup_Id`),
  KEY `supEmp_idx` (`Emp_Id`),
  KEY `supMan_idx` (`M_Id`),
  KEY `supLoc_idx` (`Loc_Id`),
  CONSTRAINT `supEmp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `supLoc` FOREIGN KEY (`Loc_Id`) REFERENCES `location` (`Loc_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `supMan` FOREIGN KEY (`M_Id`) REFERENCES `manager` (`M_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppervisor`
--

LOCK TABLES `suppervisor` WRITE;
/*!40000 ALTER TABLE `suppervisor` DISABLE KEYS */;
/*!40000 ALTER TABLE `suppervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `Supp_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Supp_Name` varchar(45) DEFAULT NULL,
  `Emp_Id` int(11) DEFAULT NULL,
  `Sup_Id` int(11) DEFAULT NULL,
  `Loc_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Supp_Id`),
  KEY `suppEmp_idx` (`Emp_Id`),
  KEY `suppSup_idx` (`Sup_Id`),
  KEY `suppLoc_idx` (`Loc_Id`),
  CONSTRAINT `suppEmp` FOREIGN KEY (`Emp_Id`) REFERENCES `employee` (`Emp_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `suppLoc` FOREIGN KEY (`Loc_Id`) REFERENCES `location` (`Loc_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `suppSup` FOREIGN KEY (`Sup_Id`) REFERENCES `suppervisor` (`Sup_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(50) NOT NULL,
  `PWD` varchar(100) NOT NULL,
  `ENABLED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'marketingmanagement'
--

--
-- Dumping routines for database 'marketingmanagement'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-03  8:21:35
