-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `xiaolu_excel`
  DEFAULT CHARACTER SET utf8;
USE `xiaolu_excel`;

CREATE TABLE IF NOT EXISTS `xiaolu_excel`.`excel_intermediary` (
  `intermediary_id` VARCHAR(40) NOT NULL,
  `report_time` INT NOT NULL,
  `customer_source` VARCHAR(40),
  `report_building` VARCHAR(40),
  `customer_name` VARCHAR(40),
  `customer_tel` VARCHAR(40) NOT NULL,
  `intention_level` VARCHAR(40),
  `visit_time` VARCHAR(40),
  `visit_building` VARCHAR(40),
  `customer_situation` VARCHAR(200),
  `deal_time` VARCHAR(40),
  `deal_building` VARCHAR(40),
  `deal_roomnum` VARCHAR(40),
  `remark` VARCHAR(200),
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
  `call_time` INT NOT NULL,
  `call_salesman` VARCHAR(40),
  `feedback` VARCHAR(100),
  `intention_level` VARCHAR(40),
  `intention_building` VARCHAR(40),
  `visit_time` VARCHAR(40),
  `visit_building` VARCHAR(40),
  `customer_situation` VARCHAR(200),
  `deal_time` VARCHAR(40),
  `deal_building` VARCHAR(40),
  `deal_roomnum` VARCHAR(40),
  `remark` VARCHAR(200),
  `block_flag`   TINYINT(1)  NOT NULL,
  `create_time`  DATETIME    NOT NULL,
  PRIMARY KEY (`call_customer_id`)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `xiaolu_excel`.`excel_extension` (
  `extension_id` VARCHAR(40) NOT NULL,
  `extension_time` INT NOT NULL,
  `extension_location` VARCHAR(40),
  `customer_name` VARCHAR(40),
  `customer_tel` VARCHAR(40) NOT NULL,
  `realty_consultant` VARCHAR(40),
  `visit_time` VARCHAR(40),
  `customer_situation` VARCHAR(200),
  `deal_time` VARCHAR(40),
  `deal_building` VARCHAR(40),
  `deal_roomnum` VARCHAR(40),
  `remark` VARCHAR(200),
  `block_flag`   TINYINT(1)  NOT NULL,
  `create_time`  DATETIME    NOT NULL,
  PRIMARY KEY (`extension_id`)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `xiaolu_excel`.`excel_incomingcall` (
  `incoming_call_id` VARCHAR(40) NOT NULL,
  `call_time` INT NOT NULL,
  `customer_name` VARCHAR(40),
  `customer_tel` VARCHAR(40) NOT NULL,
  `realty_purpose` VARCHAR(40),
  `demand_area` VARCHAR(40),
  `house_type` VARCHAR(40),
  `residential_zone` VARCHAR(40),
  `accept_price` VARCHAR(40),
  `access_known` VARCHAR(40),
  `consult_content` VARCHAR(40),
  `visit_time` VARCHAR(40),
  `customer_situation` VARCHAR(200),
  `deal_time` VARCHAR(40),
  `deal_building` VARCHAR(40),
  `deal_roomnum` VARCHAR(40),
  `salesman` VARCHAR(40),
  `block_flag`   TINYINT(1)  NOT NULL,
  `create_time`  DATETIME    NOT NULL,
  PRIMARY KEY (`incoming_call_id`)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `xiaolu_excel`.`excel_visit` (
  `visit_id` VARCHAR(40) NOT NULL,
  `visit_time` INT NOT NULL,
  `customer_name` VARCHAR(40),
  `customer_tel` VARCHAR(40) NOT NULL,
  `visited_times` VARCHAR(40),
  `intentional_area` VARCHAR(40),
  `accept_price` VARCHAR(40),
  `realty_times` VARCHAR(40),
  `age` VARCHAR(40),
  `residential_zone` VARCHAR(40),
  `work_zone` VARCHAR(40),
  `occupation` VARCHAR(40),
  `access_known` VARCHAR(40),
  `realty_purpose` VARCHAR(40),
  `realty_type` VARCHAR(40),
  `concerns` VARCHAR(40),
  `customer_description` VARCHAR(200),
  `latest_state` VARCHAR(40),
  `customer_type` VARCHAR(40),
  `realty_consultant` VARCHAR(40),
  `deal_time` VARCHAR(40),
  `deal_roomnum` VARCHAR(40),
  `block_flag`   TINYINT(1)  NOT NULL,
  `create_time`  DATETIME    NOT NULL,
  PRIMARY KEY (`visit_id`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `xiaolu_excel`.`excel_deal` (
  `deal_id` VARCHAR(40) NOT NULL ,
  `subscription_time` INT NOT NULL ,
  `recognition_time` VARCHAR(40),
  `property_type` VARCHAR(40),
  `deal_section` VARCHAR(40),
  `decoration` VARCHAR(40),
  `building_id` VARCHAR(40),
  `room_num` VARCHAR(40),
  `customer_name` VARCHAR(40),
  `wechat_id` VARCHAR(40),
  `customer_tel` VARCHAR(40) NOT NULL ,
  `predicted_area` VARCHAR(40),
  `subscription_unit_price` VARCHAR(40),
  `subscription_total_price` VARCHAR(40),
  `discount_detail` VARCHAR(200),
  `five_to_fifteen` VARCHAR(40),
  `fifteen_after_discount` VARCHAR(40),
  `opening_quotation_discount` VARCHAR(40),
  `discount_of_contract_ontime` VARCHAR(40),
  `actual_deal_unit_price` VARCHAR(40),
  `deal_total_price_input` VARCHAR(40),
  `deal_total_price_check` VARCHAR(40),
  `amount_of_payment_first` VARCHAR(40),
  `date_of_payment_first` VARCHAR(40),
  `amount_of_payment_second` VARCHAR(40),
  `date_of_payment_second` VARCHAR(40),
  `amount_of_payment_third` VARCHAR(40),
  `date_of_payment_third` VARCHAR(40),
  `arrange_contract_date` VARCHAR(40),
  `subscription_without_contract` VARCHAR(200),
  `actual_contract_date` VARCHAR(40),
  `loan_amount` VARCHAR(40),
  `transact_loan_date` VARCHAR(40),
  `loan_bank` VARCHAR(40),
  `payment_method` VARCHAR(40),
  `payment_rate` VARCHAR(40),
  `accumulative_payment` VARCHAR(40),
  `un_payment` VARCHAR(40),
  `complete_payment_date` VARCHAR(40),
  `mortgage_schedule` VARCHAR(40),
  `sales_company` VARCHAR(40),
  `staff_percentage` VARCHAR(40),
  `realty_consultant_salary` VARCHAR(40),
  `realty_consultant` VARCHAR(40),
  `abutment_person` VARCHAR(40),
  `agreement_authentication_date` VARCHAR(40),
  `address` VARCHAR(200),
  `card_id` VARCHAR(200),
  `age` VARCHAR(40),
  `residential_zone` VARCHAR(40),
  `work_zone` VARCHAR(40),
  `occupation` VARCHAR(40),
  `access_known` VARCHAR(40),
  `referee` VARCHAR(40),
  `referee_tel` VARCHAR(40),
  `realty_purpose` VARCHAR(40),
  `realty_times` VARCHAR(40),
  `salary_settlement_submit_time` VARCHAR(40),
  `salary_grant_time` VARCHAR(40),
  `salary_settlement_rate` VARCHAR(40),
  `settle_salary_rate` VARCHAR(40),
  `settle_salary_money` VARCHAR(40),
  `salary_settlement_submit_time_second` VARCHAR(40),
  `salary_grant_time_second` VARCHAR(40),
  `salary_settlement_rate_second` VARCHAR(40),
  `deposit` VARCHAR(40),
  `predicted_deliver_time` VARCHAR(40),
  `sign_purchase_contract` VARCHAR(40),
  `sign_property_contract` VARCHAR(40),
  `intermediary_money` VARCHAR(40),
  `old_to_new` VARCHAR(200),
  `customer_ownership` VARCHAR(200),
  `available_sign_time` VARCHAR(40),
  `mortgage_handle` VARCHAR(40),
  `remark` VARCHAR(200),
  `block_flag`   TINYINT(1)  NOT NULL,
  `create_time`  DATETIME    NOT NULL,
  PRIMARY KEY (`deal_id`)
)
  ENGINE = InnoDB;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

