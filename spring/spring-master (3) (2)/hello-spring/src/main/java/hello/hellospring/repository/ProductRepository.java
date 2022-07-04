package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import hello.hellospring.domain.WishProduct;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product); //저장
    WishProduct save(WishProduct wishProduct);
    Optional<Product> findById(Long id); //id검색
    Optional<Product> findByproductName(String productName); //name검색
    List<Product> findAll(); //product 검색
//    List<WishProduct> findAll();
}
