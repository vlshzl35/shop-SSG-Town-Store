use ssgtowndb;
select item_id,category_name, quantity, sale_price, sale_status
from tbl_item
where sale_status='판매중';

select *
from tbl_member;

select *
from tbl_order;

select *
from tbl_orderitem
where order_id=1;

insert into tbl_order(member_id, order_date, sum_price, order_status, track_number, shipment_date )
values ('cstangga','2024-06-17',156000,'주문요청',null,null);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (1, 1,1,39000);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (1, 2,3,35000*3);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (1, 6,1,12000);
# 위에는 오더넘버1, 아래는 오더넘버2
insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (2, 1,1,39000);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (2, 2,3,35000*3);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (2, 6,1,12000);




insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('cstangga', '최창욱','M','1992-02-24','서울시 강동구 고덕로','cstangga@naver.com',LOCALTIME,'1103385090','N')


insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('honggd', '홍길동','M','1943-02-24','전라도 장성현 아차곡','honggd@naver.com',LOCALTIME,'11579895','N');

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('leess', '이순신','M','1545-07-24','조선시대 정읍현감','leess@naver.com',LOCALTIME,'1778849895','N');