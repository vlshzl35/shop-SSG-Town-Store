package com.sh.admin.login.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
@SessionAttributes("userId")
public class UserController {

    private final ObjectMapper objectMapper;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }


    // 백엔드
    @PostMapping("/loginExecute")
    public String loginExecute(@RequestParam String userId, @RequestParam String userPassword) {
        System.out.println(userId);
        System.out.println(userPassword);
        return "/main";
    }

    @GetMapping("/main")
    public String main(){


        return "/main";
    }
}
