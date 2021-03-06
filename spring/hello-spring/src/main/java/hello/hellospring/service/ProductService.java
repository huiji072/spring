package hello.hellospring.service;

import hello.hellospring.domain.Product;
import hello.hellospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
