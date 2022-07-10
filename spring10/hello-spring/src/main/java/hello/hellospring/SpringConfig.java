package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.ProductRepository;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    public SpringConfig(MemberRepository memberRepository, ProductRepository productRepository) {
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
    @Bean
    public ProductService productService() {
        return new ProductService(productRepository);
    }
}
