package com.sh.admin.login.model.service;

import com.sh.admin.login.model.dao.LoginMapper;
import com.sh.admin.login.model.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginService {
    private final LoginMapper loginMapper;

    public LoginRequestDto login(String adminId, String adminPassword) {
        System.out.println(adminId + " "  +adminPassword + "mapper");
        return loginMapper.login(adminId, adminPassword);

    }
}