package com.sh.admin.refund.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
