package com.sh.admin.sales.model.service;

import com.sh.admin.sales.model.dao.SalesMapper;
import com.sh.admin.sales.model.dto.Sales;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    private final SalesMapper salesMapper;

    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }

    public List<Sales> getAllSales() {
        return salesMapper.findAllSales();
    }
}
