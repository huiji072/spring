package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.ProductRepository;
import hello.hellospring.repository.WishProductRepository;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.ProductService;
import hello.hellospring.service.WishProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final WishProductRepository wishProductRepository;

    public SpringConfig(MemberRepository memberRepository, ProductRepository productRepository, WishProductRepository wishProductRepository) {
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
        this.wishProductRepository = wishProductRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository);
    }

    @Bean
    public WishProductService wishProductService() {
        return new WishProductService(wishProductRepository);
    }


}