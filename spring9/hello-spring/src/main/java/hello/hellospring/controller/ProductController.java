package hello.hellospring.controller;

import hello.hellospring.domain.Cart;
import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import hello.hellospring.service.CartService;
import hello.hellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String uploadForm() {
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

    @GetMapping("/products/search")
    public String searchForm() {
        return "products/search";
    }

    @PostMapping("/products/search")
    public String search(Model model, Product product) {

        if(productService.search(product)){
            model.addAttribute("products", product);
            return "products/list";
        }
        return "products/search";
    }

    //    @RequestMapping(value="/products/list", method = RequestMethod.GET)


    @GetMapping("products/list")
    public String list(Model model) {
        List<Product> products = productService.findProducts();
        model.addAttribute("products", products);
//        System.out.println("id : "+id);

        return "products/list";
    }

    @ResponseBody
    @GetMapping("/products/wishList")
    public String wishList(@RequestParam(value="chk", required = false) List<String > products) {
        Cart cart = new Cart();
        Member member = new Member();

        for(String product : products){
            System.out.println(product);

            cart.setMemberid(1L);
            cart.setProductid(Long.parseLong(product));
            cart.setCartqty(1);
        }
        cartService.addCart(cart);

        //qty는 디폴트 값 1

        return "id : "+products.toString();
    }

}
