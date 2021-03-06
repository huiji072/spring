package hello.hellospring.repository;

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
        Product product = em.find(Product.class, name);
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> findByQty(int qty) {
        Product product = em.find(Product.class, qty);
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }
}
