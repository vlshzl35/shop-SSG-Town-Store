package com.sh.admin.refund.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
    private String requestDate;
    private RefundStatus refundStatus1;
    private RefundStatus refundStatus2;
    private RefundStatus refundStatus3;
    private String refundRequester;
}
