-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `xiaolu_excel`
  DEFAULT CHARACTER SET utf8;
USE `xiaolu_excel`;

CREATE TABLE IF NOT EXISTS `xiaolu_excel`.`excel_intermediary` (
  `intermediary_id` VARCHAR(40) NOT NULL,
  `report_time` VARCHAR(40) NOT NULL,
  `customer_source` VARCHAR(40),
  `report_building` VARCHAR(40),
  `customer_name` VARCHAR(40),
  `customer_tel` VARCHAR(40) NOT NULL,
  `intention_level` VARCHAR(40),
  `visit_time` VARCHAR(40),
  `visit_building` VARCHAR(40),
  `customer_situation` VARCHAR(40),
  `deal_time` VARCHAR(40),
  `deal_building` VARCHAR(40),
  `deal_roomnum` VARCHAR(40),
  `remark` VARCHAR(100),
  `block_flag`   TINYINT(1)  NOT NULL,
  `create_time`  DATETIME    NOT NULL,
  PRIMARY KEY (`intermediary_id`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `xiaolu_excel`.`excel_callcustomer` (
  `call_customer_id` VARCHAR(40) NOT NULL,
  `datasource_area` VARCHAR(40),
  `datasource_building` VARCHAR(40),
  `datasource_type` VARCHAR(40),
  `customer_name` VARCHAR(40),
  `customer_tel` VARCHAR(40) NOT NULL,
  `call_time` VARCHAR(40) NOT NULL,
  `call_salesman` VARCHAR(40),
  `feedback` VARCHAR(100),
  `intention_level` VARCHAR(40),
  `intention_building` VARCHAR(40),
  `visit_time` VARCHAR(40),
  `visit_building` VARCHAR(40),
  `customer_situation` VARCHAR(40),
  `deal_time` VARCHAR(40),
  `deal_building` VARCHAR(40),
  `deal_roomnum` VARCHAR(40),
  `remark` VARCHAR(100),
  `block_flag`   TINYINT(1)  NOT NULL,
  `create_time`  DATETIME    NOT NULL,
  PRIMARY KEY (`call_customer_id`)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `xiaolu_excel`.`excel_extension` (
  `extension_id` VARCHAR(40) NOT NULL,
  `extension_time` VARCHAR(40) NOT NULL,
  `extension_location` VARCHAR(40),
  `customer_name` VARCHAR(40),
  `customer_tel` VARCHAR(40) NOT NULL,
  `realty_consultant` VARCHAR(40),
  `visit_time` VARCHAR(40),
  `customer_situation` VARCHAR(40),
  `deal_time` VARCHAR(40),
  `deal_building` VARCHAR(40),
  `deal_roomnum` VARCHAR(40),
  `remark` VARCHAR(100),
  `block_flag`   TINYINT(1)  NOT NULL,
  `create_time`  DATETIME    NOT NULL,
  PRIMARY KEY (`extension_id`)
)
  ENGINE = InnoDB;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

