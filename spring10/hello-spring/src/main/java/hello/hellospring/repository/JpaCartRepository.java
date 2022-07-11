package hello.hellospring.repository;

import hello.hellospring.domain.Cart;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaCartRepository implements CartRepository{

    private final EntityManager em;

    public JpaCartRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Cart save(Cart cart) {
        em.persist(cart);
        return cart;
    }

    @Override
    public Optional<Cart> findByMemberid(Long memberid) {
        Cart cart = em.find(Cart.class, memberid);
        return Optional.ofNullable(cart);
    }

    @Override
    public Optional<Cart> findByProductid(Long productid) {
        Cart cart = em.find(Cart.class, productid);
        return Optional.ofNullable(cart);
    }

    @Override
    public Optional<Cart> findByCartqty(int cartqty) {
        Cart cart = em.find(Cart.class, cartqty);
        return Optional.ofNullable(cart);
    }

    @Override
    public List<Cart> findAll() {
        return em.createQuery("select c from Cart c", Cart.class)
                .getResultList();
    }
}
