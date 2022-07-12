package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    Optional<Product> findByQty(int qty);
    Optional<Product> findByCreatedate(Instant createdate);
    Optional<Product> findByupdatedate(Instant updatedate);
    List<Product> findAll();
}
