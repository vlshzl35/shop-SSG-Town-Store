package com.sh.admin.item.model.dao;

import com.sh.admin.item.model.dto.Artist;
import com.sh.admin.item.model.dto.Category;
import com.sh.admin.item.model.dto.SaleStatus;
import com.sh.admin.item.model.dto.ItemDto;
import com.sh.admin.item.model.dto.SaleStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemDto> findAll(); //  전체조회

    ItemDto findById(long itemId); // 아이디로 한건조회

//    int updateSaleStatus(int itemId);
    /* 희윤 시작 */
    List<ItemDto> findAllMatch(Category categoryName, Artist artistName, int salePrice, SaleStatus saleStatus);
    /* 희윤 끝 */
//    나경작업시작

    int updateSaleStatus(Long itemId);

//    나경작업완료
    // 희윤 등록 시작
    int insertItem(ItemDto itemDto);
    // 희윤 등록 끝
}
