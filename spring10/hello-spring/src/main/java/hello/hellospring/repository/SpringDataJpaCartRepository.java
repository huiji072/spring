package hello.hellospring.repository;

import hello.hellospring.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataJpaCartRepository extends JpaRepository<Cart, Long>, CartRepository {
//    @Modifying
//    @Query("update Cart c set c.qty=:qty where c.name=:name")
//    int updateCart(@Param(value="name") String name, @Param(value = "qty") int qty);

}
