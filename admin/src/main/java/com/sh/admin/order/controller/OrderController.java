package com.sh.admin.order.controller;

import com.sh.admin.order.model.dto.OrderDto;
import com.sh.admin.order.model.dto.OrderItemDto;
import com.sh.admin.order.model.service.OrderService;
import com.sh.admin.refund.model.dto.RefundStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String  detail(@PathVariable int orderId, Model model)
    {
        log.info("GET/detail/{}",orderId);
        List<OrderItemDto> orderItemDtos=orderService.findByOrderId(orderId);
        System.out.println("도착했어요-----------------");
        model.addAttribute("orderItemDto",orderItemDtos);
        return "order/detail";
    }

    @PostMapping("/list/shipment")
    public void shipment( @RequestParam(value = "orderId") String  orderId){
        log.debug("order = {}",orderId);
        System.out.println("발송왔어요");
        System.out.println("orderId = " + orderId);
    }

//    @GetMapping({"/list/shipment", "shipment?orderId={orderId}"})
//    public String shipment(
//            @RequestParam("orderId") String orderId,
//            Model model) {
//        log.info(orderId);
//        // 환불번호로 환불 테이블 상태 업데이트
//
//        return "redirect:/order/list";
//    }
}
