package com.sh.admin.refund.controller;

import com.sh.admin.refund.model.dto.RefundDto;
import com.sh.admin.refund.model.service.RefundQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/refund")
public class RefundController {

    private final RefundQueryService refundQueryService;

    @GetMapping("/list")
    public String refundList(Model model) {
        List<RefundDto> refunds = refundQueryService.findAll();
        model.addAttribute("refunds", refunds);
        return "refund/list";
    }
}
