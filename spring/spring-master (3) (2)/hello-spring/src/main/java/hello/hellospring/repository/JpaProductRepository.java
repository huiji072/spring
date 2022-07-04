package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import hello.hellospring.domain.WishProduct;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaProductRepository implements ProductRepository{
    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }
//
//    @Override
//    public List<WishProduct> findByWishAll() {
//        return em.createQuery("select w from wishproduct w", WishProduct.class)
//                .getResultList();
//    }

    //상품등록
    @Override
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public WishProduct save(WishProduct wishProduct) {
        em.persist(wishProduct);
        return wishProduct;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = em.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> findByproductName(String productName) {
//        List<Product> result = em.createQuery("select m from Product m where m.productName = :productName", Product.class)
//                .setParameter("productName", productName)
//                .getResultList();
//        return result.stream().findAny();
        Product product = em.find(Product.class, productName);
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

//    @Override
//    public List<WishProduct> findByWishAll() {
//        return null;
//    }


}
