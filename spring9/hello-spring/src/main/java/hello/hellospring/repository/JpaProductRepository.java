package hello.hellospring.repository;

import hello.hellospring.domain.Cart;
import hello.hellospring.domain.Product;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaProductRepository implements ProductRepository{

    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = em.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> findByName(String name) {
        List<Product> result = em.createQuery("select p from Product p where p.name = :name", Product.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Product> findByQty(int qty) {
        List<Product> result = em.createQuery("select p from Product p where p.aty = :qty", Product.class)
                .setParameter("qty", qty)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }


    //장바구니에 담기
//    @Override
//    public Cart addCart(Cart cart) {
//        em.persist(cart);
//        return cart;
//    }
//
//    //장바구니 목록 출력
//    @Override
//    public List<Cart> findByCart() {
//        return em.createQuery("select c from Cart c", Cart.class)
//                .getResultList();
//    }
}
