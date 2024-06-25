package com.sh.admin.item.model.dao;

import com.sh.admin.item.model.dto.Artist;
import com.sh.admin.item.model.dto.Category;
import com.sh.admin.item.model.dto.SaleStatus;
import com.sh.admin.item.model.dto.ItemDto;

import java.util.List;

public interface ItemMapper {
    List<ItemDto> findAll(); //  전체조회

    ItemDto findById(int itemId); // 아이디로 한건조회

//    int updateSaleStatus(int itemId);
    /* 희윤 시작 */
    List<ItemDto> findAllMatch(Category categoryName, Artist artistName, int salePrice, SaleStatus saleStatus);
    /* 희윤 끝 */
}
