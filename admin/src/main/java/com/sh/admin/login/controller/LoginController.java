package com.sh.admin.login.controller;


import com.sh.admin.login.model.dto.LoginRequestDto;
import com.sh.admin.login.model.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
@SessionAttributes("userId")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "/login/login";
    }

    @PostMapping("/loginExecute")
    public ResponseEntity<?> loginExecute(@RequestParam String adminId, @RequestParam String adminPassword, HttpSession httpSession) {
        LoginRequestDto loginRequestDto = loginService.login(adminId, adminPassword);
        Map<String, String> response = new HashMap<>();

        if (loginRequestDto != null) {
            response.put("status", "200");
            response.put("message", "Login successful");
            response.put("adminName",loginRequestDto.getAdminName());
            response.put("adminId", loginRequestDto.getAdminId());
            httpSession.setAttribute("adminName",loginRequestDto.getAdminName());
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "401");
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // 세션 폐기
        return "redirect:/admin/login";
    }
}