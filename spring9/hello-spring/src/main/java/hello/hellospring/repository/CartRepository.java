package hello.hellospring.repository;

import hello.hellospring.domain.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository {

    Cart save(Cart cart);
    Optional<Cart> findByMemberid(Long memberid);
    Optional<Cart> findByProductid(Long productid);
    Optional<Cart> findByCartqty(int cartqty);

}
