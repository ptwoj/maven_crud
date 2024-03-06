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
            return "redirect:/boardSave";
        } else {
            return "boardSave";
        }
    }

    @GetMapping("/")
    public String boardFindAll(Model model) {
        List<BoardDto> boardDtoList = boardService.boardFindAll();
        model.addAttribute("boardList", boardDtoList);
        return "boardList";
    }

    @GetMapping
    public String boardFindById(@RequestParam("id") Long id, Model model) {
        BoardDto boardDto = boardService.boardFindById(id);
        model.addAttribute("board", boardDto);
        return "boardDetail";
    }

}
