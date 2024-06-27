package com.sh.admin.sales.controller;

import com.sh.admin.sales.model.dto.SalesDTO;
import com.sh.admin.sales.model.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("/sales/top100")
    public String getSalesData(Model model) {
        List<SalesDTO> salesData = salesService.getTopSalesItems();

        List<SalesDTO> resultData = new ArrayList<>();

//        List<String> labels = new ArrayList<>();
//        List<Integer> data = new ArrayList<>();
        for (SalesDTO sale : salesData) {

            resultData.add(sale);
//            labels.add(sale.getItemName()); // item_name을 labels에 추가
//            data.add((int) sale.getTotalSales());     // sales_price를 data에 추가
        }
//        model.addAttribute("labels", labels);
//        model.addAttribute("data", data);

        model.addAttribute("resultData", resultData);
        return "sales/top100";
    }

}
