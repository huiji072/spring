package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import hello.hellospring.domain.WishProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
//@EnableJpaRepositories
public interface SpringDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository{
    Optional<Product> findByproductName(String productName);
}
