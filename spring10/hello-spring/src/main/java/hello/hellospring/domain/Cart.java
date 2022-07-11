package hello.hellospring.domain;

import javax.persistence.*;

@Entity
@IdClass(CartId.class) //@Id 여러개 지정하기 위해서
public class Cart {

    @Id
    private Long memberid;
    @Id
    private Long productid;
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
