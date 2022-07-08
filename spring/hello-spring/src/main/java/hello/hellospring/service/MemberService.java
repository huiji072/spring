package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 이메일 검사
        memberRepository.save(member);
        return member.getId(); //id 값이 유일하기 때문에
    }

    //중복 이메일 검사
    private void validateDuplicateMember(Member member) {

        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일 입니다");
                        }
                );
    }

    public boolean login(Member member) {
        if(memberRepository.findByEmail(member.getEmail()).isPresent() &&
        memberRepository.findByPassword(member.getPassword()).isPresent()) {
            return true;
        }
        return false;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }


}
