package hello.hellospring.controller;

import hello.hellospring.domain.Product;
import hello.hellospring.domain.WishProduct;
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


    //    상품 등록 폼
    @GetMapping(value = "/product/new")
    public String createForm() {
        return "product/createProductForm";
    }

    //상품 실제 등록
    @PostMapping(value = "/product/new")
    public String create(ProductForm form, Model model) {
        //입력한 상품 등록
        Product product = new Product();
        product.setProductName(form.getProductName());
        productService.upload(product);
        //상품 가져오기
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/productList";
    }

    //
    //모든 상품 출력
    @GetMapping(value = "/product")
    public String productList(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/productList";
    }

    //상품 검색 폼
    @GetMapping(value = "/product/search")
    public String productSearch() {
        return "product/search";
    }

    //검색시 db에 존재하면 출력
    @PostMapping(value = "/product/search")
    public String productSearchResult(Product product, Model model) {
        if (productService.search(product)){
            return "product/search";
        }
        return "redirect:/";
    }

//    @GetMapping(value = "/product/wish")
//    public String wishForm() {
//        return "product/wish";
//    }

//    //장바구니
//    @GetMapping(value = "/product/wish")
//    public String productWish(WishProduct wishProduct, Model model) {
//
//        List<Product> products = productService.findAll();
//        model.addAttribute("products", products);
//
//        return "product/wish";
//    }

}
