package com.sh.admin.sales.model.service;

import com.sh.admin.sales.model.dao.DailySalesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class DailySalesCommandService {
    private final DailySalesMapper dailySalesMapper;

    // 예진 작업 시작
    public int insertDailySales(String today) {

        if (dailySalesMapper.findDailySale(today) != null) {
            return dailySalesMapper.updateDailySales(today);
        }
        return dailySalesMapper.insertDailySales(today);
    }
    // 예진 작업 끝
}
