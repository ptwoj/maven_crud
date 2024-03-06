package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public int saveBoard(BoardDto boardDto) {
        return sql.insert("Board.boardSave", boardDto);
    }

    public List<BoardDto> boardFindAll() {
        return sql.selectList("Board.boardFindAll");
    }
}
