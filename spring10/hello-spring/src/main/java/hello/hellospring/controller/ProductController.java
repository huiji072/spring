package hello.hellospring.controller;

import hello.hellospring.domain.Product;
import hello.hellospring.domain.ProductForm;
import hello.hellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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


}
