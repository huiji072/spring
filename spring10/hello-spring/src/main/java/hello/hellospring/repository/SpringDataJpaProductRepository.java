package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {

//    List<Product> findByOrderNameAsc();

}
