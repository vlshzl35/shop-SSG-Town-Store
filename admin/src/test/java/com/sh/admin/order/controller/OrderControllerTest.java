package com.sh.admin.order.controller;

import com.sh.admin.order.model.dto.OrderDto;
import com.sh.admin.order.model.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderControllerTest {

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("전체메뉴 불러오기")
    void orderDto() {
        // given

        List<OrderDto> orderList= orderService.findOrderList();
        System.out.println(orderList);

        // when
        // then
    }

}