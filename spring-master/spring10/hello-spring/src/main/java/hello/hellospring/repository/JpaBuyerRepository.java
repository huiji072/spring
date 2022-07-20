package hello.hellospring.repository;

import hello.hellospring.domain.Buyer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaBuyerRepository implements BuyerRepository{

    private final EntityManager em;

    public JpaBuyerRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Buyer save(Buyer buyer) {
        em.persist(buyer);
        return buyer;
    }

    @Override
    public Optional<Buyer> findById(Long id) {
        Buyer buyer = em.find(Buyer.class, id);
        return Optional.ofNullable(buyer);
    }

    @Override
    public Optional<Buyer> findByMemberid(Long memberid) {
        Buyer buyer = em.find(Buyer.class, memberid);
        return Optional.ofNullable(buyer);
    }

    @Override
    public List<Buyer> findAll() {
        return em.createQuery("select b from Buyer b", Buyer.class)
                .getResultList();
    }
}
