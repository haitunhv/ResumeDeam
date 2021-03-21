/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 100137
 Source Host           : localhost:3306
 Source Schema         : xr

 Target Server Type    : MySQL
 Target Server Version : 100137
 File Encoding         : 65001

 Date: 21/03/2021 21:04:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `intro` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of award
-- ----------------------------
INSERT INTO `award` VALUES (3, '2021-03-03 23:32:03', '123', 'upload/img/a8342870-c62c-49e9-a1c5-b17c2d73d7d0.jpg', '123');
INSERT INTO `award` VALUES (4, '2021-03-07 14:24:08', 'w', 'upload/img/d692a41b-6c75-4c04-9906-120e745e94c7.jpg', 'w');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `logo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `website` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `intro` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, '2021-03-07 13:30:05', '公司', 'upload/img/93c67d84-ac4f-4a7d-8808-42b97a27e46f.jpg', '22', '阿萨大的');
INSERT INTO `company` VALUES (2, '2021-03-07 14:26:07', '213123', 'upload/img/5fdaa641-ba0e-4b79-8123-481a56d6e46d.jpg', '123123', '123123');
INSERT INTO `company` VALUES (3, '2021-03-07 14:29:33', '111111', 'upload/img/3940d90a-c413-454e-8173-8a4f25dc9cfd.jpg', '333', '4444');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `subject` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `already_read` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (1, '2021-03-16 21:08:18', '1', 'mj@qq.com', '1', '1', 0);
INSERT INTO `contact` VALUES (2, '2021-03-16 21:09:38', '1', 'mj@qq.com', '1', '1', 0);
INSERT INTO `contact` VALUES (3, '2021-03-16 21:09:58', '3', '1@126.com', 'qweqe', 'qeqwe', 0);

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `type` int NOT NULL,
  `intro` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `begin_day` date NOT NULL,
  `end_day` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of education
-- ----------------------------
INSERT INTO `education` VALUES (2, '2021-02-25 23:23:51', '21222222222222222222', 4, '12312', '2021-02-05', '2021-02-11');

-- ----------------------------
-- Table structure for experience
-- ----------------------------
DROP TABLE IF EXISTS `experience`;
CREATE TABLE `experience`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `job` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `intro` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `begin_day` date NOT NULL,
  `end_day` date NULL DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `company_id`(`company_id`) USING BTREE,
  CONSTRAINT `experience_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of experience
-- ----------------------------
INSERT INTO `experience` VALUES (2, '2021-03-07 17:46:35', 'werwer', 'qweqwe', '2021-03-07', '2021-04-02', 3);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `intro` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `website` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `begin_day` date NOT NULL,
  `end_day` date NULL DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `company_id`(`company_id`) USING BTREE,
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '2021-03-07 18:53:28', '??', 'qweqwe', 'qweqw', 'upload/img/8d38a515-358f-4f3e-b562-804ad27e98b8.jpg', '2021-03-11', '2021-04-03', 2);

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of skill
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `photo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `intro` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `job` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `trait` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `interests` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2021-02-21 22:31:01', 'fae0b27c451c728867a567e8c1bb4e53', 'haitunhv@163.com', '2021-03-12', 'upload/img/b46fe76e-b528-4b4c-bd83-66354ee191e2.jfif', '本人学识渊博、经验丰富，代码风骚、效率恐怖，C/C++ C#、Java、PHP、Android、iOS、Python、JavaScript，无不精通玩转，熟练掌握各种框架，并自写语言，创操作系统，写CPU处理器构架，做指令集成。深山苦练20余年，一天只睡3小时，千里之外定位问题，瞬息之间修复上线。身体强壮、健步如飞，可连续工作100小时不休息，讨论技术方案9小时不喝水，上至研发CPU芯片、带项目、出方案、弄计划，下至盗账号、黑网站、Shell提权挂马、攻击同行、拍片摄影、泡妞把妹纸、开挖掘机、威胁PM，啥都能干。', '???MJ', '地球', '9527', '讲师', '??', '??');

-- ----------------------------
-- Table structure for website
-- ----------------------------
DROP TABLE IF EXISTS `website`;
CREATE TABLE `website`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `footer` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of website
-- ----------------------------
INSERT INTO `website` VALUES (1, '2021-02-21 22:31:01', '<a href=\"https://space.bilibili.com/325538782\" target=\"_blank\">???MJ</a> © All Rights Reserved 202100w');
INSERT INTO `website` VALUES (2, '2021-02-22 23:03:36', NULL);
INSERT INTO `website` VALUES (3, '2021-02-22 23:03:42', NULL);

SET FOREIGN_KEY_CHECKS = 1;
