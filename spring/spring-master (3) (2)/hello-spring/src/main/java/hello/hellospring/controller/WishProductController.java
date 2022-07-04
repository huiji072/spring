package hello.hellospring.controller;

import hello.hellospring.domain.WishProduct;
import hello.hellospring.service.WishProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WishProductController {

    private final WishProductService wishProductService;

    @Autowired
    public WishProductController(WishProductService wishProductService) {
        this.wishProductService = wishProductService;
    }


    //장바구니
    @GetMapping(value = "/product/wish")
    public String productWish(WishProduct wishProduct, Model model) {
//
//        List<Product> products = productService.findAll();
//        model.addAttribute("products", products);

        List<WishProduct> wishProducts = wishProductService.findAll();
        model.addAttribute("wishProducts", wishProducts);

        return "product/wish";
    }
}
