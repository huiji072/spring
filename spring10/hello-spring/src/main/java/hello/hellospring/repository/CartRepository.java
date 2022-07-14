package hello.hellospring.repository;

import hello.hellospring.domain.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository{

    Cart save(Cart cart);
    Optional<Cart> findById(Long memberid);
    Optional<Cart> findByName(String name);
    Optional<Cart> findByQty(int qty);
    List<Cart> findAll();
//    int setFixedQty(String id, int qty);

}
