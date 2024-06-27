package com.sh.admin.sales.model.service;

import com.sh.admin.sales.model.dao.SalesDAO;
import com.sh.admin.sales.model.dto.SalesItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesDAO salesDAO;

    public List<SalesItemDTO> getTopSalesItems() {

        List<SalesItemDTO> list = salesDAO.getTopSalesItems();

        return list;
    }

    public List<SalesItemDTO> getArtistTopSalesItems(String s) {
        return salesDAO.getArtistTopSalesItems(s);
    }
}
