package com.codingrecipe.member.controller;

import com.codingrecipe.member.dto.MemberDto;
import com.codingrecipe.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDto memberDto) {
        int saveResult = memberService.save(memberDto);
        if (saveResult > 0) {
            return "login";
        } else {
            return "save";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto,
                        HttpSession session) {
        boolean loginResult = memberService.login(memberDto);
        if (loginResult) {
            session.setAttribute("LoginEmail", memberDto.getMemberEmail());
            return "main";
        } else {
            return "login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<MemberDto> memberDtoList = memberService.findAll();
        model.addAttribute("memberList", memberDtoList);
        return "list";
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model) {
        MemberDto memberDto = memberService.findById(id);
        model.addAttribute("member", memberDto);
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        memberService.delete(id);
        return "redirect:/member/";
    }

    // 수정 화면 요청
    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model) {
        // 세션에 저장된 나의 이메일 가져오기
        String loginEmail = (String) session.getAttribute("loginEmail");
        MemberDto memberDto = memberService.findByMemberEmail(loginEmail);
        model.addAttribute("member", memberDto);
        return "update";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute MemberDto memberDto) {
        boolean result = memberService.update(memberDto);
        if (result) {
            return "redirect:/member?id=" + memberDto.getId();
        } else {
            return "index";
        }
    }

    @PostMapping("/email-check")
    public @ResponseBody String emailcheck(@RequestParam("memberEmail") String memberEmail) {
        System.out.println("memberEmail = " + memberEmail);
        String checkResult = memberService.emailCheck(memberEmail);
        return checkResult;
    }
}
