package hello.hellospring.controller;

import hello.hellospring.SessionConstants;
import hello.hellospring.domain.Cart;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import hello.hellospring.domain.ProductForm;
import hello.hellospring.repository.ProductOrderRepository;
import hello.hellospring.service.CartService;
import hello.hellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Objects;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CartService cartService;
    @Autowired
    public ProductController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }


    @GetMapping("/products/upload")
    public String uploadForm(){
        return "products/upload";
    }

    @PostMapping("/products/upload")
    public String upload(ProductForm form, @RequestParam(value="chkseller", required = false) String sellerid
    ,Model model, @SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember) {

        Product product = new Product();
        product.setUserid(loginMember.getId());
        product.setName(form.getName());
        product.setQty(form.getQty());
        productService.upload(product);
        return "redirect:/";
    }

    @GetMapping("/products/list")
    public String list(Model model) {
        List<Product> products = productService.findProducts();
        model.addAttribute("products", products);
        return "products/list";
    }

//    @PostMapping("/products/list")
//    public String listToCart(Product product) {
//
//        return "products/cart";
//    }

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
    public String cart(@RequestParam(value="chk", required = false) List<String > pname, Model model,
                       @RequestParam(value="qty", required = false) List<String > pqty){

        for(String name : pname) {
            Cart cart = new Cart();
            cart.setName(name.toString());
            cart.setQty(1);
            cartService.join(cart); //cart에 insert
        }

        List<Cart> carts = cartService.findCarts();
        model.addAttribute("carts", carts);

        return "products/cart";
    }


}
