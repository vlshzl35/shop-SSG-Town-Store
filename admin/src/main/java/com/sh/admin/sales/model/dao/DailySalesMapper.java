package com.sh.admin.sales.model.dao;

import com.sh.admin.sales.model.dto.DailySalesDto;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DailySalesMapper {
    List<DailySalesDto> findDailySales(LocalDate startDate, LocalDate endDate);
}
