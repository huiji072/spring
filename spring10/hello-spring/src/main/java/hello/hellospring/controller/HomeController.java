package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

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
