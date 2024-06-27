package com.sh.admin.sales.model.service;

import com.sh.admin.sales.model.dao.SalesMapper;
import com.sh.admin.sales.model.dto.SalesItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SalesService {
    private final SalesMapper salesMapper;

    public List<SalesItemDTO> getTopSalesItems() {

        List<SalesItemDTO> list = salesMapper.getTopSalesItems();

        return list;
    }

    public List<SalesItemDTO> getArtistTopSalesItems(String s) {
        return salesMapper.getArtistTopSalesItems(s);
    }
}
