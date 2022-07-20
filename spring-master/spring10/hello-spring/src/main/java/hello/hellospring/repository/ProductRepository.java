package hello.hellospring.repository;

import hello.hellospring.domain.Product;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);
    Optional<Product> findByUserid(Long userid);
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    Optional<Product> findByQty(int qty);
    Optional<Product> findByCreatedate(Instant createdate);
    Optional<Product> findByupdatedate(Instant updatedate);
    List<Product> findAll();
    List<Product> findByNameLessThanOrderByName(String name);
    List<Product> findByNameLike(String name);
}
