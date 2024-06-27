package com.sh.admin.sales.model.dao;

import com.sh.admin.sales.model.dto.DailySalesDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DailySalesMapper {
    List<DailySalesDto> findDailySales(LocalDate startDate, LocalDate endDate);

    DailySalesDto findDailySale(@Param("today") String today);
    int insertDailySales(@Param("today") String today);

    int updateDailySales(@Param("today") String today);
}
