package hello.hellospring.repository;

import hello.hellospring.domain.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerRepository {

    Seller save(Seller seller);
    Optional<Seller> findById(Long id);
    Optional<Seller> findByMemberid(Long memberid);
//    List<Seller> findByMemberid();
    List<Seller> findAll();

}
