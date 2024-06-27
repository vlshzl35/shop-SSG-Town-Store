package com.sh.admin.sales.model.dao;

import com.sh.admin.sales.model.dto.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalesMapper {
    @Select("SELECT * FROM tbl_sales")
    List<Sales> findAllSales();
}
