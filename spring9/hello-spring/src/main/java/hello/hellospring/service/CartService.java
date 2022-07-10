package hello.hellospring.service;

import hello.hellospring.domain.Cart;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class CartService {

    private final CartRepository cartRepository;
    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Long addCart(Cart cart) {
        cartRepository.save(cart);
//        increaseQty(cart);
        return cart.getMemberid();
    }

    public boolean increaseQty(Cart cart) {

        if(cartRepository.findByMemberid(cart.getMemberid()).isPresent() &&
        cartRepository.findByProductid(cart.getProductid()).isPresent()){
            cart.setCartqty(cart.getCartqty()+1);
            return true;
        }
        return false;
    }

    //memberid 조회
    public Optional<Cart> findByMemberid(Long memberid) {
        return cartRepository.findByMemberid(memberid);
    }

    //productid 조회
    public Optional<Cart> findByProductid(Long productid) {
        return cartRepository.findByProductid(productid);
    }

    //cartqty 조회
    public Optional<Cart> findByCartqty(int cartqty) {
        return cartRepository.findByCartqty(cartqty);
    }

    public List<Cart> findCarts() {
        return cartRepository.findAll();
    }


}
