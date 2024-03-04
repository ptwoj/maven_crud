package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.BoardDto;
import com.codingrecipe.member.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public int save(BoardDto boardDto) {
        return boardRepository.save(boardDto);
    }
}
