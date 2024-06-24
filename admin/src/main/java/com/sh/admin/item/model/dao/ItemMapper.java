package com.sh.admin.item.model.dao;

import com.sh.admin.item.model.dto.ItemDto;

import java.util.List;

public interface ItemMapper {
    List<ItemDto> findAll(); //  전체조회
}
