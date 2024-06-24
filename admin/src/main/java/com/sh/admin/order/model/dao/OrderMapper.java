package com.sh.admin.order.model.dao;

import com.sh.admin.order.model.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDto> findOrderList(int orderid);
}
