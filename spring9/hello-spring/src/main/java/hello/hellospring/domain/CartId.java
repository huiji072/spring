package hello.hellospring.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class CartId implements Serializable {

    private Long memberid;
    private Long productid;
    @Autowired
    public CartId(Long memberid, Long productid) {
        this.memberid = memberid;
        this.productid = productid;
    }

    //default constructor
    public CartId() {

    }
}
