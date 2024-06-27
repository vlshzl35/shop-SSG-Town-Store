package com.sh.admin.sales.controller;

import com.sh.admin.sales.model.dto.DailySalesDto;
import com.sh.admin.sales.model.service.DailySalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SalesRestController {
    private final DailySalesService dailySalesService;

//    @GetMapping("/chart")
//    public String sales() {
//        return "sales/chart";
//    }

    @GetMapping(path="/api-chart")
    public List<DailySalesDto> chart(){
        LocalDate endDate = LocalDate.now().minusDays(1);
        LocalDate startDate = LocalDate.now().minusMonths(1);

        // 기간동안 일별매출 조회
        List<DailySalesDto> dailySales = dailySalesService.findDailySales(startDate, endDate);

        return dailySales;
        // 주간
    }
}
