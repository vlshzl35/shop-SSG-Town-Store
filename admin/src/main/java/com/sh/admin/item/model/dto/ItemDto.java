package com.sh.admin.item.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemDto {
    private int itemId; // 상품ID
    private String itemName; // 상품명
    private Category categoryName; // 카테고리
    private Artist artistName; // 아티스트
    private String imgUrl; // 이미지
    private String seller; // 판매원
    private String details; // 세부설명
    private int quantity;  // 수량
    private int salePrice; // 가격
    private SaleStatus saleStatus;
}
