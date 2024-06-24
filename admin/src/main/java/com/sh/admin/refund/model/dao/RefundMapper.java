package com.sh.admin.refund.model.dao;

import com.sh.admin.refund.model.dto.RefundDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefundMapper {
    List<RefundDto> findAll();
}
