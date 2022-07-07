package hello.hellospring.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(CartId.class)
public class Cart implements Serializable{


    @Id
    @Column(name = "memberid")
    private Long memberid;

    @Id
    @Column(name = "productid")
    private Long productid;

    @Column(name="cartqty")
    private int cartqty;

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public int getCartqty() {
        return cartqty;
    }

    public void setCartqty(int cartqty) {
        this.cartqty = cartqty;
    }
}
