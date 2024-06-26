package com.sh.admin.sales.model.service;

import com.sh.admin.sales.model.dao.SalesMapper;
import com.sh.admin.sales.model.dto.DailySalesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesMapper salesMapper;

    public List<DailySalesDto> findDailySales(LocalDate startDate, LocalDate endDate) {
        return salesMapper.findDailySales(startDate, endDate);
    }
}
