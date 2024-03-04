package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public int save(BoardDto boardDto) {
        return sql.insert("Board.save", boardDto);
    }
}
