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

    @GetMapping("/api-monthlychart")
    public List<DailySalesDto> monthlyChart(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.now().minusMonths(1);

        // 기간동안 일별매출 조회
        List<DailySalesDto> dailySales = dailySalesService.findDailySales(startDate, endDate);

        // 월간
        return dailySales;
    }

    @GetMapping("/api-weeklychart")
    public List<DailySalesDto> weeklyChart(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.now().minusDays(7);

        // 기간동안 일별매출 조회
        List<DailySalesDto> dailySales = dailySalesService.findDailySales(startDate, endDate);

        // 주간
        return dailySales;
    }

    @GetMapping("/api-yearlychart")
    public List<DailySalesDto> yearlyChart(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.now().minusYears(1);

        // 기간동안 일별매출 조회
        List<DailySalesDto> dailySales = dailySalesService.findDailySales(startDate, endDate);

        // 연간
        return dailySales;
    }

}
