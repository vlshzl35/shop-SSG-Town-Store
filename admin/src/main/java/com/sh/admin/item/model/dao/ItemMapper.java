package com.sh.admin.item.model.dao;

import com.sh.admin.item.model.dto.ItemDto;
import com.sh.admin.item.model.dto.SaleStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemDto> findAll(); //  전체조회

//    나경작업시작
    ItemDto findById(Long itemId); // 아이디로 한건조회

    int updateSaleStatus(Long itemId);
//    나경작업완료
}
