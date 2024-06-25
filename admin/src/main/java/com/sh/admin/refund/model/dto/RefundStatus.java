package com.sh.admin.refund.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

public enum RefundStatus {
    환불요청, 환불완료, 환불취소;
}
