package hello.hellospring.service;

import hello.hellospring.domain.Product;
import hello.hellospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long upload(Product product) {
        validateDuplicateProduct(product);
        productRepository.save(product);
        return product.getId();
    }

    public Optional<Product> findByName(String name){
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


    public List<Product> findByNameLessThanOrderByName() {
        List<Product> productOrder = productRepository.findByNameLessThanOrderByName("{");
        return productRepository.findByNameLessThanOrderByName("{");
    }

    public List<Product> findByNameLike(String name) {
        List<Product> findNameLike = productRepository.findByNameLike(name);
        return productRepository.findByNameLike(name);
    }



    public boolean search(Product product) {

        if(productRepository.findByName(product.getName()).isPresent()){
            return true;
        }
        return false;

    }



}
