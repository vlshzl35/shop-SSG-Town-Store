package com.sh.admin.refund.model.service;

import com.sh.admin.refund.model.dto.RefundOrderStatus;
import com.sh.admin.refund.model.dto.RefundSalesDto;
import com.sh.admin.refund.model.dto.RefundStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RefundCommandServiceTest {

    @Autowired
    RefundCommandService refundCommandService;
    RefundStatus refundStatus;
    RefundOrderStatus refundOrderStatus;

    @Test
    @DisplayName("환불 테이블 상태 업데이트")
    void test1(){
        int result = refundCommandService.update(1L, refundStatus.환불완료);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("주문 테이블 상태 업데이트")
    void test2() {
        int result = refundCommandService.updateOrder(1, refundOrderStatus.환불완료);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("매출 테이블 환불 상품 삽입")
    void test3(){
        RefundSalesDto refundSalesDto = new RefundSalesDto(0, 1, 2, 1, 5000);
        int result = refundCommandService.insertSales(refundSalesDto);
        assertThat(result).isEqualTo(1);
    }

}