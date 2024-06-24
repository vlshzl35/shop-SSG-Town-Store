select *
from tbl_order;

select *
from tbl_orderitem;

insert into tbl_refund
values (null, 1, 'cstangga', 156000, '환불요청', null, now(), '옷에 구멍이 나있습니다.', '상품불량');
