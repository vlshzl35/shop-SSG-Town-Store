package com.sh.admin.sales.model.service;

import com.sh.admin.sales.model.dao.SalesDAO;
import com.sh.admin.sales.model.dto.SalesItemDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SalesServiceTest {

    @Autowired
    public SalesDAO salesDAO;

    @Test
    void artistTest() {
        List<SalesItemDTO> aespaList = salesDAO.getArtistTopSalesItems("샤이니");
        aespaList.forEach((top) -> {
            System.out.println(top.getItemName() + " " + top.getTotalSales());
        });
        assertThat(aespaList).isNotNull();
    }
}