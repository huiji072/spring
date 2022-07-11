package hello.hellospring;

import hello.hellospring.repository.CartRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.ProductRepository;
import hello.hellospring.service.CartService;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public SpringConfig(MemberRepository memberRepository, ProductRepository productRepository, CartRepository cartRepository) {
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
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
    public CartService cartService() {
        return new CartService(cartRepository);
    }
}
