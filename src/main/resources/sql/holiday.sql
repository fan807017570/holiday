/*
Navicat MySQL Data Transfer

Source Server         : holiday
Source Server Version : 50632
Source Host           : 192.168.0.111:3306
Source Database       : holiday

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-06-16 21:58:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '人事处');
INSERT INTO `department` VALUES ('2', '科技处');
INSERT INTO `department` VALUES ('3', '反洗钱出');
INSERT INTO `department` VALUES ('4', '支付处');
INSERT INTO `department` VALUES ('5', '办公室');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `username` varchar(20) NOT NULL COMMENT '用户名称',
  `telnumber` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `idcard` int(3) NOT NULL COMMENT '员工id号',
  `name` varchar(20) NOT NULL COMMENT '员工姓名',
  `department_id` int(10) NOT NULL COMMENT '员工所在的部门id',
  `sex` varchar(6) NOT NULL DEFAULT '男' COMMENT '行别',
  `hiredate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入行时间',
  `ismarry` int(11) NOT NULL COMMENT '是否结婚，0未婚，1.结婚',
  `islive_id` int(11) NOT NULL COMMENT '父母是否健在0：不在1：健在',
  `age` int(3) DEFAULT NULL COMMENT '员工的年龄',
  `location` int(2) DEFAULT NULL COMMENT '员工是否是本地，0.省内1.本地2.省外',
  `password` varchar(6) NOT NULL COMMENT '用户密码6位',
  `roleId` int(6) NOT NULL COMMENT '管理员，系统管理员，普通员工',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('zqy', '15361015243', '1', '670', '张琼宇', '1', '女', '2017-06-10 18:53:59', '1', '1', '23', '2', '199171', '1');
INSERT INTO `employee` VALUES ('zyting', '15889535346', '2', '680', '郑雨婷', '1', '男', '2017-06-10 18:54:51', '1', '1', '25', '1', '199171', '2');
INSERT INTO `employee` VALUES ('fananran', '15363035231', '3', '324', '范安然', '1', '男', '2017-06-10 19:32:00', '1', '1', '28', '1', '199171', '1');
INSERT INTO `employee` VALUES ('rao', '12334322212', '4', '256', '饶处', '1', '男', '2017-06-10 19:36:06', '1', '1', '33', '1', '199171', '1');

-- ----------------------------
-- Table structure for envocation
-- ----------------------------
DROP TABLE IF EXISTS `envocation`;
CREATE TABLE `envocation` (
  `userid` int(11) NOT NULL,
  `vocationid` int(11) NOT NULL,
  `term` int(5) NOT NULL,
  `ownyear` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '所属年份',
  `balanceTime` int(11) NOT NULL,
  PRIMARY KEY (`userid`,`vocationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of envocation
-- ----------------------------
INSERT INTO `envocation` VALUES ('1', '1', '5', '2017-03-03 23:51:12', '5');
INSERT INTO `envocation` VALUES ('1', '2', '10', '2017-05-07 12:05:55', '10');
INSERT INTO `envocation` VALUES ('1', '3', '7', '2017-05-07 12:06:13', '7');
INSERT INTO `envocation` VALUES ('1', '4', '2', '2017-05-07 12:06:48', '2');
INSERT INTO `envocation` VALUES ('1', '5', '22', '2017-05-07 12:07:03', '22');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `vid` int(11) NOT NULL COMMENT '假期id',
  `duration` int(5) NOT NULL COMMENT '请假时长',
  `startDate` date NOT NULL COMMENT '开始日期',
  `endDate` date NOT NULL COMMENT '结束日期',
  `commitTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `orderTime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '批准时间',
  `status` int(5) NOT NULL COMMENT '1:保存2.提交3.已批准',
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '假单创建的时间',
  `approverId` int(11) DEFAULT NULL,
  `comment` varchar(200) NOT NULL COMMENT '请假理由',
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('3', '1', '3', '1', '2017-05-31', '2017-06-01', null, null, '1', '2017-06-12 08:07:30', null, '家里有急事，需要回家处理！');

-- ----------------------------
-- Table structure for roler
-- ----------------------------
DROP TABLE IF EXISTS `roler`;
CREATE TABLE `roler` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(20) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roler
-- ----------------------------
INSERT INTO `roler` VALUES ('1', '管理员');
INSERT INTO `roler` VALUES ('2', '普通用户');
INSERT INTO `roler` VALUES ('3', '系统管理员');

-- ----------------------------
-- Table structure for vacation
-- ----------------------------
DROP TABLE IF EXISTS `vacation`;
CREATE TABLE `vacation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vacation
-- ----------------------------
INSERT INTO `vacation` VALUES ('1', '年假');
INSERT INTO `vacation` VALUES ('2', '陪产假');
INSERT INTO `vacation` VALUES ('3', '探亲假');
INSERT INTO `vacation` VALUES ('4', '调休假');
INSERT INTO `vacation` VALUES ('5', '病假');
INSERT INTO `vacation` VALUES ('6', '事假');
