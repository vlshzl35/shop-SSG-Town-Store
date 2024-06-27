package com.sh.admin.sales.controller;

import com.sh.admin.sales.model.dto.SalesItemDTO;
import com.sh.admin.sales.model.service.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("/chart")
    public void sales(Model model) {
    }

    @GetMapping("/top100")
    public String getSalesData(Model model) {
        List<SalesItemDTO> salesData = salesService.getTopSalesItems();
        List<SalesItemDTO> resultAespaData = salesService.getArtistTopSalesItems("에스파");
        List<SalesItemDTO> resultShineeData = salesService.getArtistTopSalesItems("샤이니");
        List<SalesItemDTO> resultData = new ArrayList<>();

//        List<String> labels = new ArrayList<>();
//        List<Integer> data = new ArrayList<>();
        for (SalesItemDTO sale : salesData) {
            resultData.add(sale);
//            labels.add(sale.getItemName()); // item_name을 labels에 추가
//            data.add((int) sale.getTotalSales());     // sales_price를 data에 추가
        }
//        model.addAttribute("labels", labels);
//        model.addAttribute("data", data);
        model.addAttribute("resultData", resultData);
        model.addAttribute("resultAespaData", resultAespaData);
        model.addAttribute("resultShineeData", resultShineeData);
        return "sales/top100";
    }

}
