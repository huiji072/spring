package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.domain.Buyer;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.Seller;
import hello.hellospring.service.BuyerService;
import hello.hellospring.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Controller
public class HomeController {

    private final SellerService sellerService;
    private final BuyerService buyerService;

    @Autowired
    public HomeController(SellerService sellerService, BuyerService buyerService) {
        this.sellerService = sellerService;
        this.buyerService = buyerService;
    }

    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        //세션에 회원 데이터가 없으면 home으로
        if(loginMember == null) {
            return "home";
        }

        if(!(sellerService.findByMemberid(loginMember.getId()).isEmpty())){
//            seller만 일 때
            model.addAttribute("member", loginMember);
            return "sellerHome";
        }else if(!(buyerService.findByMemberid(loginMember.getId()).isEmpty())){
//            buyer만 일 때
            model.addAttribute("member", loginMember);
            return "buyerHome";
        }else if(!(sellerService.findByMemberid(loginMember.getId()).isEmpty()) &&
                !(buyerService.findByMemberid(loginMember.getId()).isEmpty()) ){
//            seller, buyer 모두 일 때
            model.addAttribute("member", loginMember);
            return "adminHome";
        }


        return "loginHome";
    }

}
