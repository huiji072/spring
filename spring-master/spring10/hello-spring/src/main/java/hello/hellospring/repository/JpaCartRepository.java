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
        cart.setQty(3);
        em.persist(cart);
        return cart;
    }


    @Override
    public Optional<Cart> findById(Long memberid) {
        Cart cart = em.find(Cart.class, memberid);
        return Optional.ofNullable(cart);
    }

    @Override
    public Optional<Cart> findByName(String name) {
        Cart cart = em.find(Cart.class, name);
//        cart.setQty(1); //name 이미 존재하면 상품 갯수 증가
        return Optional.ofNullable(cart);
    }

    @Override
    public Optional<Cart> findByQty(int qty) {
        Cart cart = em.find(Cart.class, qty);
        return Optional.ofNullable(cart);
    }


    @Override
    public List<Cart> findAll() {
        return em.createQuery("select c from Cart c", Cart.class)
                .getResultList();
    }


//    @Override
//    public Cart findByQty(int qty) {
//        Cart cart = new Cart();
//        return em.createQuery("update cart set qty=qty+1 where name= :name", Cart.class)
//                .setParameter("name", cart.getName())
//                .getSingleResult();
//    }
}
