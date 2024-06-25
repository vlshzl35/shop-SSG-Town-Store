package com.sh.admin.refund.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundSalesDto {
    private long salesId;
    private long orderId;
    private long orderItemId;
    private long refundId;
    private int salesPrice;
}
