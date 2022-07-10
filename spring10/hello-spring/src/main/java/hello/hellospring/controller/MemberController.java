package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.SessionManager;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemberForm;
import hello.hellospring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    private final SessionManager sessionManager;
    @Autowired
    public MemberController(MemberService memberService, SessionManager sessionManager) {
        this.memberService = memberService;
        this.sessionManager = sessionManager;
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
    public String login(@ModelAttribute  MemberForm form, HttpServletRequest request) {
        //true를 사용하면 처음 들어온 사용자도 세션이 만들어지기 떄문에 false로 설정
//        HttpSession session = request.getSession(false);

        Member loginMember = memberService.login(form.getEmail(), form.getPassword());
        //email, password가 맞지 않을 때
        if(loginMember == null) {
            return "members/login";
        }

        //세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
//        sessionManager.createSession(loginMember, response);

        //로그인 성공
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);


        return "redirect:/";

    }

    //로그아웃
    @GetMapping("/members/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();   // 세션 날림
        }

        return "redirect:/";
    }

    @GetMapping("/members/list")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/list";
    }



}
