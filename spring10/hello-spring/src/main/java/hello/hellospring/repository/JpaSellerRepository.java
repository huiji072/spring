package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Seller;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaSellerRepository implements SellerRepository{

    private final EntityManager em;

    public JpaSellerRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Seller save(Seller seller) {
        em.persist(seller);
        return seller;
    }

    @Override
    public Optional<Seller> findById(Long id) {
        Seller seller = em.find(Seller.class, id);
        return Optional.ofNullable(seller);
    }

    //member.id와 seller.memberid의 겹치는 값 찾기
    @Override
    public Optional<Seller> findByMemberid(Long memberid) {
        Seller seller = em.find(Seller.class, memberid);
        return Optional.ofNullable(seller);
//        return em.createQuery("select s from Seller s where s.memberid = :memberid", Seller.class)
//                .setParameter("memberid", memberid)
//                .getResultList();
////
//        List<Long> result2 =  em.createQuery("select s.memberid from Seller s where s.memberid = :memberid", Long.class)
//                .setParameter("memberid", memberid)
//                .getResultList();
//
//        System.out.println(result2.size());;
//        System.out.println(result.size());;
//
//        return result.stream().findAny();
    }


    @Override
    public List<Seller> findAll() {
        return em.createQuery("select s from Seller s", Seller.class)
                .getResultList();
    }
}
