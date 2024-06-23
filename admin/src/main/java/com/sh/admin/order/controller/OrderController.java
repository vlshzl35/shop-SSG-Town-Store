package com.sh.admin.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.multi.MultiColorChooserUI;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @GetMapping("/list")
    public String list(Model model) {
        log.info("GET /order/list");
        return "/orderlist";
    }
}
