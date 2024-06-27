package com.sh.admin.refund.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundDto {
    private long refundId;
    private long orderId;
    private String memberId;
    private int sumPrice;
    private RefundStatus refundStatus;
    private LocalDateTime lastUpdated;
    private LocalDateTime requestDate;
    private String description;
    private RefundReason refundReason;
    private String processed;

    public RefundDto(long refundId, long orderId, String memberId, int sumPrice, RefundStatus refundStatus, LocalDateTime lastUpdated, LocalDateTime requestDate, String description, RefundReason refundReason) {
        this.refundId = refundId;
        this.orderId = orderId;
        this.memberId = memberId;
        this.sumPrice = sumPrice;
        this.refundStatus = refundStatus;
        this.lastUpdated = lastUpdated;
        this.requestDate = requestDate;
        this.description = description;
        this.refundReason = refundReason;
    }
}
