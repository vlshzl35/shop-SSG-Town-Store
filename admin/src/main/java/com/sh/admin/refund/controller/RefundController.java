package com.sh.admin.refund.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class RefundController {
    @GetMapping("/refund/refundlist")
    public String refundList() {
        return "refund/refundlist";
    }
}
