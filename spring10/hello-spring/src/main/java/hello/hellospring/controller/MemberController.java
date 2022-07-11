package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemberForm;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

//@RequiredArgsConstructor
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

//    @ResponseBody
    @PostMapping("/members/login")
    public String login(@ModelAttribute  MemberForm form, HttpServletRequest request
    ,@RequestParam(value="chkseller", required = false) String sellerid,
                        @RequestParam(value="chkbuyer", required = false) String buyerid) {

        System.out.println("sellerid : " + sellerid);
        System.out.println("buyerid : " + buyerid);
;
        Member loginMember = memberService.login(form.getEmail(), form.getPassword());
        //email, password가 맞지 않을 때
        if(loginMember == null) {
            return "members/login";
        }

        //로그인 성공
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);
        session.setMaxInactiveInterval(3600); //1시간
        System.out.println("session id" + session.getId());


        if(Objects.equals(sellerid, "on") && !Objects.equals(buyerid, "on")) {
            return "sellerHome";
        }else if(!Objects.equals(sellerid, "on") && Objects.equals(buyerid, "on")) {
            return "buyerHome";
        }else if(Objects.equals(sellerid, "on") && Objects.equals(buyerid, "on")) {
            return "adminHome";
        }

        return "redirect:/";

    }

//    @ResponseBody
//    @PostMapping("/members/login")
//    public String sellerLogin(@RequestParam(value="chkseller", required = false) String sellerid) {
//        System.out.println("sellerid " + sellerid);
//        return "members/list";
//
//    }

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
