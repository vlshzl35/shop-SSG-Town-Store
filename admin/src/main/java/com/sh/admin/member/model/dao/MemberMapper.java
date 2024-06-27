package com.sh.admin.member.model.dao;

import com.sh.admin.member.model.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDto> findAllMember();

    int deleteById(String memberId);
}