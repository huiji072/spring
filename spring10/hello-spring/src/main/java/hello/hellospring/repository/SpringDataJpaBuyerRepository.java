package hello.hellospring.repository;

import hello.hellospring.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaBuyerRepository extends JpaRepository<Buyer, Long>, BuyerRepository {
}
