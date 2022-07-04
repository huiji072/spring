package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member); //검증 후 회원 저장
        return member.getId();

    }

    //중복 회원 검증
    private void validateDuplicateMember(Member member) {
        //레포지토리에 name이 이미 존재하면 throw 발생
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public boolean login(Member member) {
        if ((memberRepository.findByEmail(member.getEmail()).isPresent()) &&
                (memberRepository.findByPassword(member.getPassword()).isPresent())) {
            return true;
        }
        return false;
    }


    //전체 회원 조회

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //id 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
