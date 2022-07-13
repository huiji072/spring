package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.domain.Buyer;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemberForm;
import hello.hellospring.domain.Seller;
import hello.hellospring.service.BuyerService;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.SellerService;
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
    private final SellerService sellerService;
    private final BuyerService buyerService;
    @Autowired
    public MemberController(MemberService memberService, SellerService sellerService, BuyerService buyerService) {
        this.memberService = memberService;
        this.sellerService = sellerService;
        this.buyerService = buyerService;
    }


    @GetMapping("/members/join")
    public String joinForm() {
        return "members/join";
    }


    @PostMapping("/members/join")
    public String join(MemberForm form
            ,@RequestParam(value="chkseller", required = false) String sellerid,
                       @RequestParam(value="chkbuyer", required = false) String buyerid) {

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        memberService.join(member);

//seller, buyer 체크박스 선택 시
        if(Objects.equals(sellerid, "on") && !Objects.equals(buyerid, "on")) {
            Seller seller = new Seller();
            seller.setMemberid(member.getId());
            sellerService.save(seller);
            return "sellerHome";
        }else if(!Objects.equals(sellerid, "on") && Objects.equals(buyerid, "on")) {
            Buyer buyer = new Buyer();
            buyer.setMemberid(member.getId());
            buyerService.save(buyer);
            return "buyerHome";
        }else if(Objects.equals(sellerid, "on") && Objects.equals(buyerid, "on")) {
            Seller seller = new Seller();
            seller.setMemberid(member.getId());
            sellerService.save(seller);
            Buyer buyer = new Buyer();
            buyer.setMemberid(member.getId());
            buyerService.save(buyer);
            return "adminHome";
        }
        return "members/login";
    }

    @GetMapping("/members/login")
    public String loginForm() {
        return "members/login";
    }

    //    @ResponseBody
    @PostMapping("/members/login")
    public String login(@ModelAttribute  MemberForm form, HttpServletRequest request, Member member, Seller seller, Buyer buyer) {

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
        
        //seller table의 memberid가 존재하면 sellerHome으로


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