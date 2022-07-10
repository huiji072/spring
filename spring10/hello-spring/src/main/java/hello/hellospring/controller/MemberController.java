package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemberForm;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members/join")
    public String joinForm() {
        return "members/join";
    }


    @PostMapping("/members/join")
    public String join(MemberForm form) {
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        memberService.join(member);
        return "members/login";
    }

    @GetMapping("/members/login")
    public String loginForm() {
        return "members/login";
    }

    @PostMapping("/members/login")
    public String login(Member member) {
        if(memberService.login(member)) {
            return "redirect:/";
        }
        return "members/login";
    }

    @GetMapping("/members/list")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/list";
    }



}
