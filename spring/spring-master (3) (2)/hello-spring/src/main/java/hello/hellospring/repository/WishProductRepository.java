package hello.hellospring.repository;

import hello.hellospring.domain.WishProduct;

import java.util.List;

public interface WishProductRepository {
    List<WishProduct> findAll();
}
