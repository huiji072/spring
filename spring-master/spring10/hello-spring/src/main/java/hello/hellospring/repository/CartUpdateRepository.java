package hello.hellospring.repository;

import hello.hellospring.domain.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CartUpdateRepository extends CrudRepository<Cart, Long> {

    @Modifying
    @Query("update Cart c set c.qty = :qty where c.id = :id")
    void updatePhone(@Param(value = "id") long id, @Param(value = "qty") int qty);

}
