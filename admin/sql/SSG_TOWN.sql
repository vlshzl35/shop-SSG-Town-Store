DROP TABLE IF EXISTS tbl_order;
DROP TABLE IF EXISTS tbl_refund;
DROP TABLE IF EXISTS tbl_member;
DROP TABLE IF EXISTS tbl_item;
DROP TABLE IF EXISTS tbl_admin;
DROP TABLE IF EXISTS tbl_orderItem;
DROP TABLE IF EXISTS tbl_daily_sales;
DROP TABLE IF EXISTS tbl_sales;

CREATE TABLE `tbl_member` (
                              `member_id`	VARCHAR(10)	NOT NULL	COMMENT 'ex) yeahjin311',
                              `member_name`	VARCHAR(10)	NOT NULL,
                              `member_gender`	ENUM('M', 'F')	NOT NULL,
                              `member_birth`	varchar(20)	NOT NULL,
                              `member_address`	VARCHAR(20)	NOT NULL,
                              `member_email`	VARCHAR(20)	NOT NULL,
                              `created_at`	DATETIME	NOT NULL,
                              `member_bank`	varchar(10)	NOT NULL,
                              `member_account`	varchar(20)	NOT NULL,
                              `member_status`	ENUM('Y', 'N')	NOT NULL	DEFAULT 'N'	COMMENT '탈퇴유무 : Y=탈퇴',
                              PRIMARY KEY (`member_id`)



);

CREATE TABLE `tbl_order` (
                             `order_id` BIGINT NOT NULL AUTO_INCREMENT,
                             `member_id` VARCHAR(10) NOT NULL,
                             `order_date` DATETIME NOT NULL COMMENT '회원이 주문한 날짜',
                             `sum_price` INT NOT NULL,
                             `order_status` ENUM('주문요청', '발송완료', '재고부족', '주문취소', '환불완료') NOT NULL COMMENT '주문요청, 발송완료, 재고부족, 주문취소, 환불완료',
                             `track_number` BIGINT NULL ,
                             `shipment_date` DATE NOT NULL,
                             PRIMARY KEY (`order_id`),
                             UNIQUE KEY (`track_number`),
                             CONSTRAINT `fk_member_id` FOREIGN KEY (`member_id`) REFERENCES `tbl_member`(`member_id`)
);


CREATE TABLE `tbl_refund` (
                              `refund_id`	bigint	NOT NULL AUTO_INCREMENT,
                              `order_id`	bigint	NOT NULL ,
                              `member_id`	VARCHAR(10)	NOT NULL,
                              `sum_price`	int	NOT NULL,
                              `refund_status`	ENUM('환불요청','환불완료','환불취소')	NOT NULL	COMMENT '환불요청,환불완료,환불취소',
                              `last_updated`	DateTime	NULL	COMMENT '상태 update날짜',
                              `request_date`	DateTime	NOT NULL,
                              `description`	varchar(200)	NULL	COMMENT '환불사유 + 설명 (고객입력)',
                              `reason`	ENUM('단순변심','상품불량')	NOT NULL	COMMENT '단순변심,상품불량',
                              PRIMARY KEY (`refund_id`),
                              CONSTRAINT `fk_refund_member_id` FOREIGN KEY (`member_id`) REFERENCES `tbl_member`(`member_id`),
                              CONSTRAINT `fk_refund_order_id` FOREIGN KEY (`order_id`) REFERENCES `tbl_order`(`order_id`)

);

CREATE TABLE `tbl_item` (
                            `item_id` bigint NOT NULL AUTO_INCREMENT,
                            `item_name` varchar(30) NOT NULL,
                            `category_name` ENUM('CD','응원봉','의류','잡화') NOT NULL COMMENT 'CD,응원봉,의류,잡화',
                            `artist_name` ENUM('에스파','샤이니') NOT NULL COMMENT '에스파/샤이니',
                            `img_url` varchar(100) NOT NULL,
                            `seller` varchar(30) NOT NULL DEFAULT 'SSG',
                            `details` varchar(255) NULL,
                            `quantity` int NOT NULL,
                            `sale_price` int NOT NULL,
                            `sale_status` ENUM('판매중','품절','판매중지') NOT NULL COMMENT '판매중/품절/판매중지',
                            PRIMARY KEY (`item_id`)
);


CREATE TABLE `tbl_admin` (
                             `admin_id`	VARCHAR(10)	NOT NULL	COMMENT 'ex) wook123',
                             `admin_name`	VARCHAR(10)	NOT NULL	COMMENT '로그인됐을때 이름',
                             `admin_pw`	VARCHAR(10)	NOT NULL,
                             `created_at`	DateTIME	NOT NULL,
                             PRIMARY KEY (`admin_id`)


);

CREATE TABLE `tbl_orderItem` (
                                 `order_item_id`	bigint	NOT NULL	AUTO_INCREMENT,
                                 `order_id`	bigint	NOT NULL	COMMENT 'Comment',
                                 `item_id`	bigint	NOT NULL,
                                 `item_quantity`	int	NOT NULL,
                                 `order_item_price`	int	NOT NULL	COMMENT '수량 * 판매가',
                                 PRIMARY KEY (`order_item_id`),
                                 CONSTRAINT `fk_orderItem_member_id` FOREIGN KEY (`item_id`) REFERENCES `tbl_item`(`item_id`),
                                 CONSTRAINT `fk_orderItem_order_id` FOREIGN KEY (`order_id`) REFERENCES `tbl_order`(`order_id`)


);

CREATE TABLE `tbl_daily_sales` (
                                   `date`	date	NOT NULL COMMENT '날짜기준이여서DATE',
                                   `daily_sale`	bigint	NOT NULL	COMMENT '오늘거는 안들어감',
                                   PRIMARY KEY (`date`)
);

CREATE TABLE `tbl_sales` (
                             `sales_id`	bigint	NOT NULL AUTO_INCREMENT,
                             `order_id`	bigint	NOT NULL	 ,
                             `order_item_id`	bigint	NULL	,
                             `refund_id`	bigint	NULL	 ,
                             `sales_price`	bigint	NOT NULL 	COMMENT '주문상세의가격 +, -',
                             `last_updated`	DateTIME	NULL,
                             PRIMARY KEY (`sales_id`),
                             CONSTRAINT `fk_sales_item_id` FOREIGN KEY (`order_item_id`) REFERENCES `tbl_orderitem`(`item_id`),
                             CONSTRAINT `fk_sales_order_id` FOREIGN KEY (`order_id`) REFERENCES `tbl_order`(`order_id`),
                             CONSTRAINT `fk_sales_refund_id` FOREIGN KEY (`refund_id`) REFERENCES `tbl_refund`(`refund_id`)

);
