package com.sh.admin.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
@Slf4j
public class MemberController {

    @GetMapping("/list")
    public String list(Model model) {
        log.info("GET /order/list");
        return "/orderlist";
    }
}
