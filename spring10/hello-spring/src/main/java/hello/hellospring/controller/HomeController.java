package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.SessionManager;
import hello.hellospring.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@Controller
public class HomeController {

    private final SessionManager sessionManager;
    @Autowired
    public HomeController(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }


    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        //세션에 회원 데이터가 없으면 home으로
        if(loginMember == null) {
            return "home";
        }

        //세션이 유지되면 로긍니 홈으로
        model.addAttribute("member", loginMember);
        return "loginHome";
    }

}
