package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.domain.Cart;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import hello.hellospring.domain.ProductForm;
import hello.hellospring.service.CartService;
import hello.hellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    private List<String> productname;
    private final ProductService productService;
    private final CartService cartService;
    @Autowired
    public ProductController(List<String> productname, ProductService productService, CartService cartService) {
        this.productname = productname;
        this.productService = productService;
        this.cartService = cartService;
    }


    @GetMapping("/products/upload")
    public String uploadForm(){
        return "products/upload";
    }

    @PostMapping("/products/upload")
    public String upload(ProductForm form, @SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember) {

        Product product = new Product();
        product.setUserid(loginMember.getId());
        product.setName(form.getName());
        product.setQty(form.getQty());
        product.setImage(form.getImage());
        productService.upload(product);
        return "redirect:/";
    }

    @GetMapping("/products/list")
    public String list(Model model) {
        List<Product> products = productService.findProducts();
        model.addAttribute("products", products);

        return "products/list";
    }

    @PostMapping("/products/list")
    public String list(Model model, Product product, String name ) {

        List<Product> orderByName = productService.findByNameLessThanOrderByName();
        System.out.println("~~~~"+orderByName.toString());
        model.addAttribute("orderByName", orderByName);
        return "products/list";

    }


    @GetMapping("/products/search")
    public String searchForm() {
        return "products/search";
    }

    @PostMapping("/products/search")
    public String search(Model model, Product products) {
        if(productService.search(products)) {
            model.addAttribute("products", products);
            return "products/search";
        }
        return "redirect:/";
    }

    @GetMapping("/products/cart")
    public String cartForm(Model model) {
        List<Cart> carts = cartService.findCarts();
        model.addAttribute("carts", carts);
        return "products/cart";
    }

    @PostMapping("/products/cart")
    public String cart(@RequestParam(value="chk", required = false) List<String > pname, Model model){

        int cnt = 0;


        for(String name : pname) {
            Cart cart = new Cart();
            cart.setName(name.toString());

            cartService.join(cart); //cart에 insert

        }

        List<Cart> carts = cartService.findCarts();
        model.addAttribute("carts", carts);

        return "products/cart";
    }


    @PostMapping("/products/buy")
    public String buyForm() {
        return "products/buy";
    }


}
