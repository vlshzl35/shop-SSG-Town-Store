package com.sh.admin.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private int orderItemId; // 주문상세 id _ autoincrement
    private int orderId; // 주문id
    private int itemId; // 상품 id
    private int itemQuantity; // 수량
    private int orderItemPrice; // 수량 * 제품가격
}
