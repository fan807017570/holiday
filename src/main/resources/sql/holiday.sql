/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50632
Source Host           : 192.168.1.107:3306
Source Database       : holiday

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-02-14 23:09:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('0', '人事处');
INSERT INTO `department` VALUES ('3', '办公室');

-- ----------------------------
-- Table structure for islive
-- ----------------------------
DROP TABLE IF EXISTS `islive`;
CREATE TABLE `islive` (
  `id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of islive
-- ----------------------------

-- ----------------------------
-- Table structure for ismarry
-- ----------------------------
DROP TABLE IF EXISTS `ismarry`;
CREATE TABLE `ismarry` (
  `id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ismarry
-- ----------------------------

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` int(11) NOT NULL,
  `idcard` varchar(18) NOT NULL,
  `No` int(11) NOT NULL,
  `status_id` int(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  `department_id` int(10) NOT NULL,
  `sex` varchar(2) NOT NULL DEFAULT '男',
  `hiredate` date NOT NULL,
  `ismarry_id` int(11) NOT NULL,
  `marry_id` int(11) NOT NULL,
  `islive_id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------

-- ----------------------------
-- Table structure for process
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of process
-- ----------------------------

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL,
  `pid` int(18) NOT NULL,
  `vid` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `begin` date NOT NULL,
  `end` date NOT NULL,
  `reason` varchar(30) NOT NULL,
  `type_id` int(10) NOT NULL,
  `process_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `record_pid` (`pid`),
  KEY `record_vid` (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(8) DEFAULT NULL,
  `isadmin` tinyint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('2', 'admin', 'test', '1');
INSERT INTO `user` VALUES ('3', 'test', '12345678', '0');
INSERT INTO `user` VALUES ('4', 'zqy', 'test', '0');
INSERT INTO `user` VALUES ('6', 'zqy', '1', '0');
INSERT INTO `user` VALUES ('44', 'zqy', 'test', '0');
INSERT INTO `user` VALUES ('45', 'zqy', 'test', '0');
INSERT INTO `user` VALUES ('46', 'zqy', 'test', '0');
INSERT INTO `user` VALUES ('47', 'zqy', 'test', '0');
INSERT INTO `user` VALUES ('48', 'zqy1', 'test1', '1');
INSERT INTO `user` VALUES ('49', 'zqy', '123455', '0');
INSERT INTO `user` VALUES ('50', 'zqy', '123', '0');
INSERT INTO `user` VALUES ('51', 'zqy', '123', '0');
INSERT INTO `user` VALUES ('52', 'zqy', '123', '0');

-- ----------------------------
-- Table structure for vacation
-- ----------------------------
DROP TABLE IF EXISTS `vacation`;
CREATE TABLE `vacation` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vacation
-- ----------------------------
