//package hello.hellospring.domain;
//
//import hello.hellospring.service.MemberService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class MemberTest {
//
//    @Autowired
//    MemberService memberService;
//
//    public Member createMember() {
//        MemberForm form = new MemberForm();
//        form.setEmail("test");
//        form.setPassword("1234");
//        return Member.createMemebr(form);
//    }
//
//    @Test
//    @DisplayName("test1")
//    public void saveMemberTest() {
//        Member member = createMember();
//        Member sabedMember = memberService.join(member);
//
//        assertEquals(member.getEmail(), sabedMember.getEmail());
//        assertEquals(member.getRole(), sabedMember.getRole());
//
//
//    }
//
//
//}