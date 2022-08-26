-- ----------------------------
-- Table structure for adm_department
-- ----------------------------
-- DROP TABLE IF EXISTS `adm_department`;
-- CREATE TABLE `adm_department`  (
--                                    `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
--                                    `department_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
--                                    PRIMARY KEY (`department_id`) USING BTREE
-- ) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
--
-- -- ----------------------------
-- -- Records of adm_department
-- -- ----------------------------
-- INSERT INTO `adm_department` VALUES (1, 'Manager');
-- INSERT INTO `adm_department` VALUES (2, '研发部');
-- INSERT INTO `adm_department` VALUES (3, '市场部');

-- ----------------------------
-- Table structure for adm_employee
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details`  (
                                 `details_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `payment_id` bigint(20) NOT NULL,
                                 `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `phone` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 PRIMARY KEY (`details_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of adm_employee
-- ----------------------------
INSERT INTO `user_details` VALUES (1, 'Vick', 1, 'Manager@gmail.com', '0830458863');
-- INSERT INTO `adm_employee` VALUES (2, '齐紫陌', 2, '部门经理', 7);
-- INSERT INTO `adm_employee` VALUES (3, '王美美', 2, '高级研发工程师', 6);
-- INSERT INTO `adm_employee` VALUES (4, '宋彩妮', 2, '研发工程师', 5);
-- INSERT INTO `adm_employee` VALUES (5, '欧阳峰', 2, '初级研发工程师', 4);
-- INSERT INTO `adm_employee` VALUES (6, '张世豪', 3, '部门经理', 7);
-- INSERT INTO `adm_employee` VALUES (7, '王子豪', 3, '大客户经理', 6);
-- INSERT INTO `adm_employee` VALUES (8, '段峰', 3, '客户经理', 5);
-- INSERT INTO `adm_employee` VALUES (9, '章雪峰', 3, '客户经理', 4);
-- INSERT INTO `adm_employee` VALUES (10, '李莉', 3, '见习客户经理', 3);

DROP TABLE IF EXISTS `pk_record`;
CREATE TABLE `pk_record`  (
                                 `pk_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `vehicle_reg_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `entry_time` datetime NOT NULL,
                                 `exit_time` datetime,
                                 `payment` float(10) ,
                                 `if_paid` tinyint(1) NOT NULL,
                                 PRIMARY KEY (`pk_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO `pk_record` VALUES (1, '152D31031', "2022-02-03 15:13:01",NULL,3.3, 0);

DROP TABLE IF EXISTS `special_list`;
CREATE TABLE `special_list`  (
                              `sl_id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `vehicle_reg_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `comment` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
                              `status` tinyint(1) NOT NULL,
                              PRIMARY KEY (`sl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO `special_list` VALUES (1, 2,'152D31031', 'managers friend',1);
