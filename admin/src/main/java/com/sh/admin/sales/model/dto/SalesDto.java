package com.sh.admin.sales.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesDto {
    private long salesId;
    private long orderId;
    private long orderItemId;
    private long refundId;
    private long salesPrice;
    private LocalDateTime lastUpdated;
}
