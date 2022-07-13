package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaProductOrderRepository extends JpaRepository<Product, Long>, ProductOrderRepository {
}
