package hello.hellospring.repository;

import hello.hellospring.domain.Product;

import javax.persistence.EntityManager;
import java.time.Instant;
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
    public Optional<Product> findByUserid(Long userid) {
        Product product = em.find(Product.class, userid);
        return Optional.ofNullable(product);
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
//        List<Product> result = em.createQuery("select p.name from Product p where p.name = :name", Product.class)
//                .setParameter("name", name)
//                .getResultList();
//        return result.stream().findAny();
    }

    @Override
    public Optional<Product> findByQty(int qty) {
        Product product = em.find(Product.class, qty);
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> findByCreatedate(Instant createdate) {
        Product product = em.find(Product.class, createdate);
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> findByupdatedate(Instant updatedate) {
        Product product = em.find(Product.class, updatedate);
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }
    
    @Override
    public List<Product> findByNameLessThanOrderByName(String name) {
        return em.createQuery("select p from Product p order by p.name", Product.class)
                .setParameter("name", name)
                .getResultList();
    }


    //like 절
    @Override
    public Optional<Product> findByNameLike(String name) {
        return Optional.empty();
    }




}
