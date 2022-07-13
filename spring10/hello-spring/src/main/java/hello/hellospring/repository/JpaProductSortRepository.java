package hello.hellospring.repository;

import hello.hellospring.domain.Product;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class JpaProductSortRepository implements ProductOrderRepository{

    private final EntityManager em;

    public JpaProductSortRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Product> findAll() {
        Product product = new Product();
        return em.createQuery("select p from Product p order by p.name = :name", Product.class)
                .setParameter("name", product.getName())
                .getResultList();
    }
}
