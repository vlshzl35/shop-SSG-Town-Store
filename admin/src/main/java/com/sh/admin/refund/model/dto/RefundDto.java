package com.sh.admin.refund.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundDto {
    private Long refundId;
    private Long orderId;
    private String memberId;
    private int sumPrice;
    private RefundStatus refundStatus;
    private LocalDateTime lastUpdated;
    private LocalDateTime requestDate;
    private String description;
    private RefundReason refundReason;
}
