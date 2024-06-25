package com.sh.admin.login.model.dao;

import com.sh.admin.login.model.dto.LoginRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    LoginRequestDto login(String adminId, String adminPassword);
}
