package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

    }

//    public boolean login(Member member) {
//        if(memberRepository.findByEmail(member.getEmail()).isPresent() &&
//        memberRepository.findByPassword(member.getPassword()).isPresent()) {
//            return true;
//        }
//        return false;
//    }

    public Member login(String email, String password) {
        return memberRepository.findByEmail(email)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


//    soft delete

    public Member create(Member member) {
        return memberRepository.save(member);
    }

    public void remove(Long id){
        memberRepository.deleteById(id);
    }

    public Iterable<Member> findAll(){
        return memberRepository.findAll();
    }

}
