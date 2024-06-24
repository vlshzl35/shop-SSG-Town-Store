package com.sh.admin.login.controller;


import com.sh.admin.login.model.dto.LoginRequestDto;
import com.sh.admin.login.model.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

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
    public ResponseEntity<?> loginExecute(@RequestParam String adminId, @RequestParam String adminPassword, Model model) {
        LoginRequestDto loginRequestDto = loginService.login(adminId, adminPassword);
        if (loginRequestDto != null) {
            model.addAttribute("adminId",loginRequestDto.getAdminId());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
        } else {
            // 로그인 실패 처리
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).build();
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {

        sessionStatus.setComplete(); // 세션 폐기
        return "redirect:/login/login";
    }
}