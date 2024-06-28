package com.sh.admin.order.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderQuantityDto {
   private int orderItemId;
    private int orderId;
    private int itemId;
    private int itemQuantity;
    private int orderItemPrice;
    private int quantity;
}
