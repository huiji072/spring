package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    //test가 끝난 후 데이터 삭제 - 독립성
    @AfterEach
    public void afterEach() {
        memberRepository.cleareSotre();
    }

    @Test
    void join() throws Exception{

        //given
        Member member = new Member();
        member.setEmail("aaa");

        //when
        Long savdId = memberService.join(member);

        //then
//        레포지토리에 저장한 값 findeMember와 방금 넣은 member가 같은지 비교
        Member findMember = memberRepository.findById(savdId).get();
        assertEquals(member.getEmail(), findMember.getEmail());
    }

    //중복 회원 예외
    @Test
    void DuplicateMemberException() throws Exception{
        //given
        Member member1 = new Member();
        member1.setEmail("spring");

        Member member2 = new Member();
        member2.setEmail("spring");

        //when
        memberService.join(member1);

        //join한 member1의 값과 join하려는 member2의 값이 같으면 예외 발생
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

}