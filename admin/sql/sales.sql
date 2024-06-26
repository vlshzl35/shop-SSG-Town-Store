SET foreign_key_checks = 0;

select *
from tbl_order;

select *
from tbl_refund;

update tbl_refund
set refund_status = '환불요청'
where 1;

select *
from tbl_sales;

insert into tbl_sales
values (null, );

delete from tbl_sales
where refund_id = 4;

select *
from tbl_order;

select *
from tbl_orderitem;

select *
from tbl_item;

-- 주문 테이블 삽입
insert into tbl_order
values (null, )

-- 주문 상세 테이블 삽입
insert into tbl_orderitem (order_item_id, 'order_id', item_id, item_quantity, order_item_price)
values  (null, 'honggd', 1, 39000, 2024-05-20, 3, '발송완료', 12345678, 2024-05-20),
        (null, 'krong', 2, 35000, 2024-05-15, 1, '발송완료', 23456789, 2024-05-15),
        (null, 'krong', 4, 12000, 2024-05-10, 2, '발송완료', 34567890, 2024-05-10),
        (null, 'krong', 5, 66000, 2024-05-05, 4, '발송완료', 45678901, 2024-05-05),
        (null, 'honggd', 6, 12000, 2024-04-25, 1, '발송완료', 56789012, 2024-04-25),
        (null, 'rejamong', 8, 8000, 2024-04-20, 3, '발송완료', 67890123, 2024-04-20),
        (null, 'rejamong', 9, 56000, 2024-04-15, 2, '발송완료', 78901234, 2024-04-15),
        (null, 'rejamong', 11, 27500, 2024-04-10, 1, '발송완료', 89012345, 2024-04-10),
        (null, 'honggd', 12, 25000, 2024-04-05, 2, '발송완료', 90123456, 2024-04-05),
        (null, 'picachu', 13, 25000, 2024-03-25, 1, '발송완료', 01234567, 2024-03-25),
        (null, 'picachu', 14, 79000, 2024-03-20, 3, '발송완료', 12345678, 2024-03-20),
        (null, 'picachu', 15, 69000, 2024-03-15, 2, '발송완료', 23456789, 2024-03-15),
        (null, 'ponita', 16, 75000, 2024-03-10, 1, '발송완료', 34567890, 2024-03-10),
        (null, 'ponita', 17, 10000, 2024-03-05, 4, '발송완료', 45678901, 2024-03-05),
        (null, 'ponita', 18, 73000, 2024-02-25, 1, '발송완료', 56789012, 2024-02-25),
        (null, 'picachu', 19, 45000, 2024-02-20, 3, '발송완료', 67890123, 2024-02-20),
        (null, 'ponita', 1, 39000, 2024-02-15, 1, '발송완료', 78901234, 2024-02-15),
        (null, 'picachu', 2, 35000, 2024-02-10, 2, '발송완료', 89012345, 2024-02-10),
        (null, 'honggd', 4, 12000, 2024-02-05, 1, '발송완료', 90123456, 2024-02-05),
        (null, 'pairi', 5, 66000, 2024-01-25, 3, '발송완료', 01234567, 2024-01-25),
        (null, 'pairi', 6, 12000, 2024-01-20, 2, '발송완료', 12345678, 2024-01-20),
        (null, 'pairi', 8, 8000, 2024-01-15, 1, '발송완료', 23456789, 2024-01-15),
        (null, 'pairi', 9, 56000, 2024-01-10, 4, '발송완료', 34567890, 2024-01-10),
        (null, 'ggobugi', 11, 27500, 2024-01-05, 1, '발송완료', 45678901, 2024-01-05),
        (null, 'ggobugi', 12, 25000, 2023-12-25, 3, '발송완료', 56789012, 2023-12-25),
        (null, 'yadon', 13, 25000, 2023-12-20, 2, '발송완료', 67890123, 2023-12-20),
        (null, 'yadon', 14, 79000, 2023-12-15, 1, '발송완료', 78901234, 2023-12-15),
        (null, 'ggobugi', 15, 69000, 2023-12-10, 2, '발송완료', 89012345, 2023-12-10),
        (null, 'honggd', 16, 75000, 2023-12-05, 1, '발송완료', 90123456, 2023-12-05),
        (null, 'herry', 17, 10000, 2023-11-25, 4, '발송완료', 01234567, 2023-11-25),
        (null, 'herry', 18, 73000, 2023-11-20, 1, '발송완료', 12345678, 2023-11-20),
        (null, 'herry', 19, 45000, 2023-11-15, 2, '발송완료', 23456789, 2023-11-15),
        (null, 'yadon', 1, 39000, 2023-11-10, 1, '발송완료', 34567890, 2023-11-10),
        (null, 'yadon', 2, 35000, 2023-11-05, 3, '발송완료', 45678901, 2023-11-05),
        (null, 'jahndoe123', 4, 12000, 2023-11-01, 2, '발송완료', 56789012, 2023-11-01),
        (null, 'jahndoe123', 5, 66000, 2023-10-20, 1, '발송완료', 67890123, 2023-10-20),
        (null, 'jahndoe123', 6, 12000, 2023-10-15, 4, '발송완료', 78901234, 2023-10-15),
        (null, 'rejamong', 8, 8000, 2023-10-10, 1, '발송완료', 89012345, 2023-10-10),
        (null, 'jahndoe123', 9, 56000, 2023-10-05, 2, '발송완료', 90123456, 2023-10-05),
        (null, 'picachu', 11, 27500, 2023-09-25, 3, '발송완료', 01234567, 2023-09-25),
        (null, 'picachu', 12, 25000, 2023-09-20, 1, '발송완료', 12345678, 2023-09-20),
        (null, 'picachu', 13, 25000, 2023-09-15, 2, '발송완료', 23456789, 2023-09-15),
        (null, 'honggd', 14, 79000, 2023-09-10, 4, '발송완료', 34567890, 2023-09-10),
        (null, 'honggd', 15, 69000, 2023-09-05, 1, '발송완료', 45678901, 2023-09-05),
        (null, 'rejamong', 16, 75000, 2023-08-25, 3, '발송완료', 56789012, 2023-08-25),
        (null, 'krong', 17, 10000, 2023-08-20, 2, '발송완료', 67890123, 2023-08-20),
        (null, 'krong', 18, 73000, 2023-08-15, 1, '발송완료', 78901234, 2023-08-15),
        (null, 'yadon', 19, 45000, 2023-08-10, 4, '발송완료', 89012345, 2023-08-10),
        (null, 'ponita', 1, 39000, 2023-08-05, 1, '발송완료', 90123456, 2023-08-05),
        (null, 'krong', 2, 35000, 2023-07-25, 2, '발송완료', 01234567, 2023-07-25),
        (null, 'ponita', 4, 12000, 2023-07-20, 3, '발송완료', 12345678, 2023-07-20),
        (null, 'krong', 5, 66000, 2023-07-15, 1, '발송완료', 23456789, 2023-07-15),
        (null, 'medich', 6, 12000, 2023-07-10, 2, '발송완료', 34567890, 2023-07-10),
        (null, 'honggd', 8, 8000, 2023-07-05, 4, '발송완료', 45678901, 2023-07-05),
        (null, 'honggd', 9, 56000, 2023-06-25, 1, '발송완료', 56789012, 2023-06-25),
        (null, 'honggd', 11, 27500, 2023-06-20, 3, '발송완료', 67890123, 2023-06-20),
        (null, 'pairi', 12, 25000, 2023-06-15, 2, '발송완료', 78901234, 2023-06-15),
        (null, 'pairi', 13, 25000, 2023-06-10, 1, '발송완료', 89012345, 2023-06-10),
        (null, 'herry', 14, 79000, 2023-06-05, 4, '발송완료', 90123456, 2023-06-05),
        (null, 'herry', 15, 69000, 2023-06-01, 2, '발송완료', 01234567, 2023-06-01);

'honggd',
'krong', 2
'krong', 4
'krong', 5
'honggd',
'rejamong'
'rejamong'
'rejamong'
'honggd',
'picachu',
'picachu',
'picachu',
'ponita',
'ponita',
'ponita',
'picachu',
'ponita',
'picachu',
'honggd',
'pairi', 5
'pairi', 6
'pairi', 8
'pairi', 9
'ggobugi',
'ggobugi',
'yadon', 1
'yadon', 1
'ggobugi',
'honggd',
'herry', 1
'herry', 1
'herry', 1
'yadon', 1
'yadon', 2
'jahndoe12
'jahndoe12
'jahndoe12
'rejamong'
'jahndoe12
'picachu',
'picachu',
'picachu',
'honggd',
'honggd',
'rejamong'
'krong', 1
'krong', 1
'yadon', 1
'ponita',
'krong', 2
'ponita',
'krong', 5
'medich',
'honggd',
'honggd',
'honggd',
'pairi', 1
'pairi', 1
'herry', 1
'herry', 1

select *
from tbl_order;

select *
from tbl_sales;