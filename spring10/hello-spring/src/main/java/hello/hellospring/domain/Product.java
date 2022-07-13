package hello.hellospring.domain;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userid;
    private String name;
    private int qty;
    @Column(name = "createdate")
    Instant createdate = Instant.now();
    @Column(name = "updatedate")
    Instant updatedate = Instant.now();

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

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
