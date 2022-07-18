package hello.hellospring.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="PRODUCT")
public class Product {
    public Product() {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="userid")
    private Long userid;
    @Column(name="NAME")
    private String name;
    @Column(name="qty")
    private int qty;
    @Column(name = "createdate")
    Instant createdate = Instant.now();
    @Column(name = "updatedate")
    Instant updatedate = Instant.now();
    @Column(name="image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Instant getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Instant createdate) {
        this.createdate = createdate;
    }

    public Instant getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Instant updatedate) {
        this.updatedate = updatedate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
