package com.sh.admin.refund.model.service;

import com.sh.admin.refund.Exception.AcceptRefundError;
import com.sh.admin.refund.model.dao.RefundMapper;
import com.sh.admin.refund.model.dto.RefundOrderStatus;
import com.sh.admin.refund.model.dto.RefundSalesDto;
import com.sh.admin.refund.model.dto.RefundStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class RefundCommandService {
    private final RefundMapper refundMapper;

    public int update(Long refundId, RefundStatus refundStatus) {
        return refundMapper.update(refundId, refundStatus);
    }

    public int updateOrder(long orderId, RefundOrderStatus refundOrderStatus) {
        return refundMapper.updateOrder(orderId, refundOrderStatus);
    }

    public int updateProduct(long itemId, int itemQuantity) {
        return refundMapper.updateProduct(itemId, itemQuantity);
    }

    public int insertSales(RefundSalesDto refundSalesDto) {
        return refundMapper.insertSales(refundSalesDto);
    }

}
