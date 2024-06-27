// com.sh.admin.sales.model.dao.SalesDAO.java
package com.sh.admin.sales.model.dao;

import com.sh.admin.sales.model.dto.SalesDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalesDAO {
    List<SalesDTO> getTopSalesItems();
}
