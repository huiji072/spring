package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//회원가입 중복 로그인 전체조회
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException();
                });
    }

    public boolean login(Member member) {

        if(memberRepository.findByEmail(member.getEmail()).isPresent() &&
                (memberRepository.findByPassword(member.getPassword())).isPresent()) {
            return true;
        }
        return false;

    }

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

}
