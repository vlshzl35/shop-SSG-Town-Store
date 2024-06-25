package com.sh.admin.refund.model.service;

import com.sh.admin.refund.model.dao.RefundMapper;
import com.sh.admin.refund.model.dto.RefundDto;
import com.sh.admin.refund.model.dto.RefundItemDto;
import com.sh.admin.refund.model.dto.RefundOrderDto;
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

    public RefundOrderDto findOrder(long orderId) {
        return refundMapper.findOrder(orderId);
    }

    public List<RefundItemDto> findOrderItem(long orderId) {
        return refundMapper.findOrderItem(orderId);
    }
}
