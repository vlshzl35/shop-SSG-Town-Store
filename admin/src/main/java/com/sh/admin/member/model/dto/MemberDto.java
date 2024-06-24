package com.sh.admin.member.model.dto;

import com.sh.admin.item.model.dto.Artist;
import com.sh.admin.item.model.dto.Category;
import com.sh.admin.item.model.dto.SaleStatus;

import java.util.Date;
import java.util.stream.Stream;

public class MemberDto {
    private String memberId; // 회원ID
    private String memberName; // 회원이름
    private memberGender memberGender; // 회원 성별
    private String memberBirth; // 회원주민등록번호
    private String memberAddress; // 회원주소
    private String memberEmail; // 회원메일
    private Date createdAt ; // 회원가입일
    private String bankName;  // 수량
    private String memberAccount; // 가격
    private MemeberStatus memeberStatus;
}
