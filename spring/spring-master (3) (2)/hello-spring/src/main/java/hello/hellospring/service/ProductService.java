package hello.hellospring.service;

import hello.hellospring.domain.Product;
import hello.hellospring.domain.WishProduct;
import hello.hellospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //    상품 업로드
    public Long upload(Product product) {
        productRepository.save(product); //상품 저장
        return product.getId();
    }

    public Long uploadwish(WishProduct wishProduct) {
        productRepository.save(wishProduct); //상품 저장
        return wishProduct.getId();
    }

    //전체  조회
    public List<Product> findAll() {
        return productRepository.findAll();
    }

//    //전체  조회
//    public List<WishProduct> findByWishAll() {
//        return productRepository.findByWishAll();
//    }


    //id 조회
    public Optional<Product> findById(Long memberId) {
        return productRepository.findById(memberId);
    }

    //상품명 조회
    public Optional<Product> findByproductName(String productName) {
        return productRepository.findByproductName(productName);
    }

    //상품이 검색 후 존재하면 return true
    public boolean search(Product product) {

        if(productRepository.findByproductName(product.getProductName()).isPresent()) {
            return true;
        }
        return false;
    }

}
