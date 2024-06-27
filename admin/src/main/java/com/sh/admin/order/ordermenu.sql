use ssgtowndb;
select *
from tbl_order
order by order_date desc ;

select *
from tbl_orderitem join tbl_item on tbl_orderitem.item_id = tbl_item.item_id
where order_id=1;

update tbl_order
set order_status='발송완료',track_number=#{trackNumber}, shipment_date = #{shipmentDate},
where order_id=6;

select *
from tbl_orderitem
where order_id=5;

select *
from tbl_item;

update tbl_item
set quantity = quantity-#{itemQuantity}
where item_id=#{itemId};

select
    *
from
    tbl_orderitem join tbl_item on tbl_orderitem.item_id = tbl_item.item_id
where
    order_id=5;

select tbl_order.order_id, member_id, order_date, sum_price, order_status, track_number, shipment_date, order_item_id,tbl_order.order_id, item_id, item_quantity, order_item_price
from tbl_order join tbl_orderitem on tbl_order.order_id = tbl_orderitem.order_id
where tbl_order.order_id=3 ;

select *
from tbl_orderitem;

select *
from tbl_item
where item_id=1;

select item_id, sale_price
from tbl_item
where sale_status !='품절';

select *
from tbl_order;

select *
from tbl_order join ssgtowndb.tbl_orderitem t on tbl_order.order_id = t.order_id;

select sum(order_item_price)
from tbl_orderitem
where order_id=7;

select item_id, sale_price, quantity
from tbl_item
where sale_status='판매중';



select *
from tbl_orderitem
where order_id=22;

select *
from tbl_order;

insert into tbl_order(member_id, order_date, sum_price, order_status, track_number, shipment_date )
values ('eve','2024-4-17 21:18:20',8000,'주문요청',null,null);

SET @`orderid` = 24;

update tbl_order
set sum_price = (select sum(order_item_price)
                 from tbl_orderitem
                 where order_id=@orderid)
where order_id=@orderid;

select sum(order_item_price)
from tbl_orderitem
where order_id=@orderid;

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (24, 27,1,
        (select sale_price
        from tbl_item
        where item_id=@orderid
        )*1);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (@orderid, 18,2,(select sale_price
                from tbl_item
                where item_id=18
               )*2);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (@orderid, 20,1,(select sale_price
                from tbl_item
                where item_id=20
               )*1);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (15, 27,1,(select sale_price
                from tbl_item
                where item_id=27
               )*1);

# 위에는 오더넘버1, 아래는 오더넘버2
insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (2, 1,1,39000);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (2, 2,3,35000*3);

insert into tbl_orderitem( order_id, item_id, item_quantity, order_item_price)
values (2, 6,1,12000);

select *
from tbl_orderitem;

select *
from tbl_item
where item_id=#{itemId};

select item_quantity
from
    tbl_orderitem
where order_item_id=5;


select
    *
from
    tbl_orderitem;
select
    *
from
    tbl_item
where
    item_id=1
update tbl_order
set order_status='재고부족'
where order_id=1;
select *
from tbl_member;

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('agumon', '아구몬', 'F', '2018-05-15', '찾아라 비밀의 열쇠', 'agumon@example.com', '2024-06-25 10:15:00', 'BankRV', '13276546');


insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('honggd', '홍길동','M','1943-02-24','전라도 장성현 아차곡','honggd@naver.com',LOCALTIME,'11579895','N');

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('wargraimon', '워그레이몬','M','2009-07-24','디지털 워그레이몬','wargraimon@naver.com',LOCALTIME,'디지털AEW',321654687);

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('angelmon', '엔젤몬','F','2009-07-24','남자들은 빠져 있어','angelmon@naver.com',LOCALTIME,'디지털BD',348784654654);

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('skalmon', '스컬몬','M','2002-07-24','남자들은 빠져 있어','skalmon@naver.com',LOCALTIME,'디지털MD',348754654);

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('graimon', '스컬몬', 'M', '2002-07-24', '나도 진화할꺼야', 'graimon@naver.com', LOCALTIME, '디지털MD', 2598798465);

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('gilmon', '길몬', 'M', '2022-07-24', '나는 빨간 아구몬이다', 'gilmon@naver.com', LOCALTIME, '디지털AN', 9849816515);

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('pinokimon', '피노키몬', 'M', '2022-07-24', '나는 코가 긴 피노키몬', 'pinokimon@naver.com', LOCALTIME, '디지털CD', 365989878);

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('a', '피노키몬', 'M', '2022-07-24', '나는 코가 긴 피노키몬', 'pinokimon@naver.com', LOCALTIME, '디지털CD', 365989878);

insert into tbl_member(member_id, member_name, member_gender, member_birth, member_address, member_email, created_at, member_bank, member_account)
values ('a', '피노키몬', 'M', '2022-07-24', '나는 코가 긴 피노키몬', 'pinokimon@naver.com', LOCALTIME, '디지털CD', 365989878);

insert into tbl_sales(order_id, order_item_id, refund_id, sales_price, last_updated)
values (#{orderId},#{orderItemId},null,#{상품 가격},localDate.now)
select *
from tbl_orderitem
where order_id=1;

select *
from tbl_order;

select item_id,order_id
from tbl_orderitem;

select *
from tbl_member;

select *
from s;