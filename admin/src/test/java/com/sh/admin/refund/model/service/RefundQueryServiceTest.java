package com.sh.admin.refund.model.service;

import com.sh.admin.refund.model.dao.RefundMapper;
import com.sh.admin.refund.model.dto.RefundDto;
import com.sh.admin.refund.model.dto.RefundItemDto;
import com.sh.admin.refund.model.dto.RefundOrderDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.engine.IterationStatusVar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RefundQueryServiceTest {

    @Autowired
    RefundMapper refundMapper;

    @Test
    @DisplayName("전체 환불 조회")
    public void findAll() {
        List<RefundDto> refunds = refundMapper.findAll();
        refunds.forEach((refund) -> {
            System.out.println(refund.getOrderId());});
        assertThat(refunds).isNotNull();
    }

    @Test
    @DisplayName("환불할 주문 조회")
    public void findOrder() {
        RefundOrderDto refundOrderDto = refundMapper.findOrder(1);
        System.out.println(refundOrderDto.getMemberId());
        assertThat(refundOrderDto).isNotNull();
    }

    @Test
    @DisplayName("환불할 주문 상품 조회")
    public void findOrderItem() {
        List<RefundItemDto> refundItems = refundMapper.findOrderItem(1);
        refundItems.forEach((item) -> {
            System.out.println(item.getItemId());});
        assertThat(refundItems).isNotNull();
    }

}