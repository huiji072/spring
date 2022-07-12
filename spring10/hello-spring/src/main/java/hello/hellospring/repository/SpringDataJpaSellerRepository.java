package hello.hellospring.repository;

import hello.hellospring.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaSellerRepository extends JpaRepository<Seller, Long>, SellerRepository {

    Optional<Seller> findById(Long id);
    Optional<Seller> findByMemberid(Long memberid);

}
