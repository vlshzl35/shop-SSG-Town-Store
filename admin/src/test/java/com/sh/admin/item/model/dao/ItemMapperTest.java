package com.sh.admin.item.model.dao;

import com.sh.admin.item.model.dto.ItemDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;


    @Test
    @DisplayName("전체조회")
    void findAll() {
        // given // 조회라서 줘야되는게 없음
        // when
        List<ItemDto> items = itemMapper.findAll();
        System.out.println(items);

        //then
        assertThat(items)
                .isNotNull()
                .isNotEmpty()
                .allMatch((item) -> item != null); // 모든 요소가 다 true

    }
}