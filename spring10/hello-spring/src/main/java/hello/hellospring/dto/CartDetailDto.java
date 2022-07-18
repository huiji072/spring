package hello.hellospring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartDetailDto {

    private Long id;
    private String name;
    private int qty;
    private String img;

    public CartDetailDto(Long id, String name, int qty, String img) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.img = img;
    }
}
