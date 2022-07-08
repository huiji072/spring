package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SptingDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {


}
