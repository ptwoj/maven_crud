package com.codingrecipe.member.controller;

import com.codingrecipe.member.dto.BoardDto;
import com.codingrecipe.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/save")
    public String saveForm() {
        return "boardSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDto boardDto) {
        int saveResult = boardService.save(boardDto);
        if (saveResult > 0) {
            return "redirect:/board";
        } else {
            return "boardSave";
        }
    }

    @GetMapping("/")
    public String boardFindAll(Model model) {
        List<BoardDto> boardDtoList = boardService.boardFindAll();
        model.addAttribute("boardList", boardDtoList);
        return "list";
    }

}
