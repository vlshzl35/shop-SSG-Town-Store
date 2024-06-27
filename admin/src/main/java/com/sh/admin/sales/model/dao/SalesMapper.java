// com.sh.admin.sales.model.dao.SalesDAO.java
package com.sh.admin.sales.model.dao;

import com.sh.admin.sales.model.dto.SalesItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalesMapper {
    List<SalesItemDTO> getTopSalesItems();

    List<SalesItemDTO> getArtistTopSalesItems(@Param("artistName") String s);
}
