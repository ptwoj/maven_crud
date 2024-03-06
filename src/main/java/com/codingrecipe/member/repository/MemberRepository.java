package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;
    public int save(MemberDto memberDto) {
        System.out.println("memberDto + = " + memberDto);
        return sql.insert("Member.memberSave", memberDto);
    }

    public MemberDto login(MemberDto memberDto) {
        return sql.selectOne("Member.memberLogin", memberDto);

    }

    public List<MemberDto> findAll() {
        return sql.selectList("Member.memberFindAll");
    }

    public MemberDto findById(Long id) {
        return sql.selectOne("Member.memberFindById", id);
    }

    public void delete(Long id) {
        sql.delete("Member.memberDelete", id);
    }

    public MemberDto findByMemberEmail(String loginEmail) {
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(MemberDto memberDto) {
        return sql.update("Member.memberUpdate", memberDto);
    }
}
