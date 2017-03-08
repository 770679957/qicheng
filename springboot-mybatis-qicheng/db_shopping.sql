/*
 Navicat Premium Data Transfer

 Source Server         : root_123456
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : db_shopping

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 03/09/2017 05:54:33 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_affiche`
-- ----------------------------
DROP TABLE IF EXISTS `tb_affiche`;
CREATE TABLE `tb_affiche` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(10000) COLLATE utf8_bin DEFAULT NULL,
  `issueTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_bigType`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bigType`;
CREATE TABLE `tb_bigType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bigName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `creaTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_goods`
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bigId` int(11) NOT NULL,
  `smallId` int(11) NOT NULL,
  `goodsName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `goodsFrom` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `introduce` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `creaTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `nowPrice` float(9,2) DEFAULT NULL,
  `freePrice` float(9,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `pirture` varchar(10000) COLLATE utf8_bin DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bigId` (`bigId`),
  KEY `smallId` (`smallId`),
  KEY `bigId_2` (`bigId`),
  KEY `smallId_2` (`smallId`),
  KEY `bigId_3` (`bigId`),
  KEY `smallId_3` (`smallId`),
  CONSTRAINT `smallId` FOREIGN KEY (`smallId`) REFERENCES `tb_smallType` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_link`
-- ----------------------------
DROP TABLE IF EXISTS `tb_link`;
CREATE TABLE `tb_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `linkAddress` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_manager`
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sign` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_member`
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `reallyName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `question` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `result` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `profession` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`name`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) DEFAULT NULL,
  `number` varchar(50) COLLATE utf8_bin NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `reallyName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `setMoney` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `post` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `bz` varchar(10000) COLLATE utf8_bin DEFAULT NULL,
  `sign` int(11) DEFAULT NULL,
  `creaTime` datetime DEFAULT NULL,
  PRIMARY KEY (`number`),
  KEY `number` (`number`),
  KEY `name` (`name`),
  KEY `name_2` (`name`),
  KEY `name_3` (`name`),
  KEY `name_4` (`name`),
  KEY `name_5` (`name`),
  CONSTRAINT `FK_name` FOREIGN KEY (`name`) REFERENCES `tb_member` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_orderDetail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderDetail`;
CREATE TABLE `tb_orderDetail` (
  `id` int(11) NOT NULL,
  `orderNumber` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `goodsId` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  KEY `goodsId` (`goodsId`),
  KEY `orderNumber` (`orderNumber`),
  CONSTRAINT `FK1` FOREIGN KEY (`goodsId`) REFERENCES `tb_goods` (`id`),
  CONSTRAINT `FK2` FOREIGN KEY (`orderNumber`) REFERENCES `tb_order` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_smallType`
-- ----------------------------
DROP TABLE IF EXISTS `tb_smallType`;
CREATE TABLE `tb_smallType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bigId` int(11) NOT NULL,
  `smallName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `creaTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `bigId` (`bigId`),
  KEY `bigId_2` (`bigId`),
  KEY `bigId_3` (`bigId`),
  KEY `bigId_4` (`bigId`),
  KEY `bigId_5` (`bigId`),
  KEY `bigId_6` (`bigId`),
  KEY `bigId_7` (`bigId`),
  CONSTRAINT `bigId` FOREIGN KEY (`bigId`) REFERENCES `tb_bigType` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `user_`
-- ----------------------------
DROP TABLE IF EXISTS `user_`;
CREATE TABLE `user_` (
  `username_` varchar(20) COLLATE utf8_bin NOT NULL,
  `password_` varchar(20) COLLATE utf8_bin NOT NULL,
  `id_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nickname_` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_`),
  UNIQUE KEY `username_` (`username_`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
