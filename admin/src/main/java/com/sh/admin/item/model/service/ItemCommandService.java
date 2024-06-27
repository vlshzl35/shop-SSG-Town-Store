package com.sh.admin.item.model.service;
import com.sh.admin.item.model.dao.ItemMapper;
import com.sh.admin.item.model.dto.ItemDto;
import com.sh.admin.item.model.dto.SaleStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemCommandService { // DML

    public final ItemMapper itemMapper;

//나경작업시작
    public boolean updateSaleStatus(Long itemId) {
        ItemDto item = itemMapper.findById(itemId); // id로 해당되는 객체 찾기
        // 해당되는 객체가 null이 아니고 saleStatus가 품절일 경우 Status를 판매중지로 바꾼다
        if (item != null && SaleStatus.품절.equals(item.getSaleStatus())) {
            int updatedRows = itemMapper.updateSaleStatus(itemId);
            if (updatedRows == 1) {
                return true;
            }
        }
        return false;
    }
//    나경작업끝

//    나경시작
public boolean updateItem(ItemDto itemDto) {
    // 조건이 안맞으면 ( 수량이 작다던가
    if (itemDto != null ) {
        int updatedRows = itemMapper.updateItem(itemDto);
        if (updatedRows == 1) {
            return true;
        }
    }
    return false;
}
//    나경끝


    // 희윤 등록 시작
    public int insertItem(ItemDto itemDto) {
        return itemMapper.insertItem(itemDto);
        // 등록실패는 js?service?어디에 만들지
    }
    // 희윤 등록 끝

}
