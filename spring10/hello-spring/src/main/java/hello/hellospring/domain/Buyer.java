package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Buyer {

    @Id
    private Long buyerid;

    public Long getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Long buyerid) {
        this.buyerid = buyerid;
    }
}
