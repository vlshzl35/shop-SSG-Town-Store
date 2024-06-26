package com.sh.admin.order.model.dao;

import com.sh.admin.order.model.dto.OrderDto;
import com.sh.admin.order.model.dto.OrderItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDto> findOrderList();

    List<OrderItemDto> findByOrderId(int orderId);

    int orderCancelByOrderId(int cancelOrderId);
}
