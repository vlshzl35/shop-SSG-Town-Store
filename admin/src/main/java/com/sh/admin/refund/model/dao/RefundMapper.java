package com.sh.admin.refund.model.dao;

import com.sh.admin.refund.model.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RefundMapper {
    List<RefundDto> findAll();

    RefundOrderDto findOrder(@Param("orderId") long orderId);

    int update(@Param("refundId") long refundId, RefundStatus refundStatus);

    int updateOrder(@Param("orderId") long orderId, RefundOrderStatus refundOrderStatus);

    List<RefundItemDto> findOrderItem(@Param("orderId") long orderId);

    int updateProduct(long itemId, int itemQuantity);

    int insertSales(RefundSalesDto refundSalesDto);

    List<RefundDto> findByCondition(SearchDto searchDto);
}
