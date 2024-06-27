package com.sh.admin.sales.model.dao;

import com.sh.admin.sales.model.dto.DailySalesDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class DailySalesMapperTest {

    @Autowired
    DailySalesMapper dailySalesMapper;

    @Test
    void name() {
        DailySalesDto dto = dailySalesMapper.findDailySale("24-06-25");
        System.out.println(dto.getDate());
        assertThat(dto).isNotNull();
    }
}