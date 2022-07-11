package hello.hellospring.repository;

import hello.hellospring.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaSellerRepository extends JpaRepository<Seller, Long>, SellerRepository {
}
