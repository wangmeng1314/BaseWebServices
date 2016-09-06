/*
Navicat MySQL Data Transfer

Source Server         : BaseWebServices
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : basewebservices

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-09-05 22:41:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` tinyint(255) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '唯一主键id',
  `servicename` varchar(255) NOT NULL DEFAULT '' COMMENT '服务名',
  `methodname` varchar(255) NOT NULL DEFAULT '' COMMENT '方法名',
  `servicekey` varchar(255) NOT NULL DEFAULT '' COMMENT '服务寻址键名',
  `methodkey` varchar(255) NOT NULL DEFAULT '' COMMENT '方法寻址键名',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
