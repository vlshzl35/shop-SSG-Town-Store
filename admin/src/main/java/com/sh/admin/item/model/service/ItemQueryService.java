package com.sh.admin.item.model.service;

import com.sh.admin.item.model.dao.ItemMapper;
import com.sh.admin.item.model.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 조회용 메서드만 있어서 읽기만
public class ItemQueryService {

    public final ItemMapper itemMapper;

    public List<ItemDto> findAll() {
        return itemMapper.findAll();
    }
//나경작업시작

    // 한건 조회
    public ItemDto findById(int itemId) {
        return itemMapper.findById(itemId);
    }
//    나경작업끝
}
