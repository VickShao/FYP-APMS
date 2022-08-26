/*
 Navicat Premium Data Transfer

 Source Server         : FYP
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : apms

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 12/04/2022 22:29:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for details_payment
-- ----------------------------
DROP TABLE IF EXISTS `details_payment`;
CREATE TABLE `details_payment`  (
  `dp_id` bigint NOT NULL AUTO_INCREMENT,
  `details_id` bigint NOT NULL,
  `card_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `card_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `expired_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cvv` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`dp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of details_payment
-- ----------------------------
INSERT INTO `details_payment` VALUES (11, 20, '1234 1234 1234 1234', 'Xinyang', '06/26', '123');

-- ----------------------------
-- Table structure for details_vrn
-- ----------------------------
DROP TABLE IF EXISTS `details_vrn`;
CREATE TABLE `details_vrn`  (
  `dv_id` bigint NOT NULL AUTO_INCREMENT,
  `details_id` bigint NOT NULL,
  `vehicle_reg_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dv_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of details_vrn
-- ----------------------------
INSERT INTO `details_vrn` VALUES (10, 2, '456789', NULL);
INSERT INTO `details_vrn` VALUES (11, 20, '152D1031', '');
INSERT INTO `details_vrn` VALUES (13, 20, '15LK10898', 'New Car');
INSERT INTO `details_vrn` VALUES (14, 20, '152D31013', '');
INSERT INTO `details_vrn` VALUES (15, 20, '152D31031', '');

-- ----------------------------
-- Table structure for pk_record
-- ----------------------------
DROP TABLE IF EXISTS `pk_record`;
CREATE TABLE `pk_record`  (
  `pk_record_id` bigint NOT NULL AUTO_INCREMENT,
  `vehicle_reg_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `entry_time` datetime NOT NULL,
  `exit_time` datetime NULL DEFAULT NULL,
  `payment` float NULL DEFAULT NULL,
  `if_paid` tinyint(1) NOT NULL,
  PRIMARY KEY (`pk_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pk_record
-- ----------------------------
INSERT INTO `pk_record` VALUES (1, '152D31013', '2022-03-30 05:13:01', '2022-03-30 23:47:57', NULL, 1);
INSERT INTO `pk_record` VALUES (2, '152D31031', '2022-03-30 05:13:01', '2022-03-31 23:56:43', 125.79, 1);
INSERT INTO `pk_record` VALUES (3, '152D31031', '2022-03-30 05:13:01', '2022-02-03 15:13:01', 3.3, 1);
INSERT INTO `pk_record` VALUES (11, '152D1031', '2022-03-30 23:34:01', NULL, 94.42, 1);
INSERT INTO `pk_record` VALUES (14, '15LK10898', '2022-03-31 02:29:02', '2022-04-01 03:15:10', 77.25, 1);
INSERT INTO `pk_record` VALUES (17, '8888', '2022-03-31 23:58:06', '2022-04-01 00:02:32', NULL, 1);
INSERT INTO `pk_record` VALUES (18, '456789', '2022-04-01 00:03:39', '2022-04-01 00:03:49', NULL, 1);
INSERT INTO `pk_record` VALUES (19, '456789', '2022-04-01 02:50:47', '2022-04-04 19:55:20', 267.21, 1);
INSERT INTO `pk_record` VALUES (20, '15LK10898', '2022-04-01 03:25:45', '2022-04-01 03:27:05', NULL, 1);
INSERT INTO `pk_record` VALUES (21, 'norman', '2022-04-04 19:58:33', NULL, 110.11, 1);
INSERT INTO `pk_record` VALUES (22, '181C10868', '2022-04-04 19:59:22', '2022-04-04 21:47:43', 5.29, 1);
INSERT INTO `pk_record` VALUES (35, '15LK10898', '2022-04-08 03:32:37', '2022-04-08 23:01:30', 58.09, 1);

-- ----------------------------
-- Table structure for special_list
-- ----------------------------
DROP TABLE IF EXISTS `special_list`;
CREATE TABLE `special_list`  (
  `sl_id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `vehicle_reg_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `comment` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`sl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of special_list
-- ----------------------------
INSERT INTO `special_list` VALUES (38, '', '152D31013', '', 0);

-- ----------------------------
-- Table structure for sys_node
-- ----------------------------
DROP TABLE IF EXISTS `sys_node`;
CREATE TABLE `sys_node`  (
  `node_id` bigint NOT NULL AUTO_INCREMENT COMMENT '节点编号',
  `node_type` int NOT NULL COMMENT '节点类型 1-模块 2-功能',
  `node_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '节点名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能地址',
  `node_code` int NOT NULL COMMENT '节点编码,用于排序',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '上级节点编号',
  PRIMARY KEY (`node_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_node
-- ----------------------------
INSERT INTO `sys_node` VALUES (1, 1, 'Parking Record', NULL, 1000000, NULL);
INSERT INTO `sys_node` VALUES (2, 2, 'All', '/parking_record.html?options=0', 1000001, 1);
INSERT INTO `sys_node` VALUES (3, 2, 'Paid', '/parking_record.html?options=1', 1000002, 1);
INSERT INTO `sys_node` VALUES (4, 2, 'Unpaid', '/parking_record.html?options=2', 1000003, 1);
INSERT INTO `sys_node` VALUES (5, 1, 'Special List', NULL, 1000004, NULL);
INSERT INTO `sys_node` VALUES (6, 2, 'White List', '/special_list.html?options=white', 1000005, 5);
INSERT INTO `sys_node` VALUES (7, 2, 'Black List', '/special_list.html?options=black', 1000006, 5);
INSERT INTO `sys_node` VALUES (8, 1, 'Pay Parking Fee', '/pay_fee.html', 1000007, NULL);
INSERT INTO `sys_node` VALUES (9, 1, 'Parking History', '/driver_parking_history.html', 1000008, NULL);
INSERT INTO `sys_node` VALUES (10, 1, 'Account Management', NULL, 1000009, NULL);
INSERT INTO `sys_node` VALUES (11, 2, 'Saved Vehicles', '/saved_vehicle.html', 1000010, 10);
INSERT INTO `sys_node` VALUES (12, 2, 'Payment Methods', '/payment_method.html', 1000011, 10);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_description` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'Manager');
INSERT INTO `sys_role` VALUES (2, 'Driver');
INSERT INTO `sys_role` VALUES (3, 'Guest');

-- ----------------------------
-- Table structure for sys_role_node
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_node`;
CREATE TABLE `sys_role_node`  (
  `rn_id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `node_id` bigint NOT NULL,
  PRIMARY KEY (`rn_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_node
-- ----------------------------
INSERT INTO `sys_role_node` VALUES (1, 1, 1);
INSERT INTO `sys_role_node` VALUES (2, 1, 2);
INSERT INTO `sys_role_node` VALUES (3, 1, 3);
INSERT INTO `sys_role_node` VALUES (4, 1, 4);
INSERT INTO `sys_role_node` VALUES (5, 2, 8);
INSERT INTO `sys_role_node` VALUES (6, 2, 9);
INSERT INTO `sys_role_node` VALUES (7, 2, 0);
INSERT INTO `sys_role_node` VALUES (8, 1, 5);
INSERT INTO `sys_role_node` VALUES (9, 1, 6);
INSERT INTO `sys_role_node` VALUES (10, 1, 7);
INSERT INTO `sys_role_node` VALUES (11, 2, 10);
INSERT INTO `sys_role_node` VALUES (12, 2, 11);
INSERT INTO `sys_role_node` VALUES (13, 2, 12);

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `ru_id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`ru_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES (1, 1, 1);
INSERT INTO `sys_role_user` VALUES (2, 2, 2);
INSERT INTO `sys_role_user` VALUES (3, 2, 3);
INSERT INTO `sys_role_user` VALUES (16, 2, 17);
INSERT INTO `sys_role_user` VALUES (17, 2, 18);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `details_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工编号',
  `salt` int NOT NULL COMMENT '盐值',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'manager', 'f57e762e3fb7e1e3ec8ec4db6a1248e1', '1', 188);
INSERT INTO `sys_user` VALUES (2, 'driver1', 'f57e762e3fb7e1e3ec8ec4db6a1248e1', '2', 188);
INSERT INTO `sys_user` VALUES (3, 'driver2', 'f57e762e3fb7e1e3ec8ec4db6a1248e1', '3', 188);
INSERT INTO `sys_user` VALUES (17, 'driver3', 'ff63a64c11c31865fe1f6adc8148e575', '20', 129);
INSERT INTO `sys_user` VALUES (18, '111', '13407f537508746aa7d489cb95470a14', '21', 185);

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details`  (
  `details_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`details_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_details
-- ----------------------------
INSERT INTO `user_details` VALUES (1, 'Vick', 'Manager@gmail.com', '0830458863');
INSERT INTO `user_details` VALUES (2, 'Vick', 'Driver@gamual.com', '0830458863');
INSERT INTO `user_details` VALUES (3, 'Vick', 'Driver2@gmail.com', '0830458863');
INSERT INTO `user_details` VALUES (20, 'Xinyang', 'shao19991031@gmail.com', '0830458863');
INSERT INTO `user_details` VALUES (21, '111', 'shao19991031@gmail.com', '111');

SET FOREIGN_KEY_CHECKS = 1;
