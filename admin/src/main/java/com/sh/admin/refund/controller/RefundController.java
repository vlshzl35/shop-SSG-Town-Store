package com.sh.admin.refund.controller;

import com.sh.admin.refund.model.dto.*;
import com.sh.admin.refund.model.service.RefundCommandService;
import com.sh.admin.refund.model.service.RefundQueryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.net.http.HttpResponse;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/refund")
public class RefundController {

    private final RefundQueryService refundQueryService;
    private final RefundCommandService refundCommandService;

    @GetMapping("/list")
    public String refundList(Model model,
                             HttpSession httpSession) {
        List<RefundDto> refunds = refundQueryService.findAll();
        refunds.forEach((refund) -> {
            if (!(refund.getRefundStatus() == RefundStatus.환불요청)) {
                refund.setProcessed("disabled"); // 환불요청이 아닌 것들 -> 환불완료, 환불취소의 경우에는 처리 불가를 표시한다.
            }
        });
        model.addAttribute("refunds", refunds);
        String adminName = (String) httpSession.getAttribute("adminName");
        model.addAttribute("adminName", adminName);
        return "refund/list";
    }

    @PostMapping("/list")
    public String refundListByCondition(@ModelAttribute SearchDto searchDto,
                                        Model model,
                                        HttpSession httpSession) {
        log.info("{}", searchDto);
        List<RefundDto> refunds2 = refundQueryService.findByCondition(searchDto);
        refunds2.forEach((refund) -> {
            if (!(refund.getRefundStatus() == RefundStatus.환불요청)) {
                refund.setProcessed("disabled"); // 환불요청이 아닌 것들 -> 환불완료, 환불취소의 경우에는 처리 불가를 표시한다.
            }
        });
        model.addAttribute("refunds", refunds2);
        String adminName = (String) httpSession.getAttribute("adminName");
        model.addAttribute("adminName", adminName);
        return "refund/list";
    }

    @GetMapping({"/list/accept", "accept?refundId={refundId}&orderId={orderId}"})
    public String acceptRefund(
            @RequestParam("refundId") String refundId,
            @RequestParam("orderId") String orderId,
            Model model,
            RedirectAttributes redirectAttributes) {
        log.info(orderId, refundId);
        // 주문번호로 주문 테이블 조회
        RefundOrderDto refundOrderDto = refundQueryService.findOrder(Long.parseLong(orderId));
        // 주문번호로 주문 테이블 상태 업데이트
        int updateOrderResult = refundCommandService.updateOrder(Long.parseLong(orderId), RefundOrderStatus.환불완료);
        // 주문번호로 주문 상세 테이블 상품 조회
        List<RefundItemDto> refundItems = refundQueryService.findOrderItem(Long.parseLong(orderId));
        // 상품 리스트에 대해 반복 처리
        // 상품 테이블에 수량 추가 업데이트
//        refundItems.forEach((item) -> refundCommandService.updateProduct(item.getItemId(), item.getItemQuantity()));
        // 매출 테이블에 환불 주문 상세 단위로 삽입
        refundItems.forEach((item) -> refundCommandService.insertSales(new RefundSalesDto(0, Long.parseLong(orderId), item.getItemId(), Long.parseLong(refundId), item.getOrderItemPrice() * (-1))));
        // 환불번호로 환불 테이블 상태 업데이트
        int updateRefundResult = refundCommandService.update(Long.parseLong(refundId), RefundStatus.환불완료);
        log.debug("{}, {} -- 모두 1이면 환불 성공", updateRefundResult, updateOrderResult);
        redirectAttributes.addFlashAttribute("message", "환불처리 되었습니다.");
        return "redirect:/refund/list";
    }

    @GetMapping({"/list/deny", "deny?refundId={refundId}"})
    public String denyRefund(
            @RequestParam("refundId") String refundId,
            Model model,
            RedirectAttributes redirectAttributes) {
        log.info(refundId);
        // 환불번호로 환불 테이블 상태 업데이트
        int updateRefundResult = refundCommandService.update(Long.parseLong(refundId), RefundStatus.환불취소);
        log.debug("{} -- 1이면 환불 성공", updateRefundResult);
        redirectAttributes.addFlashAttribute("message", "환불취소 되었습니다.");
        return "redirect:/refund/list";
    }
}
