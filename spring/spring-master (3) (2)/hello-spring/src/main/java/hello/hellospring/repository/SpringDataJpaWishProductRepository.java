package hello.hellospring.repository;

import hello.hellospring.domain.WishProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaWishProductRepository extends JpaRepository<WishProduct, Long>, WishProductRepository{

}
