package com.sh.admin.refund.model.service;

import com.sh.admin.refund.model.dao.RefundMapper;
import com.sh.admin.refund.model.dto.RefundDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.engine.IterationStatusVar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RefundQueryServiceTest {

    private static final Logger log = LoggerFactory.getLogger(RefundQueryServiceTest.class);
    @Autowired
    RefundMapper refundMapper;

    @Test
    @DisplayName("전체 조회")
    public void findAll() {
        List<RefundDto> refunds = refundMapper.findAll();
        System.out.println(refunds);
        Assertions.assertThat(refunds).isNotNull();
    }

}