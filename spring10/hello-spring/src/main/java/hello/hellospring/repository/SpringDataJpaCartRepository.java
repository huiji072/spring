package hello.hellospring.repository;

import hello.hellospring.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaCartRepository extends JpaRepository<Cart, Long>, CartRepository {

}
