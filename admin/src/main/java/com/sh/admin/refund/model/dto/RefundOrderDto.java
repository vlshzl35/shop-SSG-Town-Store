package com.sh.admin.refund.model.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundOrderDto {
    private String memberId;
    private int sumPrice;
    private RefundOrderStatus refundOrderStatus;
}
