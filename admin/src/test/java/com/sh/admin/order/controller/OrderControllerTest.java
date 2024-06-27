package com.sh.admin.order.controller;

import com.sh.admin.order.model.dto.OrderDto;
import com.sh.admin.order.model.dto.OrderQuantityDto;
import com.sh.admin.order.model.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

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
   @Test
    public void orderQuantity() {
       int result=orderService.nowQuantity(10);
       System.out.println("result = " + result);
   }

   @Test
    public void insertSales() {

   }

}