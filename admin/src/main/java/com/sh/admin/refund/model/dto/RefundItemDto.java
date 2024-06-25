package com.sh.admin.refund.model.dto;

import lombok.*;

// 주문상세 테이블
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RefundItemDto {
    private long itemId;
    private int itemQuantity;
    private int orderItemPrice;
}
