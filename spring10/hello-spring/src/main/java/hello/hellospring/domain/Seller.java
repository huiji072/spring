package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seller {

    @Id
    private Long sellerid;

    public Long getSellerid() {
        return sellerid;
    }

    public void setSellerid(Long sellerid) {
        this.sellerid = sellerid;
    }
}
