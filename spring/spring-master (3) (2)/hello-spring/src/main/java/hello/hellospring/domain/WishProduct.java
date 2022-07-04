package hello.hellospring.domain;

import javax.persistence.*;

@Entity
@Table(name="wishproduct")
public class WishProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public String getWishproductname() {
        return wishproductname;
    }

    public void setWishproductname(String wishproductname) {
        this.wishproductname = wishproductname;
    }
    private String wishproductname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
