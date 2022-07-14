package hello.hellospring.service;

import hello.hellospring.domain.Product;
import hello.hellospring.repository.ProductOrderRepository;
import hello.hellospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;
    private final ProductOrderRepository productOrderRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductOrderRepository productOrderRepository) {
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public Long upload(Product product) {
        validateDuplicateProduct(product);
        productRepository.save(product);
        return product.getId();
    }

    public Optional<Product> findByname(String name){
        return productRepository.findByName(name);
    }

    private void validateDuplicateProduct(Product product) {

        productRepository.findByName(product.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 상품입니다.");
                });

    }
    
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public boolean search(Product product) {

        if(productRepository.findByName(product.getName()).isPresent()){
            return true;
        }
        return false;

    }

}
