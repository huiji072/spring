package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import hello.hellospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    private void validateDuplicateProduct(Product product) {

        productRepository.findByName(product.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 상품입니다.");
                });

    }

//    public List<Product> sortByName() {
//        List<Product> sortName = productRepository.findAll(Sort.by("name"));
//        return sortName;
//    }
    
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
