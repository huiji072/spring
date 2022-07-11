package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository  extends CrudRepository<Member, Long>{

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByPassword(String password);
    List<Member> findAll();

}
