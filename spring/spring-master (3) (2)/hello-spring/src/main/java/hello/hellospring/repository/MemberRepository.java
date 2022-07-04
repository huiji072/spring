package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //저장
    Optional<Member> findById(Long id); //id검색
    Optional<Member> findByEmail(String email); //name검색
    Optional<Member> findByPassword(String password); //pw검색?
    List<Member> findAll(); //member 검색
//    boolean loginMember(Member member);
}
