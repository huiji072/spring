package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

//회원 컨트롤러가 회원 서비스와 회원 리포지토리를 사용할 수 있게 의존관계
@SessionAttributes("member")
@Controller
public class MemberController {

    private final MemberService memberService;
    //@autowired는 스프링이 연관된 객체를 스프링 컨테이너에 찾아서 넣어준다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    //회원 등록 폼 컨트롤러
    //localhost:8080/members/new로 이동하면 createMemberForm.html 반환
    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

//    회원 컨트롤러에서 회원을 실제 등록하는 기능
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        memberService.join(member);

        return "redirect:/";
    }

    //
    //8080/members로 가면 memberList.html반환
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


    //login Form
    @GetMapping(value = "/members/login")
    public String loginForm() {
        return "members/loginForm";
    }



    //login실패하면 다시 실패화면 성공하면 홈화면
    @PostMapping(value = "/members/login")
    public String Login(Member member, HttpServletRequest request) {

        if(memberService.login(member)){

            // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
            HttpSession session = request.getSession();
            // 세션에 로그인 회원 정보 보관
            session.setAttribute(SessionConstants.LOGIN_MEMBER, member);
            //1시간 단위로 세션 타임아웃 설정
            session.setMaxInactiveInterval(3600);
            System.out.println("session id : " + session.getId());
            System.out.println("session is new : " + session.isNew());

            return "redirect:/";
        }

        return "members/loginFail";
    }

}
