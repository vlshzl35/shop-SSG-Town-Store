package com.sh.admin.refund.model.service;

import com.sh.admin.refund.model.dao.RefundMapper;
import com.sh.admin.refund.model.dto.RefundDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class RefundQueryService {
    private final RefundMapper refundMapper;

    @Transactional
    public List<RefundDto> findAll() {
        return refundMapper.findAll();
    }
}
