package com.sh.admin.sales.controller;

import com.sh.admin.sales.model.dto.Sales;
import com.sh.admin.sales.model.service.SalesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SalesController {
    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/sales/top100")
    public String getSalesData(Model model) {
        List<Sales> salesList = salesService.getAllSales();
        model.addAttribute("salesList", salesList);
        return "sales/top100";
    }
}
