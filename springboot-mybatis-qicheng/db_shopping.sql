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

 Date: 03/08/2017 07:12:18 AM
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
--  Records of `tb_affiche`
-- ----------------------------
BEGIN;
INSERT INTO `tb_affiche` VALUES ('2', '1', '2', '2017-03-08 07:08:08'), ('3', '1', '1', '2017-03-08 07:08:23'), ('4', '1', '1', '2017-03-08 07:08:26');
COMMIT;

-- ----------------------------
--  Table structure for `tb_bigType`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bigType`;
CREATE TABLE `tb_bigType` (
  `id` int(11) NOT NULL,
  `bigName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `creaTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `tb_goods`
-- ----------------------------
BEGIN;
INSERT INTO `tb_goods` VALUES ('1', '1', '1', '1', '1', '11111', '2017-03-06 07:17:51', '1.00', '1.00', '0', '/Users/yangwei/Desktop/2017/upload/goodsPicture timg001.jpeg', '1'), ('21', '1', '1', '1', '1', '11111', '2017-03-06 05:41:59', '1.00', '1.00', '0', '/Users/yangwei/Desktop/2017/uploadtimg001.jpeg', '0'), ('22', '1', '1', '1', '1', '11111', '2017-03-06 06:49:02', '1.00', '1.00', '0', '/Users/yangwei/Desktop/2017/upload/goodsPicture timg001.jpeg', '0'), ('23', '1', '1', '1', '1', '11111', '2017-03-06 06:49:02', '1.00', '1.00', '0', '/Users/yangwei/Desktop/2017/upload/goodsPicture timg001.jpeg', '0');
COMMIT;

-- ----------------------------
--  Table structure for `tb_link`
-- ----------------------------
DROP TABLE IF EXISTS `tb_link`;
CREATE TABLE `tb_link` (
  `id` int(11) NOT NULL,
  `linkName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `linkAddress` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
--  Records of `tb_manager`
-- ----------------------------
BEGIN;
INSERT INTO `tb_manager` VALUES ('1', '1', '1', '1', '1'), ('2', '2', '2', '2', '1'), ('3', '3', '1', '1', '0');
COMMIT;

-- ----------------------------
--  Table structure for `tb_member`
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `reallyName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `question` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `result` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `profession` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `tb_member`
-- ----------------------------
BEGIN;
INSERT INTO `tb_member` VALUES ('5', '杨杨', '1234356', '真实姓名', '25', '123456@qq.com', '问个问题', '答案', '职业'), ('6', '杨杨66', '1234356', '真实姓名', '25', '123456@qq.com', '问个问题', '答案', '职业'), ('7', '杨杨67', '1234356', '真实姓名', '25', '123456@qq.com', '问个问题', '答案', '职业'), ('8', '杨杨68', '1234356', '真实姓名', '25', '123456@qq.com', '问个问题', '答案', '职业'), ('9', '杨杨69', '1234356', '真实姓名', '25', '123456@qq.com', '问个问题', '答案', '职业'), ('10', '杨杨610', '1234356', '真实姓名', '25', '123456@qq.com', '问个问题', '答案', '职业');
COMMIT;

-- ----------------------------
--  Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `tb_order`
-- ----------------------------
BEGIN;
INSERT INTO `tb_order` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2017-03-07 03:56:25'), ('2', '2', '2', '2', '2', '2', '2', '2', '2', '1', '2017-03-07 06:19:52');
COMMIT;

-- ----------------------------
--  Table structure for `tb_orderDetail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderDetail`;
CREATE TABLE `tb_orderDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `goodsId` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `tb_orderDetail`
-- ----------------------------
BEGIN;
INSERT INTO `tb_orderDetail` VALUES ('1', '1', '1', '1', '1'), ('2', '2', '2', '2', '2');
COMMIT;

-- ----------------------------
--  Table structure for `tb_smallType`
-- ----------------------------
DROP TABLE IF EXISTS `tb_smallType`;
CREATE TABLE `tb_smallType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bigId` int(11) NOT NULL,
  `smallName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `creaTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `tb_smallType`
-- ----------------------------
BEGIN;
INSERT INTO `tb_smallType` VALUES ('1', '1', '1', '2017-03-08 03:43:18'), ('3', '1', '1', '2017-03-08 03:43:48'), ('4', '1', '1', '2017-03-08 03:48:08');
COMMIT;

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
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '7player', '18', '123456');
COMMIT;

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

-- ----------------------------
--  Records of `user_`
-- ----------------------------
BEGIN;
INSERT INTO `user_` VALUES ('admin', 'password', '1', 'admin');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
