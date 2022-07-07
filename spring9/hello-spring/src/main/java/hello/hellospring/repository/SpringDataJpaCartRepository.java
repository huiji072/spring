package hello.hellospring.repository;

import hello.hellospring.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaCartRepository extends JpaRepository<Cart, Long>, CartRepository {

    Optional<Cart> findBymemberid(Long memberid);

}
