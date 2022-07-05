package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {

    Optional<Product> findByName(String name);
    Optional<Product> findByQty(int qty);

}
