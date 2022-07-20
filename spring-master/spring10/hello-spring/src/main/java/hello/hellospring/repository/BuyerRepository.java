package hello.hellospring.repository;

import hello.hellospring.domain.Buyer;

import java.util.List;
import java.util.Optional;

public interface BuyerRepository {

    Buyer save(Buyer buyer);
    Optional<Buyer> findById(Long id);
    Optional<Buyer> findByMemberid(Long memberid);
    List<Buyer> findAll();
}
