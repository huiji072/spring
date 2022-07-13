package hello.hellospring.service;

import hello.hellospring.domain.Cart;
import hello.hellospring.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Long join(Cart cart) {
        cartRepository.save(cart);
        return cart.getId();
    }

    public List<Cart> findCarts() {
        return cartRepository.findAll();
    }

}
