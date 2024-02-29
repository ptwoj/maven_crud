package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.MemberDto;
import com.codingrecipe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public int save(MemberDto memberDto) {
        return memberRepository.save(memberDto);
    }

    public boolean login(MemberDto memberDto) {
        MemberDto loginMember = memberRepository.login(memberDto);
        if (loginMember != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<MemberDto> findAll() {
        return memberRepository.findAll();
    }

    public MemberDto findById(Long id) {
        return memberRepository.findById(id);
    }

    public void delete(Long id) {
        memberRepository.delete(id);
    }

    public MemberDto findByMemberEmail(String loginEmail) {
        return memberRepository.findByMemberEmail(loginEmail);
    }

    public boolean update(MemberDto memberDto) {
       int result = memberRepository.update(memberDto);
       if (result > 0) {
           return true;
       } else {
           return false;
       }
    }

    public String emailCheck(String memberEmail) {
        MemberDto memberDto = memberRepository.findByMemberEmail(memberEmail);
        if (memberDto == null) {
            return "ok";
        } else {
            return "no";
        }
    }
}
