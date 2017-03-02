/*
 Navicat Premium Data Transfer

 Source Server         : root_123456
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 03/02/2017 18:33:07 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_affiche`
-- ----------------------------
DROP TABLE IF EXISTS `tb_affiche`;
CREATE TABLE `tb_affiche` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `content` text COLLATE utf8_bin,
  `issueTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
  `id` int(11) NOT NULL,
  `bigId` int(11) NOT NULL,
  `smallId` int(11) NOT NULL,
  `goodsName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `goodsFrom` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `introduce` text COLLATE utf8_bin,
  `creaTime` datetime DEFAULT NULL,
  `nowPrice` float(9,2) DEFAULT NULL,
  `freePrice` float(9,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `pirture` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mark` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
  `id` int(11) NOT NULL,
  `account` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sign` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `tb_member`
-- ----------------------------
BEGIN;
INSERT INTO `tb_member` VALUES ('5', '杨杨', '1234356', '真实姓名', '25', '123456@qq.com', '问个问题', '答案', '职业');
COMMIT;

-- ----------------------------
--  Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL,
  `number` varchar(50) COLLATE utf8_bin NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `reallyName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `setMoney` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `post` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `bz` text COLLATE utf8_bin,
  `sign` bit(1) DEFAULT NULL,
  `creaTime` datetime DEFAULT NULL
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
  `number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `tb_smallType`
-- ----------------------------
DROP TABLE IF EXISTS `tb_smallType`;
CREATE TABLE `tb_smallType` (
  `id` int(11) NOT NULL,
  `bigId` int(11) NOT NULL,
  `smallName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `creaTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
