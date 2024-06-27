package com.sh.admin.member.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String memberId; // 회원ID
    private String memberName; // 회원이름
    private memberGender memberGender; // 회원 성별
    private String memberBirth; // 회원주민등록번호
    private String memberAddress; // 회원주소
    private String memberEmail; // 회원메일
    private LocalDate createdAt ; // 회원가입일
    private String memberBank;  // 수량
    private String memberAccount; // 회원 계좌
    private memberStatus memberStatus;
}