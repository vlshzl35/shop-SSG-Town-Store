package com.sh.admin.sales.model.service;

import com.sh.admin.sales.model.dao.DailySalesMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DailySalesCommandServiceTest {

    @Autowired
    DailySalesCommandService dailySalesCommandService;

    @Test
    @DisplayName("마감 정산 하기")
    void name() {

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(today);

        int result = dailySalesCommandService.insertDailySales("2024-06-26");
        assertThat(result).isEqualTo(1);
    }
}