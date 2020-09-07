/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 20/05/2020 16:54:00
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notice_employee
-- ----------------------------
DROP TABLE IF EXISTS `notice_employee`;
CREATE TABLE `notice_employee`  (
  `notice_id` bigint(20) NULL DEFAULT NULL,
  `employee_id` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice_employee
-- ----------------------------
INSERT INTO `notice_employee` VALUES (1, 1);
INSERT INTO `notice_employee` VALUES (3, 2);
INSERT INTO `notice_employee` VALUES (2, 3);
INSERT INTO `notice_employee` VALUES (4, 1);

SET FOREIGN_KEY_CHECKS = 1;
