package com.sh.admin.order.controller;

import com.sh.admin.order.model.dto.OrderDto;
import com.sh.admin.order.model.dto.OrderItemDto;
import com.sh.admin.order.model.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


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


    @PostMapping({"/list/shipment"})
    public String shipment(
            @RequestParam("orderId") String orderId) {
        log.info(orderId);
        // 주문번호를 받았으니 orderDto값은 발송완료로 처리
        int shipmentOrderId=Integer.parseInt(orderId);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = now.format(formatter);
        System.out.println(formattedDateTime);
        long trackNumber=Long.parseLong(formattedDateTime);
        //
        int result=orderService.shipmentByOrderId(shipmentOrderId,trackNumber,LocalDate.now());




        // orderId값으로 쿼리는 조회해서 재고를 가져와서 다시 상품으로 가서 재고를 감소하게 한다

        System.out.println("발송완료 입니다");
        return "redirect:/order/list";
    }

    @PostMapping({"/list/cancel"})
    public String cancel(
            @RequestParam("orderId") String orderId) {
        log.info(orderId);
        // orderId값으로 취소만 하면된다
        int cancelOrderId=Integer.parseInt(orderId);
        int result=orderService.orderCancelByOrderId(cancelOrderId);
        log.info("result = {}",result);
        System.out.println("취소완료 입니다");
        return "redirect:/order/list";
    }

}
