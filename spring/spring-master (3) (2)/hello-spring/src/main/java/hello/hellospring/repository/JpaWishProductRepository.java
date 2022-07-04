package hello.hellospring.repository;

import hello.hellospring.domain.WishProduct;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaWishProductRepository implements WishProductRepository{

    private final EntityManager em;

    public JpaWishProductRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<WishProduct> findAll() {
        return em.createQuery("select w from wishproduct w", WishProduct.class)
                .getResultList();
    }
}
