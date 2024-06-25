package com.sh.admin.order.controller;

import com.sh.admin.order.model.dto.OrderDto;
import com.sh.admin.order.model.dto.OrderItemDto;
import com.sh.admin.order.model.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.sh.admin.order.model.Status.OrderStatus.발송완료;
import static com.sh.admin.order.model.Status.OrderStatus.주문요청;


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
        List<OrderDto> orderDtoList= orderService.findOrderList();
        System.out.println(orderDtoList);

        model.addAttribute("orderList", orderDtoList);
        System.out.println("orderDtoList = " + orderDtoList);
        log.info("GET /order/list");
        return "order/orderlist";
    }

    @GetMapping("/detail/{orderId}")
    public void detail(@PathVariable int orderId, Model model)
    {
        log.info("GET/detail/{}",orderId);
        List<OrderItemDto> orderItemDtos=orderService.findByOrderId(orderId);
        System.out.println("도착했어요");
        System.out.println("model = " + model);
        model.addAttribute("orderItemDto",orderItemDtos);
    }
}
