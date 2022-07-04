package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //test가 종료되면]] 메모리 db 저장된 데이터 삭제 - 독립성
    @AfterEach
    public void afterEach() {
        repository.cleareSotre();
    }

    //member 이름을 spring으로 지정하고 저장한 후 레포지토리에 저장된 이름과 같은지 비교
    @Test
    void save() {
        //given
        Member member = new Member();
        member.setEmail("spring");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByEmail() {
        //given
        Member member1 = new Member();
        member1.setEmail("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setEmail("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByEmail("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member();
        member1.setEmail("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setEmail("spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

}