insert into tbl_refund
values (null, 1, 'cstangga', 156000, '환불요청', null, now(), '옷에 구멍이 나있습니다.', '상품불량');

-- 27번 16500원
-- 21번 74000원

insert into tbl_order
values (null, 'honggd', now(), 90500, '발송완료', 11111111, now());

insert into tbl_orderitem
values (null, 3, 27, 1, 16500),
       (null, 3, 21, 1, 74000);

insert into tbl_refund
values (null, 3, 'honggd', 90500, '환불요청', null, now(), '씨디에 스크래치가 있어요!!!ㅡㅡ', '상품불량');

select *
from tbl_order;

