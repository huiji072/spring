package hello.hellospring.domain;

import java.io.Serializable;

public class CartId implements Serializable {

    private Long memberid;
    private Long productid;

    public CartId(Long memberid, Long productid) {
        this.memberid = memberid;
        this.productid = productid;
    }
}
