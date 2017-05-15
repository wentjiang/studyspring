/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : springbootdb

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-05-10 18:09:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'Jack', 'Bauer');
INSERT INTO `customer` VALUES ('2', 'Chloe', 'O\'Brian');
INSERT INTO `customer` VALUES ('3', 'Kim', 'Bauer');
INSERT INTO `customer` VALUES ('4', 'David', 'Palmer');
INSERT INTO `customer` VALUES ('5', 'Michelle', 'Dessler');
INSERT INTO `customer` VALUES ('6', 'Jack', 'Bauer');
INSERT INTO `customer` VALUES ('7', 'Chloe', 'O\'Brian');
INSERT INTO `customer` VALUES ('8', 'Kim', 'Bauer');
INSERT INTO `customer` VALUES ('9', 'David', 'Palmer');
INSERT INTO `customer` VALUES ('10', 'Michelle', 'Dessler');
INSERT INTO `customer` VALUES ('11', 'Jack', 'Bauer');
INSERT INTO `customer` VALUES ('12', 'Chloe', 'O\'Brian');
INSERT INTO `customer` VALUES ('13', 'Kim', 'Bauer');
INSERT INTO `customer` VALUES ('14', 'David', 'Palmer');
INSERT INTO `customer` VALUES ('15', 'Michelle', 'Dessler');
INSERT INTO `customer` VALUES ('16', 'Jack', 'Bauer');
INSERT INTO `customer` VALUES ('17', 'Chloe', 'O\'Brian');
INSERT INTO `customer` VALUES ('18', 'Kim', 'Bauer');
INSERT INTO `customer` VALUES ('19', 'David', 'Palmer');
INSERT INTO `customer` VALUES ('20', 'Michelle', 'Dessler');
INSERT INTO `customer` VALUES ('21', 'jiangj', 'wentao');
