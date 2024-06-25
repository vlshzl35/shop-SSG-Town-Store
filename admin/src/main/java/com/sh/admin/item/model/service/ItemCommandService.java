package com.sh.admin.item.model.service;

import com.sh.admin.item.model.dao.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemCommandService { // DML

    public final ItemMapper itemMapper;

    public ItemCommandService(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }


//    public boolean updateSaleStatus(int itemId) {
//        ItemDto item = itemMapper.findById(itemId); // id로 해당되는 객체 찾기
//        // 해당되는 객체가 null이 아니고 saleStatus가 품절일 경우 Status를 판매중지로바꾼다
//        if (item != null && item.getSaleStatus() == SaleStatus.품절) {
//            int updatedRows = itemMapper.updateSaleStatus(itemId);
//            if(updatedRows > 0) {
//                return true;
//            }
//        }
//        return false;
//    }
}
