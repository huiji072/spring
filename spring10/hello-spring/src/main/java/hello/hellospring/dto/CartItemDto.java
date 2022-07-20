package hello.hellospring.dto;

import lombok.Getter;
import lombok.Setter;
//장바구니에 담을 상품의 아이디와 수량을 전달받을 클래스
@Getter @Setter
public class CartItemDto {

    private Long id;
    private String name;
    private int qty;
    private String img;

    public CartItemDto(Long id, String name, int qty, String img) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.img = img;
    }
}
