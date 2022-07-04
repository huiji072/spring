package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//스프링 데이터 jpa는 jpa를 편리하게 사용하도록 도와주는 기술
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByPassword(String password);
}