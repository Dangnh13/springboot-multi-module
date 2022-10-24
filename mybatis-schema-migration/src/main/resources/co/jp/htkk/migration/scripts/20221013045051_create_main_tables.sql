--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // create_main_tables
-- Migration SQL that makes the change goes here.

CREATE TABLE `step` (
	`step_id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT NOT NULL,
	`step_count` INT,
	`sync_time` TIMESTAMP NOT NULL,
	`device_id` VARCHAR ( 255 ) NOT NULL,
	`kcal` INT,
	`distance` INT,
	`total_time` BIGINT,
	`step_type` SMALLINT DEFAULT 1 NOT NULL,
	`created_by` BIGINT NOT NULL,
	`created_at` TIMESTAMP NOT NULL,
	`updated_by` BIGINT NOT NULL,
	`updated_at` TIMESTAMP NOT NULL,
	`del_flag` SMALLINT DEFAULT 0,
	PRIMARY KEY ( `step_id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER
SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

CREATE TABLE `daily_point` (
	`daily_point_id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT NOT NULL,
	`step_count` INT,
	`sync_date` VARCHAR ( 10 ) NOT NULL,
	`device_id` VARCHAR ( 255 ) NOT NULL,
	`kcal` INT,
	`distance` INT,
	`total_time` BIGINT,
	`earn_point` INT,
	`step_event` INT,
	`point_event` SMALLINT,
	`created_by` BIGINT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_by` BIGINT NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `del_flag` SMALLINT DEFAULT 0,
	PRIMARY KEY ( `daily_point_id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER
SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

CREATE TABLE `monthly_point` (
	`monthly_point_id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT NOT NULL,
	`step_count` INT,
	`month` VARCHAR ( 6 ) NOT NULL,
	`kcal` INT,
	`distance` INT,
	`total_time` BIGINT,
	`earn_point` INT,
	`used_point` INT,
	`revocation_point` INT,
	`rest_point` INT,
	`step_event` INT,
    `point_event` SMALLINT,
	`created_by` BIGINT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_by` BIGINT NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `del_flag` SMALLINT DEFAULT 0,
	PRIMARY KEY ( `monthly_point_id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER
SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

CREATE TABLE `change_point_history` (
	`change_point_history_id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT NOT NULL,
	`amount_point` INT NOT NULL,
	`action_type` SMALLINT NOT NULL,
	`created_by` BIGINT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_by` BIGINT NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `del_flag` SMALLINT DEFAULT 0,
	PRIMARY KEY ( `change_point_history_id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER
SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

CREATE TABLE `transaction_point` (
	`transaction_point_id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT NOT NULL,
	`transaction_type` SMALLINT NOT NULL,
	`amount_point` INT,
	`transaction_status` SMALLINT NOT NULL,
	`transaction_time` TIMESTAMP NOT NULL,
	`device_id` VARCHAR ( 255 ) NOT NULL,
	`system_os` VARCHAR ( 255 ) NOT NULL,
	`created_by` BIGINT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_by` BIGINT NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `del_flag` SMALLINT DEFAULT 0,
	PRIMARY KEY ( `transaction_point_id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER
SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

CREATE TABLE `transaction_point_history` (
	`transaction_point_history_id` BIGINT NOT NULL AUTO_INCREMENT,
	`transaction_point_id` BIGINT NOT NULL,
	`user_id` BIGINT NOT NULL,
	`transaction_time` TIMESTAMP NOT NULL,
	`transaction_type` SMALLINT NOT NULL,
	`amount_point` INT,
	`transaction_status` SMALLINT NOT NULL,
	`device_id` VARCHAR ( 255 ) NOT NULL,
	`total_point` INT,
	`rest_point` INT,
	`message` TEXT,
	`created_by` BIGINT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_by` BIGINT NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `del_flag` SMALLINT DEFAULT 0,
	PRIMARY KEY ( `transaction_point_history_id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER
SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

CREATE TABLE `user` (
	`user_id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR ( 255 ) NOT NULL,
	`contract_no` VARCHAR ( 255 ) NOT NULL,
	`contract_status` SMALLINT NOT NULL,
	`contract_term` SMALLINT NOT NULL,
	`phone_number` VARCHAR ( 20 ) NOT NULL,
	`email` VARCHAR ( 255 ) NOT NULL,
	`contract_time_start` TIMESTAMP,
	`contract_time_end` TIMESTAMP,
	`invitation_code` VARCHAR ( 20 ),
	`group_number` SMALLINT,
	`created_by` BIGINT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_by` BIGINT NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `del_flag` SMALLINT DEFAULT 0,
	PRIMARY KEY ( `user_id` )
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER
SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE `user`;
DROP TABLE `transaction_point_history`;
DROP TABLE `transaction_point`;
DROP TABLE `monthly_point`;
DROP TABLE `change_point_history`;
DROP TABLE `daily_point`;
DROP TABLE `step`;
