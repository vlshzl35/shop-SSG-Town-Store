package com.sh.admin.member.controller;

import com.sh.admin.member.model.dto.MemberDto;
import com.sh.admin.member.model.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member")
    public String member(Model model, HttpSession httpSession){
        List<MemberDto> members = memberService.findAllMember();
        model.addAttribute("members",members);
        String adminName = (String) httpSession.getAttribute("adminName");
        model.addAttribute("adminName", adminName);
        return "/member/member";
    }
    @PostMapping("/memberdelete")
    public ResponseEntity<?> deleteMember(@RequestBody MemberDto memberDTO) {
        boolean isDeleted = memberService.deleteById(memberDTO.getMemberId());
        if (isDeleted) {
            return ResponseEntity.ok().body(Map.of("status", "success"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("status", "failure"));
        }
    }
}
