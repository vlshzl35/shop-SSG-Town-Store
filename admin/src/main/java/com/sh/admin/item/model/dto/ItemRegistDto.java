package com.sh.admin.item.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRegistDto {
    private String itemName; // 상품명
    private Category categoryName; // 카테고리
    private Artist artistName; // 아티스트
    private String imgUrl; // 이미지
    private String details; // 세부설명
    private int quantity;  // 수량
    private int salePrice; // 가격
    private SaleStatus saleStatus; // 판매상태

    public ItemDto toItemDto() {
        return new ItemDto(null, this.itemName,this.categoryName,this.artistName,this.imgUrl,null,this.details,this.quantity,this.salePrice,this.saleStatus);
    }

    public ItemDto toItemDto2(long itemId) {
        return new ItemDto(itemId, this.itemName,this.categoryName,this.artistName,this.imgUrl,null,this.details,this.quantity,this.salePrice,this.saleStatus);
    }

    public ItemDto toItemDto3(long itemId) {
        return new ItemDto(itemId, this.itemName,this.categoryName,this.artistName,null,null,this.details,this.quantity,this.salePrice,this.saleStatus);
    }




}

