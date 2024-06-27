package com.sh.admin.order.controller;

import com.sh.admin.order.model.dto.OrderDto;
import com.sh.admin.order.model.dto.OrderItemDto;
import com.sh.admin.order.model.dto.OrderQuantityDto;
import com.sh.admin.order.model.service.OrderService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
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
        List<OrderDto> orderDtoList= orderService.findOrderList(); // 전체주문 불러오기

        model.addAttribute("orderList", orderDtoList);
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
            @RequestParam("orderId") String orderId){
        log.info(orderId);
        // 주문번호를 받았으니 orderDto값은 발송완료로 처리
        int shipmentOrderId=Integer.parseInt(orderId);
        int check;

        // orderId값으로 쿼리는 조회해서 재고를 가져와서 다시 상품으로 가서 재고를 감소하게 한다
        List<OrderItemDto> orderItemDtos = orderService.findByOrderItemDto(orderId); // 상세주문을 불러온다

        for(OrderItemDto orderItemDto : orderItemDtos) {
            int nowQuantity = orderService.nowQuantity(orderItemDto.getItemId()); // 현재재고
            if (orderItemDto.getItemQuantity() > nowQuantity) {
                int result = orderService.updateOrderStatus(orderItemDto.getOrderId());
                System.out.println("재고가 부족합니다");
                // alert 후, 전달된 url 파라미터로 이동시키는 페이지
                return "redirect:/order/list";
            }
        }

        for(OrderItemDto orderItemDto : orderItemDtos)
        {

                int itemId=orderItemDto.getItemId();
                int itemQuantity=orderItemDto.getItemQuantity();
                int shipmentResult= orderService.updateOrder(itemId,itemQuantity);
                int result=orderService.insertSales(orderItemDto);
                if(shipmentResult==1)
                {
                    System.out.println("result = " + result);
                    System.out.println("주문 번호 : "+orderItemDto.getOrderId());
                    System.out.println("제품 번호 : "+orderItemDto.getItemId());
                    System.out.println("재고량 감소 확인");
                }
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = now.format(formatter);
        System.out.println(formattedDateTime);
        long trackNumber=Long.parseLong(formattedDateTime);

        // 송장번호, 발송날짜 입력
        int result=orderService.shipmentByOrderId(shipmentOrderId,trackNumber,LocalDate.now());
        if(result==1)
            System.out.println("주문 번호 : "+orderId + " 발송처리 완료");
        return "redirect:/order/list";
    }

    @PostMapping({"/list/cancel"})
    public String cancel(
            @RequestParam("orderId") String orderId) {
        log.info(orderId);
        // orderId값으로 취소만 하면된다

        int cancelOrderId=Integer.parseInt(orderId);

        int result=orderService.orderCancelByOrderId(cancelOrderId, LocalDate.now());

        log.info("result = {}",result);
        System.out.println("취소완료 입니다");
        return "redirect:/order/list";
    }

}
