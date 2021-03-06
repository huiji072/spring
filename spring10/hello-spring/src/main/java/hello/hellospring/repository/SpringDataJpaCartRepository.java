package hello.hellospring.repository;

import hello.hellospring.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SpringDataJpaCartRepository extends JpaRepository<Cart, Long>, CartRepository {

    Optional<Cart> findByName(String name);

}
