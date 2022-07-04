package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //localhot:8080/을 sb에 요청하면 wb에 home.html 반환
    @GetMapping("/")
    public String home() {
        return "home";
    }
    
}
