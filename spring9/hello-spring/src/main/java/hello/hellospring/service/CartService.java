package hello.hellospring.service;

import hello.hellospring.domain.Cart;
import hello.hellospring.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CartService {

    private final CartRepository cartRepository;
    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Long addCart(Cart cart) {
        cartRepository.save(cart);
        return cart.getMemberid();
    }

}
