// com.sh.admin.sales.model.dto.SalesDTO.java
package com.sh.admin.sales.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {
    private String itemName;
    private int totalSales;


    // Getter, Setter 생략
}
