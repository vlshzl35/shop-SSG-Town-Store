package com.sh.admin.order.model.service;

import com.sh.admin.order.model.dao.OrderMapper;
import com.sh.admin.order.model.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrderService {
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> findOrderList(int orderid) {
        return orderMapper.findOrderList(orderid);
    }
}
