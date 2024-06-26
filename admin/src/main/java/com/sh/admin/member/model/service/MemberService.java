package com.sh.admin.member.model.service;

import com.sh.admin.member.model.dao.MemberMapper;
import com.sh.admin.member.model.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    public List<MemberDto> findAllMember() {
        return memberMapper.findAllMember();
    }

    public boolean deleteById(String memberId) {
        return memberMapper.deleteById(memberId) > 0;
    }
}
