package hello.hellospring.controller;

import hello.hellospring.domain.Cart;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import hello.hellospring.domain.ProductForm;
import hello.hellospring.service.CartService;
import hello.hellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String upload(ProductForm form) {
        Product product = new Product();
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

    @GetMapping("/products/search")
    public String searchForm() {
        return "products/search";
    }

    @PostMapping("/products/search")
    public String search(Model model, Product product) {
        if(productService.search(product)) {
            model.addAttribute("products", product);
            return "products/search";
        }
        return "redirect:/";
    }

    @GetMapping("/products/cart")
    public String cartForm() {
//        List<Cart> carts = cartService.findCarts();
//        model.addAttribute("carts", carts);
        return "products/cart";
    }

    @PostMapping("/products/cart")
    public String cart() {
        return "products/cart";
    }



}
