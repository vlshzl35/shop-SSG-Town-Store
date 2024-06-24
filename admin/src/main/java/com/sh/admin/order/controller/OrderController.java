package com.sh.admin.order.controller;

import com.sh.admin.order.model.dto.OrderDto;
import com.sh.admin.order.model.dto.OrderItemDto;
import com.sh.admin.order.model.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.sh.admin.order.model.Status.OrderStatus.ORDER;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String list(Model model) {
//        List<OrderDto> orderList= orderService.findOrderList();

        //상세주문
        List<OrderItemDto> orderItemDtoList =new ArrayList<>(List.of(
                new OrderItemDto(1,1,1,10,25000),
                new OrderItemDto(2,1,2,5,25000),
                new OrderItemDto(3,1,3,7,25000)
        ));

        //상세 주문
        List<OrderItemDto> orderItemDtoList2 =new ArrayList<>(List.of(
                new OrderItemDto(1,2,3,16,25000),
                new OrderItemDto(2,2,64,13,50000),
                new OrderItemDto(3,2,32,21,50000)
        ));

        // 간략주문
        List<OrderDto> orderDtoList=new ArrayList<>(List.of(
                new OrderDto(1,1, LocalDate.of(2024,6,12),75_000,ORDER,0,null, orderItemDtoList),
                new OrderDto(2,123, LocalDate.of(2024,6,16),125_000,ORDER,0,null, orderItemDtoList2)
        ));

        model.addAttribute("orderList", orderDtoList);
        System.out.println("orderDtoList = " + orderDtoList);
        log.info("GET /order/list");
        return "order/orderlist";
    }

    @GetMapping("/detail")
    public void detail(Model model)
    {
        System.out.println("도착했어요");
        System.out.println("model = " + model);
    }
}
