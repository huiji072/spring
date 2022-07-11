package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final SellerRepository sellerRepository;
    private final BuyerRepository buyerRepository;

    public SpringConfig(MemberRepository memberRepository, ProductRepository productRepository, CartRepository cartRepository, SellerRepository sellerRepository, BuyerRepository buyerRepository) {
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.sellerRepository = sellerRepository;
        this.buyerRepository = buyerRepository;
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
    @Bean
    public SellerService sellerService() {
        return new SellerService(sellerRepository);
    }
    @Bean
    public BuyerService buyerService() {
        return new BuyerService(buyerRepository);
    }
}
