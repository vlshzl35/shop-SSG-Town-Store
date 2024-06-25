package com.sh.admin.order.model.dto;

import com.sh.admin.order.model.Status.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int orderId; // 주문 Id
    private String memberId; // 회원 Id
    private LocalDate orderDate; // 주문날짜
    private int sumPrice; // 주문합계
    private OrderStatus orderStatus; // 주문상태 (주문요청, 발송완료, 재고부족, 주문취소, 환불완료)
    private long trackNumber; // 송장번호
    private LocalDate shipmentDate; // 발송날짜

    private List<OrderItemDto> orderItemDtos;

}
