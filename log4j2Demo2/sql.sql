/*
SQLyog Job Agent v12.09 (64 bit) Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 5.5.40 : Database - log4j2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`log4j2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `log4j2`;

/*Table structure for table `cps_sys_log` */

DROP TABLE IF EXISTS `cps_sys_log`;

CREATE TABLE `cps_sys_log` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CLASS` varchar(255) DEFAULT '' COMMENT '类',
  `METHOD` varchar(255) DEFAULT '' COMMENT '方法',
  `THREAD` varchar(255) DEFAULT '' COMMENT '线程',
  `LEVEL` varchar(31) DEFAULT '' COMMENT '日志级别:All < Trace < Debug < Info < Warn < Error < Fatal < OFF',
  `LINE` varchar(4096) DEFAULT '' COMMENT '代码中的行数',
  `MSG` text COMMENT '日志内容',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `IDX_THREAD` (`THREAD`) USING BTREE,
  KEY `IDX_CREATE_TIME` (`CREATE_TIME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='日志记录表';

/*Data for the table `cps_sys_log` */

insert  into `cps_sys_log` values (1,'com.xinlei.log4j2demo2.Log4j2demo2Application','logStarted','main','INFO','org.springframework.boot.StartupInfoLogger.logStarted(StartupInfoLogger.java:61)','Started Log4j2demo2Application in 2.913 seconds (JVM running for 5.467)','2021-07-07 02:22:19'),(2,'org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/]','log','http-nio-8080-exec-2','INFO','org.apache.juli.logging.DirectJDKLog.log(DirectJDKLog.java:173)','Initializing Spring DispatcherServlet \'dispatcherServlet\'','2021-07-07 02:23:13'),(3,'org.springframework.web.servlet.DispatcherServlet','initServletBean','http-nio-8080-exec-2','INFO','org.springframework.web.servlet.FrameworkServlet.initServletBean(FrameworkServlet.java:525)','Initializing Servlet \'dispatcherServlet\'','2021-07-07 02:23:14'),(4,'org.springframework.web.servlet.DispatcherServlet','initServletBean','http-nio-8080-exec-2','INFO','org.springframework.web.servlet.FrameworkServlet.initServletBean(FrameworkServlet.java:525)','Initializing Servlet \'dispatcherServlet\'','2021-07-07 02:23:14'),(5,'org.springframework.web.servlet.DispatcherServlet','initServletBean','http-nio-8080-exec-2','INFO','org.springframework.web.servlet.FrameworkServlet.initServletBean(FrameworkServlet.java:547)','Completed initialization in 10 ms','2021-07-07 02:23:14'),(6,'org.springframework.web.servlet.DispatcherServlet','initServletBean','http-nio-8080-exec-2','INFO','org.springframework.web.servlet.FrameworkServlet.initServletBean(FrameworkServlet.java:547)','Completed initialization in 10 ms','2021-07-07 02:23:14'),(7,'com.xinlei.log4j2demo2.controller.testLog4j2','testLog','http-nio-8080-exec-2','INFO','com.xinlei.log4j2demo2.controller.testLog4j2.testLog(testLog4j2.java:16)','info日志','2021-07-07 02:23:14'),(8,'com.xinlei.log4j2demo2.controller.testLog4j2','testLog','http-nio-8080-exec-2','WARN','com.xinlei.log4j2demo2.controller.testLog4j2.testLog(testLog4j2.java:17)','warn日志','2021-07-07 02:23:14'),(9,'com.xinlei.log4j2demo2.controller.testLog4j2','testLog','http-nio-8080-exec-2','DEBUG','com.xinlei.log4j2demo2.controller.testLog4j2.testLog(testLog4j2.java:18)','debug日志','2021-07-07 02:23:14'),(10,'com.xinlei.log4j2demo2.controller.testLog4j2','testLog','http-nio-8080-exec-2','ERROR','com.xinlei.log4j2demo2.controller.testLog4j2.testLog(testLog4j2.java:19)','error日志','2021-07-07 02:23:14');

