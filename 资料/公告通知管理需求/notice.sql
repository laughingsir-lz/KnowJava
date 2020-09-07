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

 Date: 20/05/2020 16:53:34
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `issuer_id` bigint(20) NULL DEFAULT NULL,
  `pubdate` datetime NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, 1, '2020-05-20 14:31:50', '2020年国庆放假公告', '各位同事：    \n感谢大家一直以来为公司做出的贡献，国庆将至，根据国家假期安排通知，结合本公司的实际情况，元旦节放假具体安排如下：2019年10月1日至2019年10月7日放假调休，共7天。');
INSERT INTO `notice` VALUES (2, 1, '2020-05-20 14:33:39', '授予张小明同志“优秀员工”称号', '张小明同志的工作态度和工作能力大家有目共睹，为了树立典型，学习先进，集团公司决定授予张胜阳同志“优秀员工”称号。     \n集团公司号召，在今后的工作中，广大职工能够向张胜阳同志学习。');
INSERT INTO `notice` VALUES (3, 1, '2020-05-20 14:34:21', '关于出差费用报销的规定', '财务规定可报销发票有：机票、火车票、住宿费；打车费；会务费；');
INSERT INTO `notice` VALUES (4, 1, '2020-05-20 16:03:14', '卫生安全抽检工作', '为了加强公司卫生管理情况，下周要做卫生安全抽检，请各部门配合。');

SET FOREIGN_KEY_CHECKS = 1;
