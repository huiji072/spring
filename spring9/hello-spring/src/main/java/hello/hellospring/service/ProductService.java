package hello.hellospring.service;

import hello.hellospring.domain.Product;
import hello.hellospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//업로드, 장바구니, 전체출력, 검색
@Transactional
public class ProductService {
    
    private final ProductRepository productRepository;
    
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //상품 등록
    public Long upload(Product product) {
        productRepository.save(product);
        return product.getId();
    }

    //상품이 존재하는지 확인
    public boolean search(Product product) {

        if (productRepository.findByName(product.getName()).isPresent()) {
            return true;
        }
        return false;
    }
    
    //전체 상품 출력
    public List<Product> findProducts() {
        return productRepository.findAll();
    }
    
}
