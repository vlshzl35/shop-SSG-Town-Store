package com.sh.admin.sales.controller;

import com.sh.admin.sales.model.dto.DailySalesDto;
import com.sh.admin.sales.model.dto.SalesDto;
import com.sh.admin.sales.model.service.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SalesController {
    private final SalesService salesService;

//    @GetMapping("/chart")
//    public String sales() {
//        return "sales/chart";
//    }

    @GetMapping(path="/chart", produces="application/json; charset=UTF-8")
    @ResponseBody
    public List<DailySalesDto> chart(){
        LocalDate endDate = LocalDate.now().minusDays(1);
        LocalDate startDate = LocalDate.now().minusMonths(1);

        // 기간동안 일별매출 조회
        List<DailySalesDto> dailySales = salesService.findDailySales(startDate, endDate);

        return dailySales;
        // 주간
    }
}
