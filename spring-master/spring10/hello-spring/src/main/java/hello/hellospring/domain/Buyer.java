package hello.hellospring.domain;

import javax.persistence.*;

@Entity
@Table(name="buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="memberid")
    private Long memberid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberid", insertable = false, updatable = false)
    private Member member;

}
