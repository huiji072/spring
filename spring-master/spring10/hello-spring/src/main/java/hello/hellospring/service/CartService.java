package hello.hellospring.service;

import hello.hellospring.domain.Cart;
import hello.hellospring.repository.CartRepository;
import hello.hellospring.repository.SpringDataJpaCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

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

    public Optional<Cart> findByName(String name) {
        return cartRepository.findByName(name);
    }

    public List<Cart> findCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> findByQty(int qty){
        return cartRepository.findByQty(qty);
    }

    @Modifying
    @Query("update Cart c set c.qty=5 where c.name = :name")
    public int updateQty(int qty, String name){
        return qty+1;
    }


    //이미 있는 상품이면 true
    public boolean validateDuplicateQty(Cart cart) {

        if(cartRepository.findByName(cart.getName()).isPresent()){
            cart.setQty(cart.getQty()+1);
            return true;
        }
        return false;
    }





}
