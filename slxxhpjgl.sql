/*
 Navicat Premium Data Transfer

 Source Server         : Dream
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : cdb-09zxurt6.bj.tencentcdb.com:10164
 Source Schema         : slxxhpjgl

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 22/04/2020 16:44:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for annualvideo
-- ----------------------------
DROP TABLE IF EXISTS `annualvideo`;
CREATE TABLE `annualvideo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `typhoonfrequency` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `typhoonnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `waterfrequency` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `waternumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `floodfrequency` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `floodnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `otherfrequency` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `othernumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 253 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cloudapp
-- ----------------------------
DROP TABLE IF EXISTS `cloudapp`;
CREATE TABLE `cloudapp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `governmentcloudname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租用政府云名称',
  `governmentcloudcpunumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '租用政府云租用CPU数',
  `governmentcloudreserves` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '租用政府云租用存储量',
  `businesscloudname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租用商业云云名称',
  `commercialcloudcpunumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '租用商业云租用CPU数',
  `commercialcloudreserves` int(10) NULL DEFAULT NULL COMMENT '租用商业云租用存储量',
  `selfbuiltcloudcpunumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '自建私有云物理CPU核数',
  `selfbuiltcloudvirtualmachinenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '自建私有云虚拟机数量',
  `selfbuiltcloudservernumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '自建私有云硬件服务器数量',
  `selfbuiltcloudstoragecapacity` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '自建私有云总存储容量',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 260 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for consultation
-- ----------------------------
DROP TABLE IF EXISTS `consultation`;
CREATE TABLE `consultation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `headphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operatorphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uplinknet` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `downlinknet` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lowerjoinnode` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `netmode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 239 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hardware
-- ----------------------------
DROP TABLE IF EXISTS `hardware`;
CREATE TABLE `hardware`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `computerterminalnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '计算机终端数',
  `uav` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '无人机',
  `fixedsatellitestation` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '固定卫星小站',
  `portablesatellitestation` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '便携卫星小站',
  `othersatellitefacilities` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '其他卫星设施',
  `beidoufloodreport` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '北斗卫星短信报汛',
  `fixedposition` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '定位',
  `dongzhongtong` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '动中通',
  `jingzhongtong` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '静中通',
  `clusterterminal` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '集群通信终端',
  `microwavelinelength` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '微波通信线路长度',
  `relaystationnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '微波通信中继站数 ',
  `othercommunication` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它通信手段名称',
  `othercommunicationnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '其它通信手段站数',
  `othercommunicationlinelength` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '其它通信手路线长度',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 249 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for infocollection
-- ----------------------------
DROP TABLE IF EXISTS `infocollection`;
CREATE TABLE `infocollection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hydrologycollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水文总采集点个数',
  `hydrologyautocollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水文自动采集点个数',
  `soilretentioncollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水土保持总采集点个数',
  `soilretentionautocollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水土保持自动采集点个数',
  `waterresourcecollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水资源总采集点个数',
  `waterresourceautocollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水资源自动采集点个数',
  `ecologycollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水环境水生态总采集点',
  `ecologyautocollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水环境水生态总采集点',
  `irrigationworkscollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水利工程总采集点个数',
  `irrigationworksautocollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水利工程自动采集点个数',
  `ruralirrigationcollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '农村水利总采集点个数',
  `ruralirrigationautocollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '农村水利自动采集点个数',
  `othercollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '其他总采集点个数',
  `otherautocollectnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '其他自动采集点个数',
  `othercollectname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他采集点名称',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 236 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for infoworkers
-- ----------------------------
DROP TABLE IF EXISTS `infoworkers`;
CREATE TABLE `infoworkers`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属地区',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政等级',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `jobname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要从事信息化工作人员姓名',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生年月',
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所学专业',
  `degree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学位',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `formation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编制',
  `jobphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作电话',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `operations` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运维人员',
  `mainjob` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要工作',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1689 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for intelligentdetect
-- ----------------------------
DROP TABLE IF EXISTS `intelligentdetect`;
CREATE TABLE `intelligentdetect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `intelligentsensornumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '智能传感器数量',
  `applicationtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '智能传感器主要应用类型简要描述',
  `haveintelligentcontrolsystem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有智能控制系统',
  `intelligentcontrolsystemname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '智能控制系统名称',
  `systemmonitorpointnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '系统监控点数量',
  `applicationscenario` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '应用场景描述',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 238 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for networkaccess
-- ----------------------------
DROP TABLE IF EXISTS `networkaccess`;
CREATE TABLE `networkaccess`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orders` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '序号',
  `networkaccessform` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络接入形式',
  `networkconnectedunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络连通单位',
  `isleasedline` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否专线接入',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `networkbandwidth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络带宽',
  `desktopterminalnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '台式机终端数量',
  `switchingequipmentnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '交换设备数量',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 342 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区划',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政等级',
  `orgname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `setupteam` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否成立调查小组',
  `setuptime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成立时间',
  `setupfile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成立文件',
  `headmanname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组长姓名',
  `headmanjobtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组长职务',
  `headmanphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组长联系方式',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `directorname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主任姓名',
  `directorjobtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主任职务',
  `directorphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主任联系方式',
  `isclear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否明确信息化分管领导和职能部门',
  `safedepartmentname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全和信息化职能部门名称',
  `funds` int(11) NULL DEFAULT NULL COMMENT '运维经费',
  `safeleadername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全领导名字',
  `safeleaderchangjobtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全和信息化分管领导职务',
  `safeleaderjobphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全和信息化分管领导电话',
  `safeleaderphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全领导手机',
  `safeleaderemail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全领导邮箱',
  `safedirectorname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全负责人名字',
  `safedirectorjobtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全负责人职务',
  `safedirectorjobphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全负责人工作电话',
  `safedirectorphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全负责人手机',
  `safedirectoremail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全负责人邮箱',
  `safeliaisonname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全联络人名字',
  `safeliaisonjobtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全联络人职务',
  `safeliaisonjobphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全联络员工作电话',
  `safeliaisonphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全联络人手机',
  `safeliaisonemail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络安全联络人邮箱',
  `safeliaisonwechat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网安联络员微信',
  `infoleaderannex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息化领导机构成立文件附件',
  `infoleaderfilename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息化领导机构成立文件附件名称',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 584 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for projectinvest
-- ----------------------------
DROP TABLE IF EXISTS `projectinvest`;
CREATE TABLE `projectinvest`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `entryname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `projectbriefintroduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目简介',
  `approvalnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批复文号',
  `projecttype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目类型',
  `itemcategory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目类别',
  `constructioncycle` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '建设周期',
  `centralinvestment` float unsigned zerofill NULL COMMENT '中央投资',
  `localinvestment` float unsigned zerofill NULL COMMENT '地方投资',
  `otherprojectinvestment` float unsigned zerofill NULL COMMENT '项目投资其他',
  `annualinvestment` float unsigned zerofill NULL COMMENT '年度投资',
  `isaffiliatedinformationproject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否属于水利工程附属信息化项目',
  `majorfunction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要功能',
  `systemcategory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统所属业务类别',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 388 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for serverroom
-- ----------------------------
DROP TABLE IF EXISTS `serverroom`;
CREATE TABLE `serverroom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `computerroomarea` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '机房面积',
  `monitorsum` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '监控头总数',
  `videotapeholdtime` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '监控录像保留时间',
  `totalserversum` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '服务器总数',
  `towerservernumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '塔式服务器数量',
  `bladeservernumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '刀片式服务器数量',
  `rackservernumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '机架式服务器数量',
  `servercabinetnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '服务器机柜数',
  `virtualmachinenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '虚拟机数量',
  `softwaremodel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '虚拟机管理软件型号版本',
  `haveselfbuiltmachineroom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有自建机房',
  `haveclimatecontrol` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否装备恒温空调',
  `haveautomaticcontrol` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否配有自动消控',
  `haveaccesscontrol` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有门禁',
  `haveups` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有不间断电源',
  `havecomputerroommonitor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否建有机房视频监控系统',
  `cameratype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摄像头类型',
  `servermanagementmode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务器管理方式',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 228 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for softwarelegal
-- ----------------------------
DROP TABLE IF EXISTS `softwarelegal`;
CREATE TABLE `softwarelegal`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `leaddepartment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fund` float unsigned zerofill NULL,
  `operate` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `officesoftware` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `antivirus` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `haveleadgroup` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `haveworkgroup` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `haveprocurement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `haveasset` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `havedispose` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `haveusage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `haveassess` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 227 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for specifications
-- ----------------------------
DROP TABLE IF EXISTS `specifications`;
CREATE TABLE `specifications`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政等级',
  `specificationsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `specificationsstandardname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技术标准名称',
  `specifications` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主持机构',
  `maineditor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主编机构',
  `userange` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '适用范围',
  `releasetime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  `operatime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实施时间',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for systemplan
-- ----------------------------
DROP TABLE IF EXISTS `systemplan`;
CREATE TABLE `systemplan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政等级',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `planname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规划名称',
  `approvalunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批单位',
  `releasetime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  `systemname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息化建设规划附件名称',
  `managename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息化管理规章制度名称',
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文号',
  `userange` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用范围',
  `dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发文单位',
  `promulgationtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颁布时间',
  `readymanagename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实施的信息化管理规章制度附件名称',
  `isplan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否已编制滚动发展计划',
  `ismanage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否已实施管理规章制度',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 486 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for townshipvideo
-- ----------------------------
DROP TABLE IF EXISTS `townshipvideo`;
CREATE TABLE `townshipvideo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `townnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `satnettownnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `receivetownnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `videotownnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `villagenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `satnetvillagenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `receivevillagenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `videovillagenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 317 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for traditionalconsult
-- ----------------------------
DROP TABLE IF EXISTS `traditionalconsult`;
CREATE TABLE `traditionalconsult`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orders` int(10) UNSIGNED NULL DEFAULT NULL,
  `meetingarea` float unsigned zerofill NULL,
  `fitupyear` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `capacity` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `displaydevice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cameranumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `displayresolution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `camerabrand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `screensize` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `cameraresolution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `terminalbrandmodel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `microphonenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `terminalip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inputlinenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `kvmbrand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `outputline` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `supconbrand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isspecialmeetingroom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `microphonetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isindependentsupcon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kvmtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 251 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `trainname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培训班名称',
  `trainnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '人数',
  `traindays` float unsigned zerofill NULL COMMENT '天数',
  `trainstartdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始日期',
  `trainobject` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培训对象',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 281 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `unitname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`unitname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `upassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `usrc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for videomonitor
-- ----------------------------
DROP TABLE IF EXISTS `videomonitor`;
CREATE TABLE `videomonitor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reservoirselfbuiltnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水库类监控自建数',
  `reservoirrentnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水库类监控租用数',
  `reservoirsharenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水库类监控共享接入数',
  `reservoirsupplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水库类监控供应商',
  `reservoirsharesource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水库类监控共享来源',
  `damselfbuiltnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水闸类监控自建数',
  `damrentnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水闸类监控租用数',
  `damsharenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '水闸类监控共享接入数',
  `damsupplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水闸类监控供应商',
  `damsharesource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水闸类监控共享来源',
  `riverselfbuiltnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '河道类监控自建数',
  `riverrentnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '河道类监控租用数',
  `riversharenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '河道类监控共享接入数',
  `riversupplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '河道类监控供应商',
  `riversharesource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '河道类监控共享来源',
  `seawallselfbuiltnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '堤防（海塘）类监控自建数',
  `seawallrentnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '堤防（海塘）类监控租用数',
  `seawallsharenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '堤防（海塘）类监控共享接入数',
  `seawallsupplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '堤防（海塘）类监控供应商',
  `seawallsharesource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '堤防（海塘）类监控共享来源',
  `otherselfbuiltnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '其他工程类监控自建数',
  `otherrentnumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '其他工程类监控租用数',
  `othersharenumber` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '其他工程类监控共享接入数',
  `othersupplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他工程类监控供应商',
  `othersharesource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他工程类监控共享来源',
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 263 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for visualnet
-- ----------------------------
DROP TABLE IF EXISTS `visualnet`;
CREATE TABLE `visualnet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `meetingplace` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meetingarea` float unsigned zerofill NULL,
  `fitupyear` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `capacity` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `edition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `linkspeed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clientmodel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clientterminal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `joinup` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clienttype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 272 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
