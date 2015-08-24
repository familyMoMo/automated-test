/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50067
Source Host           : 127.0.0.1:3306
Source Database       : interface_test

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2015-08-24 22:21:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test_case
-- ----------------------------
DROP TABLE IF EXISTS `test_case`;
CREATE TABLE `test_case` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '自增id',
  `version` varchar(50) NOT NULL default '' COMMENT '用例版本号',
  `case_name` varchar(50) NOT NULL default '' COMMENT '用例名',
  `url` varchar(1000) NOT NULL default '' COMMENT '接口地址',
  `request_method` varchar(10) NOT NULL default '' COMMENT '请求方式',
  `request_header` varchar(255) default '' COMMENT '请求头',
  `request_cookie` varchar(255) default '' COMMENT 'cookie',
  `request_body` varchar(1000) default '' COMMENT '请求体',
  `request_encoding` varchar(20) default 'UTF-8' COMMENT '编码',
  `content_type` varchar(255) default '' COMMENT 'Content-Type',
  `response_resolver` varchar(20) NOT NULL default '' COMMENT '对比标准',
  `expect_response` varchar(1000) NOT NULL default '' COMMENT '预期返回值',
  `description` varchar(255) default '' COMMENT '用例描述',
  `create_time` datetime default '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime default '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test_result
-- ----------------------------
DROP TABLE IF EXISTS `test_result`;
CREATE TABLE `test_result` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '自增id',
  `case_id` bigint(20) NOT NULL COMMENT 'case_id',
  `case_name` varchar(50) NOT NULL default '' COMMENT '用例名',
  `expect_response` varchar(1000) NOT NULL default '' COMMENT '期望返回值',
  `actual_response` varchar(1000) NOT NULL default '' COMMENT '实际返回值',
  `result` varchar(10) NOT NULL default '' COMMENT '测试结果',
  `tag` int(11) NOT NULL default '0' COMMENT '测试轮次',
  `tag_name` varchar(255) NOT NULL default '' COMMENT '测试轮次别名',
  `create_time` datetime NOT NULL default '1970-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test_version
-- ----------------------------
DROP TABLE IF EXISTS `test_version`;
CREATE TABLE `test_version` (
  `id` int(11) NOT NULL auto_increment COMMENT '自增id',
  `version` varchar(50) NOT NULL default '' COMMENT '用例版本号',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
