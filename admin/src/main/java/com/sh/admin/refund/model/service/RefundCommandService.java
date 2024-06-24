package com.sh.admin.refund.model.service;

import com.sh.admin.refund.model.dao.RefundMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class RefundCommandService {
    private final RefundMapper refundMapper;
}
