package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.BoardDto;
import com.codingrecipe.member.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public int save(BoardDto boardDto) {
        return boardRepository.saveBoard(boardDto);
    }

    public List<BoardDto> boardFindAll() {
        return boardRepository.boardFindAll();
    }

    public BoardDto boardFindById(Long id) {
        return boardRepository.boardFindById(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }
}
