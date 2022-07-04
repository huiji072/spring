package hello.hellospring.controller;


import hello.hellospring.SessionConstants;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members/new")
    public String joinForm() {
        return "members/createForm";
    }

    @PostMapping("/members/new")
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
    public String login(HttpServletRequest request, Member member) {
        if(memberService.login(member)) {

            HttpSession session = request.getSession();
            session.setAttribute(SessionConstants.LOGIN_MEMBER, member);
            session.setMaxInactiveInterval(3600);

            return "members/memberList";
        }
        return "members/login";
    }

    @GetMapping("/members/memberList")
    public String list(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/memberList";

    }

}
